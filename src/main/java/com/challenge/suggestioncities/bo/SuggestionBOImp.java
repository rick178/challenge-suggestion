package com.challenge.suggestioncities.bo;

import com.challenge.suggestioncities.dao.SuggestionDao;
import com.challenge.suggestioncities.models.Cities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SuggestionBOImp implements SuggestionBO{

    @Autowired
    SuggestionDao suggestionDao;
    @Override
    public List<Cities> getScoredSuggestedMatches(String q, Double latitude, Double longitude) {

         List<Cities> listCities = suggestionDao.getCities(q, null, null);

         for (Cities city : listCities){

             System.out.println("Ciudad: " + city.getName());
             System.out.println("Valor: " + calculateRelativeDistance(Double.valueOf(city.getLat()), Double.valueOf(city.getLon()), latitude, longitude));
         }
         return listCities;
    }
    @Override
    public Double calculateRelativeDistance (Double lat1, Double lon1, Double lat2, Double lon2){

        final int R = 6371;
        double latRad1 = Math.toRadians(lat1);
        double lonRad1 = Math.toRadians(lon1);
        double latRad2 = Math.toRadians(lat2);
        double lonRad2 = Math.toRadians(lon2);

        double latDiff = latRad2 - latRad1;
        double lonDiff = lonRad2 - lonRad1;

        double a = Math.sin(latDiff / 2) * Math.sin(latDiff / 2)
                + Math.cos(latRad1) * Math.cos(latRad2)
                * Math.sin(lonDiff / 2) * Math.sin(lonDiff / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return 1.0 - ((R * c)/1000);
    }


}
