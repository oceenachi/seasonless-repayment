package seasonlessrepayments.repository;

import com.oaf.seasonless.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customers, Long> {
}
