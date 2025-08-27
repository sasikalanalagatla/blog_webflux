package com.blog.webflux.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "posts")
public class Post {

    @Id
    private String id;
    private String postTitle;
    private String postExcerpt;
    private String postContent;
    private String author;
    private LocalDateTime postPublishedAt;
    private boolean postIsPublished;
    private LocalDateTime postCreatedAt;
    private LocalDateTime postUpdatedAt;
    private List<String> tagIds;
    private List<String> commentIds;

    public Post() {}

    public Post(String id, String postTitle, String postExcerpt, String postContent, String author,
                LocalDateTime postPublishedAt, boolean postIsPublished,
                LocalDateTime postCreatedAt, LocalDateTime postUpdatedAt,
                List<String> tagIds, List<String> commentIds) {
        this.id = id;
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

    // Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPostTitle() { return postTitle; }
    public void setPostTitle(String postTitle) { this.postTitle = postTitle; }

    public String getPostExcerpt() { return postExcerpt; }
    public void setPostExcerpt(String postExcerpt) { this.postExcerpt = postExcerpt; }

    public String getPostContent() { return postContent; }
    public void setPostContent(String postContent) { this.postContent = postContent; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public LocalDateTime getPostPublishedAt() { return postPublishedAt; }
    public void setPostPublishedAt(LocalDateTime postPublishedAt) { this.postPublishedAt = postPublishedAt; }

    public boolean isPostIsPublished() { return postIsPublished; }
    public void setPostIsPublished(boolean postIsPublished) { this.postIsPublished = postIsPublished; }

    public LocalDateTime getPostCreatedAt() { return postCreatedAt; }
    public void setPostCreatedAt(LocalDateTime postCreatedAt) { this.postCreatedAt = postCreatedAt; }

    public LocalDateTime getPostUpdatedAt() { return postUpdatedAt; }
    public void setPostUpdatedAt(LocalDateTime postUpdatedAt) { this.postUpdatedAt = postUpdatedAt; }

    public List<String> getTagIds() { return tagIds; }
    public void setTagIds(List<String> tagIds) { this.tagIds = tagIds; }

    public List<String> getCommentIds() { return commentIds; }
    public void setCommentIds(List<String> commentIds) { this.commentIds = commentIds; }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
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