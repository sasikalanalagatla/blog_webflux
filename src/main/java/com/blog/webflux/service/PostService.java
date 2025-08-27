package com.blog.webflux.service;

import com.blog.webflux.dto.PostDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostService {
    Mono<PostDto> createPost(PostDto postDto);

    Mono<PostDto> getPostById(String postId);

    Flux<PostDto> getAllPosts();

    Mono<PostDto> updatePostById(String postId, PostDto postDto);

    Mono<Void> deletePostById(String postId);
}
