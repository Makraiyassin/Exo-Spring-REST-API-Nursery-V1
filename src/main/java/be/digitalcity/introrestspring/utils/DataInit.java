package be.digitalcity.introrestspring.utils;

import be.digitalcity.introrestspring.model.entities.Child;
import be.digitalcity.introrestspring.model.entities.Tutor;
import be.digitalcity.introrestspring.services.ChildService;
import be.digitalcity.introrestspring.services.TutorService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


@Service
public class DataInit implements InitializingBean {
    private final ChildService childService;
    private final TutorService tutorService;

    private List<Tutor> tutorList = Arrays.asList(
            new Tutor("rufat","rufat","0485010203","digitalcity",null),
            new Tutor("sebastien","sebastien","0485010203","digitalcity",null),
            new Tutor("yassin","yassin","0485010203","digitalcity",null),
            new Tutor("marcelo","marcelo","0485010203","digitalcity",null)
    );
    private List<Child> childList = Arrays.asList(
            new Child("max","max",true,LocalDate.of(1992,1,1), null, null),
            new Child("therence","therence",true,LocalDate.of(1992,1,1), null, null),
            new Child("chidi","chidi",true,LocalDate.of(1992,1,1), null, null),
            new Child("james","james",true,LocalDate.of(1992,1,1), null, null)

    );

    public DataInit(ChildService childService, TutorService tutorService) {
        this.childService = childService;
        this.tutorService = tutorService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        childList.forEach(childService::save);
        tutorList.forEach(tutorService::save);
    }
}
