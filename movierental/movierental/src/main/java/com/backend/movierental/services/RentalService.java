package com.backend.movierental.services;

import com.backend.movierental.models.Movie;
import com.backend.movierental.models.Rental;
import com.backend.movierental.repositories.MovieRepository;
import com.backend.movierental.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RentalService {

    @Autowired
    private MovieRepository movieRepo;

    @Autowired
    private RentalRepository rentalRepo;

    // We are going to have the due date 3 days after
    public boolean rentMovie(int customerID, int movieID) {
        Movie movie = movieRepo.getMovieById(movieID);
        if (movie == null || movie.getStock() <= 0) {
            return false;
        }

        Rental rental = new Rental();
        rental.setCustomerID(customerID);
        rental.setMovieID(movieID);
        rental.setRentalDate(LocalDateTime.now());
        rental.setDueDate(LocalDateTime.now().plusDays(3));
        rental.setReturnDate(null);
        rental.setStatus("RENTED");

        rentalRepo.createRental(rental);
        movieRepo.decreaseStock(movieID);

        return true;
    }
}
