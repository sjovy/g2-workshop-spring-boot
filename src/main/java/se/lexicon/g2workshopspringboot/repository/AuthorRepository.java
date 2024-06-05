package se.lexicon.g2workshopspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.g2workshopspringboot.entity.Author;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    List<Author> findByFirstNameIgnoreCase(String firstName);

    List<Author> findByLastNameIgnoreCase(String lastName);

    List<Author> findByFirstNameContainsIgnoreCaseOrLastNameContainsIgnoreCase(String firstName, String lastName);

    @Query("SELECT a FROM Author a JOIN a.writtenBooks b WHERE b.id = :bookId")
    List<Author> findAuthorsByBookId(@Param("bookId") int bookId);

    @Transactional
    @Modifying
    @Query("UPDATE Author a SET a.firstName = :firstName, a.lastName = :lastName WHERE a.id = :id")
    void updateAuthorNameById(@Param("id") int id, @Param("firstName") String firstName, @Param("lastName") String lastName);

    @Transactional
    @Modifying
    void deleteById(int id);
}
