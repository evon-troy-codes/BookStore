package com.example.geektext.Controller;

import com.example.geektext.Entity.Books;
import com.example.geektext.Service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksService booksService;

    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Books>> getBooksByGenre(@PathVariable String genre) {
        List<Books> books = booksService.getBooksByGenre(genre);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/best-sellers")
    public ResponseEntity<List<Books>> getBestSellingBooks() {
        List<Books> books = booksService.getBestSellingBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/rating/{rating}")
    public ResponseEntity<List<Books>> getBooksByRating(@PathVariable int rating) {
        List<Books> books = booksService.getBooksByRating(rating);
        if (books != null && !books.isEmpty()) {
            return ResponseEntity.ok(books);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}





// GET http://localhost:8080/books/genre/Fantasy    for genre
// GET http://localhost:8080/books/best-sellers   for best-seller
// GET http://localhost:8080/books/rating/5 for rating