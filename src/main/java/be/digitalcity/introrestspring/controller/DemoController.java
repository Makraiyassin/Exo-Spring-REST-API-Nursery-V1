package be.digitalcity.introrestspring.controller;

import be.digitalcity.introrestspring.model.dto.PersonDTO;
import be.digitalcity.introrestspring.model.entities.Person;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @GetMapping("/person")
    public PersonDTO getPerson() {
        return new PersonDTO(
                "Makrai",
                "Yassin"

        );
    }

    @PostMapping("/person")
    public void writePerson(@RequestBody Person person, @RequestParam("repetition") int iter){

        for (int i = 0; i < iter ; i++) {
            System.out.println(person);
        }
    }

    @GetMapping("/headers")
    public void writeArtificialHeader(@RequestHeader String header){
        System.out.println(header);
    }

    @GetMapping("/headers/all")
    public void writeArtificialHeaderAll(@RequestHeader HttpHeaders headers){
        for (String key : headers.keySet()) {
            System.out.println(key + " " + headers.get(key));
        }
    }

    @GetMapping(path = "/demo/{id:[0-8]{1,3}}")
    public void demoPathVar(@PathVariable int id){
        System.out.println("id => "+id);
    }

    @GetMapping("/request")
    public void recupRequest(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request);
        System.out.println(response);
    }

    @GetMapping("/person/new")
    public ResponseEntity<PersonDTO> getPersonne(@RequestParam("lastName") String lastName, @RequestParam("firstName") String firstName ){
        PersonDTO body = new PersonDTO(lastName,firstName);
        HttpHeaders headers = new HttpHeaders();
        headers.add("artificial2", "value");
//        HttpStatus status = HttpStatus.OK;
//        return new ResponseEntity<>(body, headers, status);
        return ResponseEntity.status(HttpStatus.OK)
                .header("artificial","value 1", "value 2")
                .headers(headers)
                .body(body);
    }

}
