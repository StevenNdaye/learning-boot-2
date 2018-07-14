package com.learning.boot.first_exercise.repository;

import com.learning.boot.first_exercise.entities.Chapter;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapterRepository extends ReactiveCrudRepository<Chapter, String> {
}
