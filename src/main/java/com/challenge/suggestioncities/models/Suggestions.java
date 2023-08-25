package com.challenge.suggestioncities.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
public class Suggestions {
    @Getter
    @Setter
    private List<Cities> suggestions;
}
