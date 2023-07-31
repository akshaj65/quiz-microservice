package com.akshaj.questionservice.dao;

import com.akshaj.questionservice.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionDao  extends JpaRepository<Question,String> {
    List<Question> findByDifficultyLevel(String level);

    Optional<Question> findById(Integer id);

    List<Question> findByCategory(String category);

    @Query(value = "SELECT q.id FROM question q WHERE q.category = :category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Integer> findRandomQuestionByCategory(int numQ, String category);
}



