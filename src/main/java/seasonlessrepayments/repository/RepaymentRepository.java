package seasonlessrepayments.repository;

import com.oaf.seasonless.model.Repayments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepaymentRepository extends JpaRepository<Repayments, Integer> {
}
