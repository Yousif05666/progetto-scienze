package com.example.demo.controller;

import com.example.demo.service.WordService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/game")
public class GameController {

    @Autowired
    private WordService2 wordService;

    private static final int NUM_PAIRS = 10; // Numero di parole (5 coppie)

    // Mostra la pagina del gioco (GET request)
    @GetMapping
    public String showGamePage(Model model) {
        model.addAttribute("message", "Benvenuto nel gioco!");
        model.addAttribute("showSolutions", true); // Inizialmente visibile
        model.addAttribute("words", wordService.getRandomWords(NUM_PAIRS)); // Ottieni parole casuali dal servizio
        return "game";  // Indirizza alla vista 'game.html'
    }

    // Mostra le soluzioni del gioco (POST request)
    @PostMapping("/show-solutions")
    public String showSolutions(Model model) {
        model.addAttribute("message", "Soluzioni del gioco visualizzate.");
        model.addAttribute("showSolutions", true); // Imposta per visualizzare le soluzioni
        model.addAttribute("words", wordService.getCurrentWords()); // Usa le stesse parole
        return "game";  // Indirizza alla vista 'game.html'
    }

    // Nascondi le parole 2 (POST request)
    @PostMapping("/hide-words")
    public String hideWords(Model model) {
        model.addAttribute("message", "Le parole sono nascoste, inserisci le tue soluzioni.");
        model.addAttribute("showSolutions", false); // Nascondi la tabella delle parole 2
        model.addAttribute("words", wordService.getCurrentWords()); // Usa le stesse parole
        return "game";  // Indirizza alla vista 'game.html'
    }

    // Cambia le parole (POST request)
    @PostMapping("/change-words")
    public String changeWords(Model model) {
        model.addAttribute("message", "Le parole sono state cambiate.");
        model.addAttribute("showSolutions", true); // Ripristina la visualizzazione delle parole
        model.addAttribute("words", wordService.getRandomWords(NUM_PAIRS)); // Preleva nuove parole casuali
        return "game";  // Indirizza alla vista 'game.html'
    }
}
