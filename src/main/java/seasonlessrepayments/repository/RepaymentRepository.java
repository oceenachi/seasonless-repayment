package seasonlessrepayments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seasonlessrepayments.model.Repayments;

public interface RepaymentRepository extends JpaRepository<Repayments, Long> {
}
