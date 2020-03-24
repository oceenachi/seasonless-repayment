package seasonlessrepayments.repository;

import com.oaf.seasonless.model.RepaymentUploads;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepaymentUploadsRepository extends JpaRepository<RepaymentUploads, Long> {

//    @Query("select Repayment from RepaymentUploads Repayment")
//    List<RepaymentUploads>  getAllRepayments();
}
