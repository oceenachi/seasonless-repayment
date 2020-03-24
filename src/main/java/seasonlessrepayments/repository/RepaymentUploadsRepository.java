package seasonlessrepayments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seasonlessrepayments.model.RepaymentUploads;

public interface RepaymentUploadsRepository extends JpaRepository<RepaymentUploads, Long> {

//    @Query("select Repayment from RepaymentUploads Repayment")
//    List<RepaymentUploads>  getAllRepayments();
}
