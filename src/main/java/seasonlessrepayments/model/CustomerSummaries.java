package seasonlessrepayments.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class CustomerSummaries {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private Long customerID;

    @NotNull
    private Long seasonID;

    @NotNull
    private Long totalRepaid;

    @NotNull
    private Long totalCredit;

    public CustomerSummaries() {
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public Long getSeasonID() {
        return seasonID;
    }

    public void setSeasonID(Long seasonID) {
        this.seasonID = seasonID;
    }

    public Long getTotalRepaid() {
        return totalRepaid;
    }

    public void setTotalRepaid(Long totalRepaid) {
        this.totalRepaid = totalRepaid;
    }

    public Long getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(Long totalCredit) {
        this.totalCredit = totalCredit;
    }


}
