package com.backend.movierental.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private Integer movieID;
    private String title;
    private String genre;
    private int releaseYear;
    private int stock;
    private double rentalRate;

    private byte[] image;

}
