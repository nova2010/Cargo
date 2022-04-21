package by.leonenya.cargotrans.service;

import by.leonenya.cargotrans.model.Order;
import by.leonenya.cargotrans.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    public OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    public void save(Order order) {
        orderRepository.save(order);
    }

    public Order findById(Long id) {
        return orderRepository.getById(id);
    }
}
