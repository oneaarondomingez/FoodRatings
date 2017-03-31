package com.example.myapplication.utils;

import com.example.myapplication.data.ratings.entities.establishments.Establishment;

import java.util.List;
import java.util.TreeMap;

/**
 * Created by user on 3/30/17.
 */

public class EstablishmentsMapper {
    public static TreeMap<String, Double> establishmentsToMap(List<Establishment> establishments) {
        TreeMap<String, Double> map = new TreeMap<>();

        for (Establishment establishment : establishments) {
            String rating = establishment.getRatingValue();
            Double frequencyRating = map.get(rating);

            if (frequencyRating == null) {
                map.put(rating, 1.0);
            } else {
                map.put(rating, frequencyRating + 1);
            }
        }

        return map;
    }
}
