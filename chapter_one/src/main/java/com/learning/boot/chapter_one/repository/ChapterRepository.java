package com.learning.boot.chapter_one.repository;

import com.learning.boot.chapter_one.entities.Chapter;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapterRepository extends ReactiveCrudRepository<Chapter, String> {
}
