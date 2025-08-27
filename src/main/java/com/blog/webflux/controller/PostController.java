package com.blog.webflux.controller;

import com.blog.webflux.dto.PostDto;
import com.blog.webflux.model.Post;
import com.blog.webflux.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostServiceImpl postService;

    @PostMapping("/save")
    public Mono<PostDto> createPost(@RequestBody PostDto postDto){
        return postService.createPost(postDto);
    }

    @GetMapping("{postId}")
    public Mono<PostDto> getPostById(@PathVariable String postId){
        return postService.getPostById(postId);
    }

    @GetMapping("/all")
    private Flux<PostDto> getAllPosts(){
        return postService.getAllPosts();
    }

    @PutMapping("/update/{postId}")
    public Mono<PostDto> updatePostById(@PathVariable String postId, @RequestBody PostDto postDto){
        return postService.updatePostById(postId,postDto);
    }

    @DeleteMapping("/delete/{postId}")
    public Mono<Void> deletePostById(@PathVariable String postId){
        return postService.deletePostById(postId);
    }

    @GetMapping("/search")
    public Flux<Post> searchPosts(
            @RequestParam(required = false) String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "desc") String sortOrder) {

        return postService.searchPosts(keyword, page, size, sortOrder);
    }
}
