package com.blog.webflux.dto;

import jakarta.validation.constraints.NotBlank;

public class TagDto {

    private String tagId;

    @NotBlank(message = "Tag name cannot be blank")
    private String name;

    public TagDto() {}

    public TagDto(String tagId, String name) {
        this.tagId = tagId;
        this.name = name;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TagDto{" +
                "tagId='" + tagId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}