package seasonlessrepayments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import seasonlessrepayments.model.CustomerSummaries;
import seasonlessrepayments.model.RepaymentUploads;

import javax.transaction.Transactional;
import java.util.List;

public interface RepaymentUploadsRepository extends JpaRepository<RepaymentUploads, Long> {

    @Query("SELECT customerSummaries FROM RepaymentUploads Repayment INNER JOIN CustomerSummaries customerSummaries" +
            " ON Repayment.customerID = customerSummaries.customerID")
    List<CustomerSummaries> joinUploadsCustomerSummaries();


}
