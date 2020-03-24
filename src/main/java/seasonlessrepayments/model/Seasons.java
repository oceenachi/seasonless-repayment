package seasonlessrepayments.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Seasons {

    @Id
    private Long seasonsId;

    @NotBlank
    private String name;

    private String startDate;

    private Long endDate;

    public Long getSeasonsId() {
        return seasonsId;
    }

    public void setSeasonsId(Long seasonsId) {
        this.seasonsId = seasonsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Seasons(){

    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Long getEndDate() {
        return endDate;
    }

    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }

    public Seasons(Long seasonsId, String name, String startDate, Long endDate) {
        this.seasonsId = seasonsId;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

}
