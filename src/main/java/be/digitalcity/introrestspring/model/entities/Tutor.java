package be.digitalcity.introrestspring.model.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Tutor extends Person {
    @Column(name = "phone_number")
    private String  phoneNumber;

    private String adress;

    @ManyToMany(mappedBy = "tutorSet")
    private Set<Child> childSet;

    public Tutor(String lastName, String firstName, String phoneNumber, String adress, Set<Child> childSet) {
        super(lastName, firstName);
        this.phoneNumber = phoneNumber;
        this.adress = adress;
        this.childSet = childSet;
    }
}
