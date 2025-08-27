package com.blog.webflux.service.impl;

import com.blog.webflux.dto.PostDto;
import com.blog.webflux.mapper.PostMapper;
import com.blog.webflux.model.Post;
import com.blog.webflux.model.Tag;
import com.blog.webflux.repository.CommentRepository;
import com.blog.webflux.repository.PostRepository;
import com.blog.webflux.repository.TagRepository;
import com.blog.webflux.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ReactiveMongoTemplate mongoTemplate;

    @Override
    public Mono<PostDto> createPost(PostDto postDto) {
        Post post = PostMapper.toEntity(postDto);

        if (!post.isPostIsPublished()){
            post.setPostIsPublished(false);
            post.setPostPublishedAt(null);
        }
        post.setPostCreatedAt(LocalDateTime.now());

        return saveOrCreateTags(postDto.getTagIds())
                .collectList()
                .flatMap(tags -> {
                    List<String> tagIds = new ArrayList<>();
                    for (Tag tag : tags) {
                        tagIds.add(tag.getId());
                    }
                    post.setTagIds(tagIds);
                    return postRepository.save(post);
                })
                .map(PostMapper::toDto);
    }

    @Override
    public Mono<PostDto> getPostById(String postId) {
        return postRepository.findById(postId)
                .map(PostMapper :: toDto);
    }

    @Override
    public Flux<PostDto> getAllPosts() {
        return postRepository.findAll()
                .map(PostMapper :: toDto);
    }

    @Override
    public Mono<PostDto> updatePostById(String postId, PostDto postDto) {
        Mono<Post> actualPost = postRepository.findById(postId);
        return actualPost.flatMap(updatedPost -> {
            updatedPost.setId(postDto.getPostId());
            updatedPost.setPostContent(postDto.getPostContent());
            updatedPost.setPostExcerpt(postDto.getPostExcerpt());
            updatedPost.setPostIsPublished(postDto.isPostIsPublished());
            updatedPost.setPostCreatedAt(postDto.getPostCreatedAt());
            updatedPost.setPostTitle(postDto.getPostTitle());
            updatedPost.setAuthor(postDto.getAuthor());
            updatedPost.setCommentIds(postDto.getCommentIds());
            updatedPost.setTagIds(postDto.getTagIds());
            updatedPost.setPostUpdatedAt(postDto.getPostUpdatedAt());
            updatedPost.setPostPublishedAt(postDto.getPostPublishedAt());
            return postRepository.save(updatedPost);
        }).map(PostMapper :: toDto);

    }

    @Override
    public Mono<Void> deletePostById(String postId) {
        return commentRepository.findByPostId(postId)
                .flatMap(comment -> commentRepository.deleteById(comment.getId()))
                .then(postRepository.deleteById(postId));
    }

    @Override
    public Flux<Post> searchPosts(String keyword, int page, int size, String sortOrder) {
        Criteria criteria = new Criteria();

        if (keyword != null && !keyword.isBlank()) {
            criteria = new Criteria().orOperator(
                    Criteria.where("postTitle").regex(keyword, "i"),
                    Criteria.where("postContent").regex(keyword, "i"),
                    Criteria.where("author").regex(keyword, "i")
            );
        }

        Sort sort = Sort.by(
                "desc".equalsIgnoreCase(sortOrder) ? Sort.Direction.DESC : Sort.Direction.ASC,
                "createdAt"
        );

        Pageable pageable = PageRequest.of(page, size, sort);

        Query query = Query.query(criteria).with(pageable);

        return mongoTemplate.find(query, Post.class);
    }

    private Flux<Tag> saveOrCreateTags(List<String> tagIds) {
        if (tagIds == null || tagIds.isEmpty()) {
            return Flux.empty();
        }

        List<Mono<Tag>> tagMonos = new ArrayList<>();
        for (String tagId : tagIds) {
            tagMonos.add(tagRepository.findById(tagId)
                    .switchIfEmpty(createNewTag(tagId)));
        }
        return Flux.concat(tagMonos);
    }

    private Mono<Tag> createNewTag(String tagId) {
        Tag newTag = new Tag();
        newTag.setId(tagId);
        newTag.setName("Tag-" + tagId);
        newTag.setCreatedAt(LocalDateTime.now());
        return tagRepository.save(newTag);
    }
}
