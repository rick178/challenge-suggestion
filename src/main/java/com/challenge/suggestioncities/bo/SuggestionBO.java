package com.challenge.suggestioncities.bo;

import com.challenge.suggestioncities.models.Cities;

import java.util.List;

public interface SuggestionBO {

    List<Cities> getScoredSuggestedMatches(String q, Double latitude, Double longitude);
    Double calculateRelativeDistance(Double lat1, Double lon1, Double lat2, Double lon2);

}
