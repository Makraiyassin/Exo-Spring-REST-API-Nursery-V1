package be.digitalcity.introrestspring.model.dto;

import be.digitalcity.introrestspring.model.entities.Tutor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ChildDTO extends PersonDTO{

    private boolean clean;
    private LocalDate birthDate;
    private List<String> allergies;
    private Set<Tutor> tutorSet;

    public ChildDTO(Long id, String lastName, String firstName, boolean clean, LocalDate birthDate, List<String> allergies, Set<Tutor> tutorSet) {
        super(id, lastName, firstName);
        this.clean = clean;
        this.birthDate = birthDate;
        this.allergies = allergies;
        this.tutorSet = tutorSet;
    }
}



