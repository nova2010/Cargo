package by.leonenya.cargotrans.repository;

import by.leonenya.cargotrans.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
