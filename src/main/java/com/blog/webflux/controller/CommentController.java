package com.blog.webflux.controller;

import com.blog.webflux.dto.CommentDto;
import com.blog.webflux.model.Post;
import com.blog.webflux.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentServiceImpl commentService;

    @PostMapping("/create")
    public Mono<CommentDto> createComment(@RequestBody CommentDto commentDto){
        return commentService.createComment(commentDto);
    }

    @GetMapping("/{commentId}")
    public Mono<CommentDto> getCommentById(@PathVariable String commentId){
        return commentService.getCommentById(commentId);
    }

    @GetMapping("/all")
    public Flux<CommentDto> getComments(){
        return commentService.getComments();
    }

    @PutMapping("/update/{commentId}")
    public Mono<CommentDto> updateComment(@PathVariable String commentId, @RequestBody CommentDto commentDto){
        return commentService.updateComment(commentId, commentDto);
    }

    @DeleteMapping("delete/{commentId}")
    public Mono<Void> deleteComment(@PathVariable String commentId){
        return commentService.deleteComment(commentId);
    }
}
