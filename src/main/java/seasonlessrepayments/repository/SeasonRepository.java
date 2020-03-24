package seasonlessrepayments.repository;

import com.oaf.seasonless.model.Seasons;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepository extends JpaRepository<Seasons, Long> {
}
