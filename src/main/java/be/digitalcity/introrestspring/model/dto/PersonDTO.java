package be.digitalcity.introrestspring.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonDTO {
    private Long id;
    private String lastName;
    private String firstName;

    public PersonDTO(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }
}
