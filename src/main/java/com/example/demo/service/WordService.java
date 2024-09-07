package com.example.demo.service;

import com.example.demo.model.word;
import com.example.demo.repository.WordRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class WordService {
    private final WordRepository wordRepository;

    public WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public List<word> getRandomWords(int count) {
        List<word> allWords = wordRepository.findAll();

        // Restituisce tutte le parole se sono meno del numero richiesto
        if (allWords.size() <= count) {
            return allWords;
        }

        // Mescola e restituisce un sottoinsieme delle parole
        Collections.shuffle(allWords, new Random());
        return allWords.subList(0, count);
    }
}
