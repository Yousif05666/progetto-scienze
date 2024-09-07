package com.example.demo.service;

import com.example.demo.model.Word2;
import com.example.demo.repository.WordRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WordService2 {

    @Autowired
    private WordRepository2 wordRepository;

    private List<Map<String, String>> wordPairs = new ArrayList<>();

    // Ottiene coppie di parole casuali
    public List<Map<String, String>> getRandomWords(int count) {
        List<Word2> allWords = wordRepository.findTopNByLimit(count);
        Collections.shuffle(allWords);
        wordPairs.clear(); // Pulisce le coppie di parole precedenti

        for (int i = 0; i < count / 2; i++) {
            Map<String, String> pair = new HashMap<>();
            String word1 = allWords.get(i).getWord();
            String word2 = allWords.get(i + count / 2).getWord();
            pair.put("word1", word1);
            pair.put("word2", word2);
            wordPairs.add(pair);
        }

        return wordPairs;
    }

    // Restituisce le coppie di parole correnti
    public List<Map<String, String>> getCurrentWords() {
        return wordPairs;
    }
}
