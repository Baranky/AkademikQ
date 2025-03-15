package org.example.repository.concrete;

import org.example.entity.Technology;
import org.example.repository.abstracts.TechnologyRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTechnologyRepository implements TechnologyRepository {
    private List<Technology> technologyList;

    public InMemoryTechnologyRepository() {
        technologyList = new ArrayList<>();
    }

    @Override
    public void add(Technology technology) {
        System.out.println("teknoloji eklendi");
        technologyList.add(technology);
    }

    @Override
    public List<Technology> getAll() {
        System.out.println("teknoloji listesi");
        return technologyList;
    }

    @Override
    public void delete(int id) {
        for (Technology technology : technologyList)
            if (technology.getId() == id) {
                technologyList.remove(technology);
            }
    }

    @Override
    public void update(int id,Technology updateTechnology) {
        for (Technology technology : technologyList)
            if (technology.getId()== id) {
               technology.setId(technology.getId());
               technology.setName(updateTechnology.getName());
               technology.setProgrammingLanguage(updateTechnology.getProgrammingLanguage());
            }
    }

    @Override
    public Technology getById(int id) {
        for (Technology technology : technologyList)
            if (technology.getId() == id) {
                return technology;
            }
        return null;
    }

}
