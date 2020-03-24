package seasonlessrepayments.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seasonlessrepayments.model.CustomerSummaries;
import seasonlessrepayments.model.Customers;
import seasonlessrepayments.model.RepaymentUploads;
import seasonlessrepayments.model.Seasons;
import seasonlessrepayments.repository.CustomerRepository;
import seasonlessrepayments.repository.CustomerSummariesRepository;
import seasonlessrepayments.repository.RepaymentUploadsRepository;
import seasonlessrepayments.repository.SeasonRepository;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Service
public class DataService {

    SeasonRepository seasonRepository;
    CustomerRepository customerRepository;
    RepaymentUploadsRepository repaymentUploadsRepository;
    CustomerSummariesRepository customerSummariesRepository;


    @Autowired
    public DataService(SeasonRepository seasonRepository, CustomerRepository customerRepository, RepaymentUploadsRepository repaymentUploadsRepository,
                       CustomerSummariesRepository customerSummariesRepository) throws FileNotFoundException,
            IOException, ParseException {
        this.seasonRepository = seasonRepository;
        this.customerRepository = customerRepository;
        this.repaymentUploadsRepository = repaymentUploadsRepository;
        this.customerSummariesRepository = customerSummariesRepository;

    }

    @PostConstruct
    public void loadData() {

        String fileName = "src/main/java/seasonlessrepayments/txt.json";

        File file = new File(fileName);

        JSONParser parser = new JSONParser();

        try {

            FileReader reader = new FileReader(file.getAbsolutePath());
            Object obj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray seasons = (JSONArray) jsonObject.get("Seasons");
            JSONArray customers = (JSONArray) jsonObject.get("Customers");
            JSONArray customerSummaries = (JSONArray) jsonObject.get("CustomerSummaries");
            JSONArray repaymentUploads = (JSONArray) jsonObject.get("RepaymentUploads");

            for (JSONObject data : (Iterable<JSONObject>) seasons) {
                assert false;
                Seasons newSeason = new Seasons();
                System.out.println(data.get("SeasonID"));
                newSeason.setSeasonsId((Long) data.get("SeasonID"));
                newSeason.setName((String) data.get("SeasonName"));
                newSeason.setEndDate((Long) data.get("EndDate"));
                newSeason.setStartDate((String) data.get("StartDate"));
                System.out.println("newSeason:" + newSeason);

                seasonRepository.save(newSeason);
            }

            for (JSONObject data : (Iterable<JSONObject>) customers) {
                assert false;
                System.out.println("data:" + data);
                Customers newCustomers = new Customers();
                newCustomers.setId((Long) data.get("CustomerID"));
                newCustomers.setCustomerName((String) data.get("CustomerName"));
                System.out.println("newCustomer:" + newCustomers);

                customerRepository.save(newCustomers);
            }

            for (JSONObject data : (Iterable<JSONObject>) repaymentUploads) {
                assert false;
                System.out.println("data:" + data);
                RepaymentUploads newRepaymentUploads = new RepaymentUploads();
                newRepaymentUploads.setCustomerID((Long) data.get("CustomerID"));
                newRepaymentUploads.setSeasonID((Long) data.get("SeasonID"));
                newRepaymentUploads.setAmount((Long) data.get("Amount"));
                newRepaymentUploads.setDate((String)data.get("Date"));

                System.out.println("newRepaymentUploads:" + newRepaymentUploads);

               repaymentUploadsRepository.save(newRepaymentUploads);
            }

            for (JSONObject data : (Iterable<JSONObject>) customerSummaries) {
                assert false;
                System.out.println("data:" + data);
                CustomerSummaries newCustomerSummaries = new CustomerSummaries();
                System.out.println(data.get("SeasonID"));
                newCustomerSummaries.setCustomerID((Long) data.get("CustomerID"));
                newCustomerSummaries.setSeasonID((Long) data.get("SeasonID"));
                newCustomerSummaries.setTotalCredit((Long) data.get("i 7Credit"));
                newCustomerSummaries.setTotalRepaid((Long) data.get("TotalRepaid"));

                System.out.println("newCustomerSummaries:" + newCustomerSummaries);

                customerSummariesRepository.save(newCustomerSummaries);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

}

