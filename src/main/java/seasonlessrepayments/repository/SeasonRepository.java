package seasonlessrepayments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seasonlessrepayments.model.Seasons;

public interface SeasonRepository extends JpaRepository<Seasons, Long> {
}
