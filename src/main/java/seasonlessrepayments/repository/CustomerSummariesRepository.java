package seasonlessrepayments.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import seasonlessrepayments.model.CustomerSummaries;

public interface CustomerSummariesRepository extends JpaRepository<CustomerSummaries, Long> {
}
