package com.blog.webflux.mapper;

import com.blog.webflux.dto.TagDto;
import com.blog.webflux.model.Tag;

public class TagMapper {

    public static Tag toEntity(TagDto dto) {
        if (dto == null) return null;

        Tag tag = new Tag();
        tag.setId(dto.getTagId());
        tag.setName(dto.getName());
        return tag;
    }

    public static TagDto toDto(Tag tag) {
        if (tag == null) return null;

        TagDto dto = new TagDto();
        dto.setTagId(tag.getId());
        dto.setName(tag.getName());
        return dto;
    }
}