package be.digitalcity.introrestspring.services;

import be.digitalcity.introrestspring.model.entities.Child;
import be.digitalcity.introrestspring.model.entities.Tutor;
import be.digitalcity.introrestspring.repository.TutorRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class TutorService implements CrudService<Tutor,Long> {
    private final TutorRepository tutorRepository;

    public TutorService(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    @Override
    public Tutor getOne(Long id) {
        return this.tutorRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Tutor> getAll() {
        return this.tutorRepository.findAll();
    }

    @Override
    public Tutor create(Tutor tutor) {
        return null;
    }

    @Override
    public Tutor update(Tutor tutor) {
        return this.tutorRepository.save(tutor);
    }

    @Override
    public boolean delete(Long id) {
        Tutor tutorToDelete = getOne(id);
        if(tutorToDelete == null) return false;
        this.tutorRepository.delete(tutorToDelete);
        return true;
    }
}
