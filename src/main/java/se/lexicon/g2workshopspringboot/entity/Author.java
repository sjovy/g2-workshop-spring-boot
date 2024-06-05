package se.lexicon.g2workshopspringboot.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(exclude = "writtenBooks")
@ToString(exclude = "writtenBooks")
@NoArgsConstructor
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    @ManyToMany
    @JoinTable(
        name = "author_book",
        joinColumns = @JoinColumn(name = "author_id"),
        inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Book> writtenBooks;

    public void addBook(Book book) {
        writtenBooks.add(book);
        book.getAuthors().add(this);
    }

    public void removeBook(Book book) {
        writtenBooks.remove(book);
        book.getAuthors().remove(this);
    }

    public Author(String firstName, String lastName, Set<Book> writtenBooks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.writtenBooks = writtenBooks;
    }
}
