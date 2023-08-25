package com.challenge.suggestioncities.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "data_suggestion")
@ToString

public class Cities {
    @Id
    @Getter @Setter @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter @Setter @Column(name = "name")
    private String name;
    @Getter @Setter @Column(name = "lat")
    private String latitude;
    @Getter @Setter @Column(name = "lon")
    private String longitude;
}
