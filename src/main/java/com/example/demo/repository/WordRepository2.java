package com.example.demo.repository;

import com.example.demo.model.Word2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WordRepository2 extends JpaRepository<Word2, Long> {
    @Query(value = "SELECT * FROM word ORDER BY RAND() LIMIT :limit", nativeQuery = true)
    List<Word2> findTopNByLimit(@Param("limit") int limit);
}
