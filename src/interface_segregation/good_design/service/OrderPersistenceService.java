package interface_segregation.good_design.service;

import interface_segregation.good_design.entity.Order;

import java.util.HashMap;

public class OrderPersistenceService implements PersistenceService<Order> {
    private static final HashMap<Long, Order> ORDERS = new HashMap<>();

    @Override
    public void save(Order entity) {
        synchronized (ORDERS) {
            ORDERS.put(entity.getId(), entity);
        }
    }

    @Override
    public void delete(Order entity) {
        synchronized (ORDERS) {
            ORDERS.remove(entity.getId());
        }
    }

    @Override
    public Order findById(Long id) {
        synchronized (ORDERS) {
            return ORDERS.get(id);
        }
    }
}
