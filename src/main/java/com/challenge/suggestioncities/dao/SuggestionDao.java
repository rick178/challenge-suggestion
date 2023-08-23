package com.challenge.suggestioncities.dao;

import com.challenge.suggestioncities.models.Cities;

import java.util.List;

public interface SuggestionDao {

    List<Cities> getCities (String q, Long latitude, Long longitude);
}
