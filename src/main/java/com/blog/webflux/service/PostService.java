package com.blog.webflux.service;

import com.blog.webflux.dto.PostDto;
import com.blog.webflux.model.Post;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostService {
    Mono<PostDto> createPost(PostDto postDto);

    Mono<PostDto> getPostById(String postId);

    Flux<PostDto> getAllPosts();

    Mono<PostDto> updatePostById(String postId, PostDto postDto);

    Mono<Void> deletePostById(String postId);

    Flux<Post> searchPosts(String keyword, int page, int size, String sortOrder);
}
