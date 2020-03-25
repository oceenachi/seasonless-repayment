package seasonlessrepayments.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import seasonlessrepayments.model.CustomerSummaries;

import javax.transaction.Transactional;
import java.util.List;

public interface CustomerSummariesRepository extends JpaRepository<CustomerSummaries, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE CustomerSummaries summary SET summary.totalRepaid = ?1 WHERE summary.customerID = ?2")
    void updateTotalRepaid(Long newRepaid, Long customerID);


    @Query("select summary from CustomerSummaries summary inner join Seasons seasons on " +
            "seasons.seasonsId = summary.seasonID where summary.customerID = ?1 and summary.totalCredit > summary.totalRepaid order by seasons.startDate")
    List<CustomerSummaries> findUniqueCustomerSeasons(Long customerId);
}
