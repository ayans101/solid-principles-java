package interface_segregation.bad_design.service;

import interface_segregation.bad_design.entity.Entity;

import java.util.List;

public interface PersistenceService<T extends Entity> {
    public void save(T entity);

    public void delete(T entity);

    public T findById(Long id);

    public List<T> findByName(String name); // OrderPersistenceService is forced to implement this method
}
