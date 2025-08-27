package com.blog.webflux.mapper;

import com.blog.webflux.dto.CommentDto;
import com.blog.webflux.model.Comment;

public class CommentMapper {

    public static Comment toEntity(CommentDto dto) {
        if (dto == null) return null;

        Comment comment = new Comment();
        comment.setId(dto.getCommentId());
        comment.setPostId(dto.getPostId());
        comment.setAuthor(dto.getAuthor());
        comment.setContent(dto.getContent());
        comment.setCreatedAt(dto.getCreatedAt());
        comment.setUpdatedAt(dto.getUpdatedAt());
        return comment;
    }

    public static CommentDto toDto(Comment comment) {
        if (comment == null) return null;

        CommentDto dto = new CommentDto();
        dto.setCommentId(comment.getId());
        dto.setPostId(comment.getPostId());
        dto.setAuthor(comment.getAuthor());
        dto.setContent(comment.getContent());
        dto.setCreatedAt(comment.getCreatedAt());
        dto.setUpdatedAt(comment.getUpdatedAt());
        return dto;
    }
}