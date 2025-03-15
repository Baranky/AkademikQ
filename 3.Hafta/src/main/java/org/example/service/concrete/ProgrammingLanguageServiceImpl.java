package org.example.service.concrete;

import org.example.entity.ProgrammingLanguage;
import org.example.repository.abstracts.ProgrammingLanguageRepository;
import org.example.service.abstracts.ProgrammingLanguageService;

import java.util.List;

public class ProgrammingLanguageServiceImpl implements ProgrammingLanguageService {
    private final ProgrammingLanguageRepository repository;

    public ProgrammingLanguageServiceImpl(ProgrammingLanguageRepository repository) {
        this.repository = repository;
    }

    @Override
    public void add(ProgrammingLanguage programmingLanguage) {
        repository.add(programmingLanguage);
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return repository.getAll();
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public void update(int id,ProgrammingLanguage programmingLanguage) {
        repository.update(id,programmingLanguage);
    }

    @Override
    public ProgrammingLanguage getById(int id) {
        return repository.getById(id);
    }
}
