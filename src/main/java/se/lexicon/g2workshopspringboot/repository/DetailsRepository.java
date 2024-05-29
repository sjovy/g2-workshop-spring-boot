package se.lexicon.g2workshopspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.g2workshopspringboot.entity.Details;

@Repository
public interface DetailsRepository extends JpaRepository<Details,String> {
    Details findDetailsByEmail(String email);
    Details findDetailsByNameContains(String name);
    Details findDetailsByNameIgnoreCase(String name);
}
