package com.blog.webflux.service;

import com.blog.webflux.dto.CommentDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CommentService {
    Mono<CommentDto> createComment(CommentDto commentDto);

    Mono<CommentDto> getCommentById(String commentId);

    Flux<CommentDto> getComments();

    Mono<CommentDto> updateComment(String commentId, CommentDto commentDto);

    Mono<Void> deleteComment(String commentId);
}
