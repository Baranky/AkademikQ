package org.example.repository.abstracts;

import org.example.entity.Technology;
import java.util.List;

public interface TechnologyRepository {
    void  add(Technology technology) ;
    List<Technology> getAll();
    void delete(int id);
    void  update(int id,Technology technology);
    Technology getById(int id);
}
