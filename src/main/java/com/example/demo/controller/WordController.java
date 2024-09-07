package com.example.demo.controller;

import com.example.demo.model.word;
import com.example.demo.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WordController {

    @Autowired
    private WordService wordService;

    @GetMapping("/random-words")
    public List<word> getRandomWords(@RequestParam int count) {
        return wordService.getRandomWords(count);
    }
}
