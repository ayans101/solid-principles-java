package interface_segregation.good_design.service;

import interface_segregation.good_design.entity.Entity;

public interface PersistenceService<T extends Entity> {
    public void save(T entity);

    public void delete(T entity);

    public T findById(Long id);
}
