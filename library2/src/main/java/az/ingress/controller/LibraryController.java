package az.ingress.controller;

import az.ingress.model.Author;
import az.ingress.model.Sale;
import az.ingress.model.Book;
import az.ingress.services.LibraryService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping()
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> book = libraryService.getAllBooks();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Library Header", "Hello from Library 2");

        return ResponseEntity.status(HttpStatus.OK)
                .headers(headers)
                .body(book);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        return libraryService.addBook(book);
    }

    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return libraryService.getAllAuthors();
    }

    @GetMapping("/sales")
    public ResponseEntity<List<Sale>> getAllSales() {
        List<Sale> sales = libraryService.getAllSales();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Library Header", "Hello from Library 2");

        return ResponseEntity.status(HttpStatus.OK)
                .headers(headers)
                .body(sales);
    }

    @PostMapping("/sales")
    public Sale addSale(@RequestBody Sale sale) {
        return libraryService.addSale(sale);
    }

    @GetMapping("/counter")
    public String getCounter() {
        return "Hello from library 2. Counter: " + libraryService.getCounter();
    }
}

