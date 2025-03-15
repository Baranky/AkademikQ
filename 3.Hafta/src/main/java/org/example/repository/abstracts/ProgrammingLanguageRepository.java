package org.example.repository.abstracts;

import org.example.entity.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageRepository {
    void  add(ProgrammingLanguage programmingLanguage) ;
    List<ProgrammingLanguage>  getAll();
    void delete(int id);
    void  update(int id,ProgrammingLanguage programmingLanguage);
    ProgrammingLanguage getById(int id);
}
