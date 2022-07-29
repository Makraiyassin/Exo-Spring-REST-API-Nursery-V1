package be.digitalcity.introrestspring.repository;

import be.digitalcity.introrestspring.model.entities.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository<Tutor,Long> {
}
