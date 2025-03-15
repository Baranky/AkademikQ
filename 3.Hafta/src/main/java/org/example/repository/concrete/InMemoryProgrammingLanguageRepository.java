package org.example.repository.concrete;

import org.example.entity.ProgrammingLanguage;
import org.example.repository.abstracts.ProgrammingLanguageRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository {
    private  List<ProgrammingLanguage> programmingLanguageList;

    public InMemoryProgrammingLanguageRepository() {
        programmingLanguageList=new ArrayList<>();
    }

    @Override
    public void add(ProgrammingLanguage programmingLanguage) {
        System.out.println("programlama dili eklendi");
        programmingLanguageList.add(programmingLanguage);
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        System.out.println("programlama dili listesi");
        return programmingLanguageList;
    }

    @Override
    public void delete(int id) {
        for (ProgrammingLanguage programmingLanguage : programmingLanguageList)
            if (programmingLanguage.getId()== id) {
                programmingLanguageList.remove(programmingLanguage);
            }
    }

    @Override
    public void update(int id,ProgrammingLanguage updateProgrammingLanguage) {
        for (ProgrammingLanguage programmingLanguage : programmingLanguageList)
            if (programmingLanguage.getId()==id) {
                programmingLanguage.setId(programmingLanguage.getId());//mevcut id koruma
                programmingLanguage.setName(updateProgrammingLanguage.getName());

            }
    }

    @Override
    public ProgrammingLanguage getById(int id) {
        for (ProgrammingLanguage programmingLanguage : programmingLanguageList)
            if (programmingLanguage.getId() == id) {
                return programmingLanguage;
            }
        return null;
    }
}
