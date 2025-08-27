package com.blog.webflux.mapper;

import com.blog.webflux.dto.PostDto;
import com.blog.webflux.model.Post;

public class PostMapper {

    public static Post toEntity(PostDto dto) {
        if (dto == null) return null;

        Post post = new Post();
        post.setId(dto.getPostId());
        post.setPostTitle(dto.getPostTitle());
        post.setPostExcerpt(dto.getPostExcerpt());
        post.setPostContent(dto.getPostContent());
        post.setAuthor(dto.getAuthor());
        post.setPostPublishedAt(dto.getPostPublishedAt());
        post.setPostIsPublished(dto.isPostIsPublished());
        post.setPostCreatedAt(dto.getPostCreatedAt());
        post.setPostUpdatedAt(dto.getPostUpdatedAt());
        post.setTagIds(dto.getTagIds());
        post.setCommentIds(dto.getCommentIds());
        return post;
    }

    public static PostDto toDto(Post post) {
        if (post == null) return null;

        PostDto dto = new PostDto();
        dto.setPostId(post.getId());
        dto.setPostTitle(post.getPostTitle());
        dto.setPostExcerpt(post.getPostExcerpt());
        dto.setPostContent(post.getPostContent());
        dto.setAuthor(post.getAuthor());
        dto.setPostPublishedAt(post.getPostPublishedAt());
        dto.setPostIsPublished(post.isPostIsPublished());
        dto.setPostCreatedAt(post.getPostCreatedAt());
        dto.setPostUpdatedAt(post.getPostUpdatedAt());
        dto.setTagIds(post.getTagIds());
        dto.setCommentIds(post.getCommentIds());
        return dto;
    }
}