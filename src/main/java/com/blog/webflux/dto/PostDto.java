package com.blog.webflux.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.List;

public class PostDto {

    private String postId;

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 255, message = "Title must be between 3 and 255 characters")
    private String postTitle;

    @Size(max = 500, message = "Excerpt cannot exceed 500 characters")
    private String postExcerpt;

    @NotBlank(message = "Content is required")
    private String postContent;

    @NotBlank(message = "Author is required")
    private String author;

    private LocalDateTime postPublishedAt;
    private boolean postIsPublished;

    private LocalDateTime postCreatedAt;
    private LocalDateTime postUpdatedAt;

    private List<String> tagIds;
    private List<String> commentIds;

    public PostDto() {}

    public PostDto(String postId, String postTitle, String postExcerpt, String postContent, String author,
                   LocalDateTime postPublishedAt, boolean postIsPublished,
                   LocalDateTime postCreatedAt, LocalDateTime postUpdatedAt,
                   List<String> tagIds, List<String> commentIds) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postExcerpt = postExcerpt;
        this.postContent = postContent;
        this.author = author;
        this.postPublishedAt = postPublishedAt;
        this.postIsPublished = postIsPublished;
        this.postCreatedAt = postCreatedAt;
        this.postUpdatedAt = postUpdatedAt;
        this.tagIds = tagIds;
        this.commentIds = commentIds;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostExcerpt() {
        return postExcerpt;
    }

    public void setPostExcerpt(String postExcerpt) {
        this.postExcerpt = postExcerpt;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getPostPublishedAt() {
        return postPublishedAt;
    }

    public void setPostPublishedAt(LocalDateTime postPublishedAt) {
        this.postPublishedAt = postPublishedAt;
    }

    public boolean isPostIsPublished() {
        return postIsPublished;
    }

    public void setPostIsPublished(boolean postIsPublished) {
        this.postIsPublished = postIsPublished;
    }

    public LocalDateTime getPostCreatedAt() {
        return postCreatedAt;
    }

    public void setPostCreatedAt(LocalDateTime postCreatedAt) {
        this.postCreatedAt = postCreatedAt;
    }

    public LocalDateTime getPostUpdatedAt() {
        return postUpdatedAt;
    }

    public void setPostUpdatedAt(LocalDateTime postUpdatedAt) {
        this.postUpdatedAt = postUpdatedAt;
    }

    public List<String> getTagIds() {
        return tagIds;
    }

    public void setTagIds(List<String> tagIds) {
        this.tagIds = tagIds;
    }

    public List<String> getCommentIds() {
        return commentIds;
    }

    public void setCommentIds(List<String> commentIds) {
        this.commentIds = commentIds;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "postId='" + postId + '\'' +
                ", postTitle='" + postTitle + '\'' +
                ", postExcerpt='" + postExcerpt + '\'' +
                ", postContent='" + postContent + '\'' +
                ", author='" + author + '\'' +
                ", postPublishedAt=" + postPublishedAt +
                ", postIsPublished=" + postIsPublished +
                ", postCreatedAt=" + postCreatedAt +
                ", postUpdatedAt=" + postUpdatedAt +
                ", tagIds=" + tagIds +
                ", commentIds=" + commentIds +
                '}';
    }
}