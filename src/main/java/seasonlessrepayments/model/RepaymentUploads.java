package seasonlessrepayments.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "repayment")
public class RepaymentUploads {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long customerID;

    private Long seasonID;

    @NotNull
    private String date;

    @NotNull
    private Long amount;

    public RepaymentUploads() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

}
