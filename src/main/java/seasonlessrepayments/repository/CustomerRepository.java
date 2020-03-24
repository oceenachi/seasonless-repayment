package seasonlessrepayments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seasonlessrepayments.model.Customers;

public interface CustomerRepository extends JpaRepository<Customers, Long> {
}
