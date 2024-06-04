package se.lexicon.g2workshopspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import se.lexicon.g2workshopspringboot.entity.BookLoan;

import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookLoanRepository extends JpaRepository<BookLoan, Integer> {

    List<BookLoan> findByBorrower_Id(int borrowerId);

    List<BookLoan> findByBook_Id(int bookId);

    List<BookLoan> findByReturnedFalse();

    List<BookLoan> findByDueDateBeforeAndReturnedFalse(LocalDate date);

    List<BookLoan> findByLoanDateBetween(LocalDate startDate, LocalDate endDate);

    @Transactional
    @Modifying
    @Query("UPDATE BookLoan bl SET bl.returned = true WHERE bl.id = :loanId")
    void markBookLoanAsReturned(int loanId);
}
