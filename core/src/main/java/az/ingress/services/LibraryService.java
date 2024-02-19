package az.ingress.services;

import az.ingress.model.Author;
import az.ingress.model.Book;
import az.ingress.model.Counter;
import az.ingress.model.Sale;
import az.ingress.repository.AuthorRepository;
import az.ingress.repository.BookRepository;
import az.ingress.repository.CounterRepository;
import az.ingress.repository.SaleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {
    private BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final SaleRepository saleRepository;
    private final CounterRepository counterRepository;

    public LibraryService(BookRepository bookRepository, AuthorRepository authorRepository, SaleRepository saleRepository, CounterRepository counterRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.saleRepository = saleRepository;
        this.counterRepository = counterRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book addBook(Book book) {
        // Add business logic if necessary
        return bookRepository.save(book);
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Sale getSaleById(Long Id) {
        Optional<Sale> optionalSale = Optional.of(saleRepository.getReferenceById(Id));
        return optionalSale.orElse(null);
    }

    @Transactional
    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    @Transactional
    public Sale addSale(Sale sale) {
        Counter counter = counterRepository.findById(1L).orElseGet(() -> {
            // Create a new Counter object and initialize the counter value to 0
            Counter newCounter = new Counter();
            newCounter.setCounter(0L); // Set counter value to 0
            return newCounter;
        });

        counter.setCounter(counter.getCounter() + 1);

        counterRepository.save(counter);
//
        return saleRepository.save(sale);
    }

    public Long getCounter() {
        Counter counter = counterRepository.findById(1L).orElseGet(Counter::new);

        return counter.getCounter();
    }

}
