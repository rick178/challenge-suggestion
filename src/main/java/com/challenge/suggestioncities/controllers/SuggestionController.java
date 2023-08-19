package com.challenge.suggestioncities.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SuggestionController {
    @RequestMapping(value = "suggestion", method = RequestMethod.GET)
    public String getSuggestion(){
        return "Hola";
    }
}
