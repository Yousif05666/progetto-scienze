package com.example.demo.controller;

import com.example.demo.model.word;
import com.example.demo.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Controller
@RequestMapping("/crossword")
@SessionAttributes("words")
public class CrosswordController {

    // Logger
    private static final Logger logger = LoggerFactory.getLogger(CrosswordController.class);

    @Autowired
    private WordService wordService;

    @GetMapping
    public String showCrosswordPage(Model model) {
        logger.info("Richiesta per la pagina del cruciverba ricevuta.");

        // Genera 5 parole casuali
        List<word> words = wordService.getRandomWords(5);

        if (words.isEmpty()) {
            logger.error("Non ci sono parole disponibili.");
            model.addAttribute("error", "Non ci sono parole disponibili.");
            return "crossword";
        }

        logger.info("Parole generate: {}", words);

        // Aggiungi le parole al modello
        model.addAttribute("words", words);
        model.addAttribute("showSolutions", false);
        logger.info("Parole aggiunte al modello e visualizzazione pronta.");

        return "crossword";  // Indirizza alla vista 'crossword.html'
    }

    @PostMapping("/show-solutions")
    public String showSolutions(Model model) {
        logger.info("Mostra soluzioni richiesto.");

        // Ottieni le parole correnti dalla sessione
        List<word> words = (List<word>) model.getAttribute("words");

        if (words == null) {
            logger.error("Nessuna parola trovata nella sessione.");
            return "redirect:/crossword";
        }

        // Mostra le soluzioni
        model.addAttribute("showSolutions", true);
        return "crossword";
    }

    @PostMapping("/update-crossword")
    public String updateCrossword(Model model) {
        logger.info("Aggiorna cruciverba richiesto.");

        // Genera nuove parole
        List<word> words = wordService.getRandomWords(5);

        if (words.isEmpty()) {
            logger.error("Non ci sono parole disponibili.");
            model.addAttribute("error", "Non ci sono parole disponibili.");
            return "crossword";
        }

        // Aggiorna le parole nella sessione
        model.addAttribute("words", words);
        model.addAttribute("showSolutions", false);

        return "crossword";
    }
}
