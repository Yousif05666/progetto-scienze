package com.example.demo.repository;

import com.example.demo.model.word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<word, Long> {
}
