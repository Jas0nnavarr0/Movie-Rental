package com.backend.movierental.repositories;

import com.backend.movierental.models.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public class RentalRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public int createRental(Rental r) {
        String sql = """
            INSERT INTO Rentals (movieID, customerID, rentalDate, dueDate, returnDate, status)
            VALUES (?, ?, ?, ?, ?, ?)
        """;
        // return date starts off as null when rented
        return jdbc.update(sql,
                r.getMovieID(),
                r.getCustomerID(),
                Timestamp.valueOf(r.getRentalDate()),
                Timestamp.valueOf(r.getDueDate()),
                null,
                r.getStatus()
        );
    }
}
