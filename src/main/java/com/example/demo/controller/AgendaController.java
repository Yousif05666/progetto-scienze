package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AgendaController {
    @GetMapping("/Agenda_Autobiografica")
    public String Agenda_Autobiografica(){
        return "Agenda_Autobiografica";
    }
}
