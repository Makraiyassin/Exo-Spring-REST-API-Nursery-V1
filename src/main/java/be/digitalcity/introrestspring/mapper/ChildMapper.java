package be.digitalcity.introrestspring.mapper;

import be.digitalcity.introrestspring.model.dto.ChildDTO;
import be.digitalcity.introrestspring.model.entities.Child;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class ChildMapper {

    public ChildDTO toChildDTO(Child child){
        return new ChildDTO(
                child.getId(),
                child.getLastName(),
                child.getFirstName(),
                child.isClean(),
                child.getBirthDate(),
                child.getAllergies(),
                child.getTutorSet()
        );
    }
    public Child toChilEntity(ChildDTO childDTO){
        return new Child(
                childDTO.getLastName(),
                childDTO.getFirstName(),
                childDTO.isClean(),
                childDTO.getBirthDate(),
                childDTO.getAllergies(),
                childDTO.getTutorSet()
        );
    }

}

