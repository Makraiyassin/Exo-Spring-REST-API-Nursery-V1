package be.digitalcity.introrestspring.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.implementation.bind.annotation.Super;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Child extends Person{
    private boolean clean;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @ElementCollection
    private List<String> allergies;

    @ManyToMany
    @JoinTable(
            name = "tutoring",
            joinColumns = @JoinColumn(name = "child_id"),
            inverseJoinColumns = @JoinColumn(name="tutor_id")
    )
    private Set<Tutor> tutorSet;

    public Child(String lastName, String firstName, boolean clean, LocalDate birthDate, List<String> allergies, Set<Tutor> tutorSet) {
        super(lastName, firstName);
        this.clean = clean;
        this.birthDate = birthDate;
        this.allergies = allergies;
        this.tutorSet = tutorSet;
    }

}
