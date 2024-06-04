package se.lexicon.g2workshopspringboot.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    @Setter private String isbn;

    @Column(nullable = false, unique = true)
    @Setter private String title;

    @Column(nullable = false)
    @Setter private int maxLoanDays;

    @OneToMany(mappedBy = "book")
    private List<BookLoan> bookLoans;

    public Book(String isbn, String title, int maxLoanDays) {
        this.isbn = isbn;
        this.title = title;
        this.maxLoanDays = maxLoanDays;
    }
}