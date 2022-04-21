package by.leonenya.cargotrans.repository;

import by.leonenya.cargotrans.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
