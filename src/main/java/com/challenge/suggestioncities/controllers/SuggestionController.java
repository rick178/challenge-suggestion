package com.challenge.suggestioncities.controllers;

import com.challenge.suggestioncities.bo.SuggestionBO;
import com.challenge.suggestioncities.dao.SuggestionDao;
import com.challenge.suggestioncities.models.Suggestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.challenge.suggestioncities.models.Cities;

import java.util.List;

@RestController
public class SuggestionController {

    @Autowired
    SuggestionBO suggestionBO;
    @RequestMapping(value = "suggestion", method = RequestMethod.GET)
    public Suggestions getSuggestion(@RequestParam(name = "q") String q,
                                     @RequestParam(name = "latitude", required = false) Double latitude,
                                     @RequestParam(name = "longitude", required = false) Double longitude){
        Suggestions suggestions = new Suggestions();
        List<Cities> cities= suggestionBO.getScoredSuggestedMatches(q, latitude, longitude);
        suggestions.setSuggestions(cities);
        return suggestions;
    }
}
