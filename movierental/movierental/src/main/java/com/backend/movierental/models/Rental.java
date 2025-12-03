package com.backend.movierental.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rental {
    private Integer rentalID;
    private Integer movieID;
    private Integer customerID;
    private LocalDateTime rentalDate;
    private LocalDateTime dueDate;
    private LocalDateTime returnDate;
    private String status; // The statuses will be rented, returned, and late
}
