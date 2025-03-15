package org.example.service.concrete;

import org.example.entity.Technology;
import org.example.repository.abstracts.TechnologyRepository;
import org.example.service.abstracts.TechnologyService;

import java.util.List;

public class TechnologyServiceImpl implements TechnologyService {
    private final TechnologyRepository repository;

    public TechnologyServiceImpl(TechnologyRepository repository) {
        this.repository = repository;
    }

    @Override
    public void add(Technology technology) {
        repository.add(technology);

    }

    @Override
    public List<Technology> getAll() {
        return repository.getAll();
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public void update(int id,Technology technology) {
        repository.update(id,technology);

    }

    @Override
    public Technology getById(int id) {
        return repository.getById(id);
    }
}
