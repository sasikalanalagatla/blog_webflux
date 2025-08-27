package com.blog.webflux.service.impl;

import com.blog.webflux.dto.CommentDto;
import com.blog.webflux.mapper.CommentMapper;
import com.blog.webflux.model.Comment;
import com.blog.webflux.model.Post;
import com.blog.webflux.repository.CommentRepository;
import com.blog.webflux.repository.PostRepository;
import com.blog.webflux.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public Mono<CommentDto> createComment(CommentDto dto) {
        Comment comment = new Comment(null, dto.getPostId(), dto.getAuthor(),
                dto.getContent(), LocalDateTime.now(), LocalDateTime.now());

        return commentRepository.save(comment)
                .flatMap(savedComment -> postRepository.findById(dto.getPostId())
                        .flatMap(post -> {
                            post.getCommentIds().add(savedComment.getId());
                            return postRepository.save(post).thenReturn(CommentMapper.toDto(savedComment));
                        })
                );
    }

    @Override
    public Mono<CommentDto> getCommentById(String commentId) {
       return commentRepository.findById(commentId).map(CommentMapper::toDto);
    }

    @Override
    public Flux<CommentDto> getComments() {
        return commentRepository.findAll().map(CommentMapper::toDto);
    }

    @Override
    public Mono<CommentDto> updateComment(String commentId, CommentDto commentDto) {
        return commentRepository.findById(commentId)
                .flatMap(existingComment -> {
                    existingComment.setContent(commentDto.getContent());
                    existingComment.setUpdatedAt(LocalDateTime.now());
                    return commentRepository.save(existingComment).thenReturn(CommentMapper.toDto(existingComment));
                })
                .switchIfEmpty(Mono.error(new RuntimeException("Comment not found")));
    }

    @Override
    public Mono<Void> deleteComment(String commentId) {
        return commentRepository.deleteById(commentId);
    }


}
