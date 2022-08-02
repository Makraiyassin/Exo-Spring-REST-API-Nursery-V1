package be.digitalcity.introrestspring.services;

import be.digitalcity.introrestspring.model.dto.ChildDTO;
import be.digitalcity.introrestspring.model.entities.Child;
import be.digitalcity.introrestspring.model.entities.Tutor;
import be.digitalcity.introrestspring.repository.ChildRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ChildService implements CrudService<Child,Long> {
    private final ChildRepository childRepository;

    public ChildService(ChildRepository childRepository) {
        this.childRepository = childRepository;
    }

    @Override
    public Child getOne(Long id) {
//        return this.childRepository.findById(id).orElseThrow(EntityNotFoundException::new);
            return this.childRepository.findById(id).orElse(null);
    }


    @Override
    public List<Child> getAll() {
        return this.childRepository.findAll();
    }

    @Override
    public Child create(Child child) {
        if(child == null) throw new IllegalArgumentException("Erreur, child null");
        return this.childRepository.save(child);
    }

    @Override
    public Child update(Child child) {
        if(child == null) throw new IllegalArgumentException("Erreur, child null");
        return this.childRepository.save(child);
    }

    @Override
    public boolean delete(Long id) {

        Child childToDelete = getOne(id);

        if (childToDelete == null) return false;

        this.childRepository.delete(childToDelete);
        return  true;
    }
}
