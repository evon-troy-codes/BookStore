package com.example.geektext.Service;

import com.example.geektext.Entity.Books;
import com.example.geektext.Repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BooksService {

    @Autowired
    private BookRepo bookRepo;

    public List<Books> getBooksByGenre(String genre) {
        return bookRepo.findByGenre(genre);
    }

    public List<Books> getBestSellingBooks() {
        return bookRepo.findByCopiesSoldGreaterThanEqual(10000);
    }

    public List<Books> getBooksByRating(double rating) {
        return bookRepo.findByRatingGreaterThanEqual((int) rating);
    }

}