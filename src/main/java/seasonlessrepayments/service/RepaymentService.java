package seasonlessrepayments.service;

import org.springframework.stereotype.Service;
import seasonlessrepayments.model.CustomerSummaries;
import seasonlessrepayments.model.RepaymentUploads;
import seasonlessrepayments.model.Repayments;
import seasonlessrepayments.repository.CustomerSummariesRepository;
import seasonlessrepayments.repository.RepaymentRepository;
import seasonlessrepayments.repository.RepaymentUploadsRepository;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class RepaymentService {

    RepaymentUploadsRepository repaymentUploadsRepository;
    CustomerSummariesRepository customerSummariesRepository;
    RepaymentRepository repaymentRepository;

    private RepaymentService(RepaymentUploadsRepository repaymentUploadsRepository,
                             CustomerSummariesRepository customerSummariesRepository, RepaymentRepository repaymentRepository){
        this.repaymentUploadsRepository = repaymentUploadsRepository;
        this.customerSummariesRepository = customerSummariesRepository;
        this.repaymentRepository = repaymentRepository;

    }

    @PostConstruct
    public void repayDebts(){
        List<RepaymentUploads> allUploads = repaymentUploadsRepository.findAll();

        for(RepaymentUploads oneUpload: allUploads){
            Long amount = oneUpload.getAmount();
            assert amount > 0;
            if(oneUpload.getSeasonID() > 0 || oneUpload.getSeasonID() != null){
               List<CustomerSummaries> currentCustomerSummary = repaymentUploadsRepository.joinUploadsCustomerSummaries();
                for(CustomerSummaries summary: currentCustomerSummary){
                    Long newTotal = summary.getTotalRepaid() + amount;
                    customerSummariesRepository.updateTotalRepaid(newTotal, oneUpload.getCustomerID());
                    Repayments repayments = new Repayments();
                    repayments.setAmount(amount);
                    repayments.setCustomerId(oneUpload.getCustomerID());
                    repayments.setDate(oneUpload.getDate());
                    repayments.setSeasonId(oneUpload.getSeasonID());
                    repaymentRepository.save(repayments);
                }

            }
            else {
                
            }

        }

    }



}
