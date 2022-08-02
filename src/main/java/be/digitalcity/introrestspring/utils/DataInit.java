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
import java.util.Set;


@Service
public class DataInit implements InitializingBean {
    private final ChildService childService;
    private final TutorService tutorService;
    public DataInit(ChildService childService, TutorService tutorService) {
        this.childService = childService;
        this.tutorService = tutorService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
         List<Tutor> tutorList = Arrays.asList(
                new Tutor("rufat","rufat","0485010203","digitalcity",null),
                new Tutor("Sarah","Sarah","0485010203","digitalcity",null),
                new Tutor("yassin","yassin","0485010203","digitalcity",null),
                new Tutor("marcelo","marcelo","0485010203","digitalcity",null)
        );

         List<Child> childList = Arrays.asList(
                new Child("max","max",true,LocalDate.of(1992,1,1), List.of("arachide","pollene"),Set.of(tutorList.get(0))),
                new Child("therence","therence",true,LocalDate.of(1992,1,1), null, Set.of(tutorList.get(0))),
                new Child("chidi","chidi",true,LocalDate.of(1992,1,1), null, Set.of(tutorList.get(2))),
                new Child("james","james",true,LocalDate.of(1992,1,1), null, Set.of(tutorList.get(3), tutorList.get(1)))

        );
        tutorList.forEach(tutorService::update);

        childList.forEach(childService::update);
    }
}
