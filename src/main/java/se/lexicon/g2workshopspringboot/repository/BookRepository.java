package se.lexicon.g2workshopspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import se.lexicon.g2workshopspringboot.entity.Book;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    Book findByIsbnIgnoreCase(String isbn);

    List<Book> findByTitleContainsIgnoreCase(String title);

    List<Book> findByMaxLoanDaysLessThan(int maxLoanDays);

    /*@Query("SELECT b FROM Book b WHERE b.id IN (SELECT bl.book.id FROM BookLoan bl WHERE bl.returned = false)")
    List<Book> findBooksCurrentlyOnLoan();

    @Query("SELECT b FROM Book b WHERE b.id IN (SELECT bl.book.id FROM BookLoan bl WHERE bl.dueDate < CURRENT_DATE AND bl.returned = false)")
    List<Book> findOverdueBooks();

    @Query("SELECT b FROM Book b WHERE b.id IN (SELECT bl.book.id FROM BookLoan bl WHERE bl.loanDate BETWEEN :startDate AND :endDate)")
    List<Book> findBooksLoanedBetween(LocalDate startDate, LocalDate endDate);*/

    @Query("SELECT b FROM Book b JOIN b.bookLoans bl WHERE bl.returned = false")
    List<Book> findBooksCurrentlyOnLoan();

    @Query("SELECT b FROM Book b JOIN b.bookLoans bl WHERE bl.dueDate < CURRENT_DATE AND bl.returned = false")
    List<Book> findOverdueBooks();

    @Query("SELECT b FROM Book b JOIN b.bookLoans bl WHERE bl.loanDate BETWEEN :startDate AND :endDate")
    List<Book> findBooksLoanedBetween(LocalDate startDate, LocalDate endDate);
}

