package seasonlessrepayments.repository;

import com.oaf.seasonless.model.CustomerSummaries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerSummariesRepository extends JpaRepository<CustomerSummaries, Long> {
}
