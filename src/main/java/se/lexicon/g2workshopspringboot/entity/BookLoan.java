package se.lexicon.g2workshopspringboot.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
public class BookLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @Setter private LocalDate loanDate;

    @Column(nullable = false)
    @Setter private LocalDate dueDate;

    @Column(nullable = false)
    @Setter private Boolean returned;

    @ManyToOne
    @JoinColumn(name = "borrower_id", nullable = false)
    @Setter private AppUser borrower;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    @Setter private Book book;

    public BookLoan(LocalDate loanDate, LocalDate dueDate, Boolean returned, AppUser borrower, Book book) {
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.returned = returned;
        this.borrower = borrower;
        this.book = book;
    }
}
