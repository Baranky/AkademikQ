package org.example;


import org.example.entity.ProgrammingLanguage;
import org.example.entity.Technology;
import org.example.repository.concrete.InMemoryProgrammingLanguageRepository;
import org.example.repository.concrete.InMemoryTechnologyRepository;
import org.example.service.abstracts.ProgrammingLanguageService;
import org.example.service.abstracts.TechnologyService;
import org.example.service.concrete.ProgrammingLanguageServiceImpl;
import org.example.service.concrete.TechnologyServiceImpl;

public class Main {
    public static void main(String[] args) {

        ProgrammingLanguage programmingLanguage=new ProgrammingLanguage(1,"java");
        ProgrammingLanguage programmingLanguage1=new ProgrammingLanguage(2,"C");

        ProgrammingLanguageService programmingLanguageService=new ProgrammingLanguageServiceImpl(new InMemoryProgrammingLanguageRepository()) ;
        programmingLanguageService.add(programmingLanguage);
        //programmingLanguageService.update(1,programmingLanguage1);
        System.out.println(programmingLanguageService.getById(1));

        System.out.println("-----------------------------------------------------------");

        Technology technology=new Technology(1,"spring boot",programmingLanguage);
        Technology technology1=new Technology(2,"C",programmingLanguage);

        TechnologyService technologyService=new TechnologyServiceImpl(new InMemoryTechnologyRepository());
        technologyService.add(technology);
        technologyService.update(1,technology1);
        System.out.println(technologyService.getById(1));
    }
}