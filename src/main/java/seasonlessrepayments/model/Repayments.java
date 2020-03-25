package seasonlessrepayments.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name =  "repayment_output")
public class Repayments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long repaymentID;

    @NotNull
    private Long customerId;

    @NotNull
    private Long seasonId;

    @NotNull
    private Date date;

    @NotNull
    private Long amount;

    private Long parentId;

    public Long getRepaymentID() {
        return repaymentID;
    }

    public void setRepaymentID(Long repaymentID) {
        this.repaymentID = repaymentID;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(Long seasonId) {
        this.seasonId = seasonId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

}
