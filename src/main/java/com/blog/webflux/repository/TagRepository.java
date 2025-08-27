package com.blog.webflux.repository;

import com.blog.webflux.model.Tag;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends ReactiveMongoRepository<Tag, String> {
}
