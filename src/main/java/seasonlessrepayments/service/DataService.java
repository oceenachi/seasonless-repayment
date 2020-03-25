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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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


//            String startDateString = "06/27/2007";
//            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
//            Date startDate;
//            try {
//                startDate = df.parse(startDateString);
//                String newDateString = df.format(startDate);
//                System.out.println(newDateString);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }

            for (JSONObject data : (Iterable<JSONObject>) seasons) {
                assert false;
                Seasons newSeason = new Seasons();
                newSeason.setSeasonsId((Long) data.get("SeasonID"));
                newSeason.setName((String) data.get("SeasonName"));

                String startDateString = (String) data.get("StartDate");
                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                Date startDate;
                startDate = df.parse(startDateString);
                newSeason.setStartDate(startDate);

                newSeason.setEndDate((Long) data.get("EndDate"));
                seasonRepository.save(newSeason);
            }

            for (JSONObject data : (Iterable<JSONObject>) customers) {
                assert false;
                Customers newCustomers = new Customers();
                newCustomers.setId((Long) data.get("CustomerID"));
                newCustomers.setCustomerName((String) data.get("CustomerName"));

                customerRepository.save(newCustomers);
            }

            for (JSONObject data : (Iterable<JSONObject>) repaymentUploads) {
                assert false;
                RepaymentUploads newRepaymentUploads = new RepaymentUploads();
                newRepaymentUploads.setCustomerID((Long) data.get("CustomerID"));
                newRepaymentUploads.setSeasonID((Long) data.get("SeasonID"));
                newRepaymentUploads.setAmount((Long) data.get("Amount"));

                String startDateString = (String) data.get("Date");
                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                Date startDate;
                startDate = df.parse(startDateString);
                newRepaymentUploads.setDate(startDate);

               repaymentUploadsRepository.save(newRepaymentUploads);
            }

            for (JSONObject data : (Iterable<JSONObject>) customerSummaries) {
                assert false;
                CustomerSummaries newCustomerSummaries = new CustomerSummaries();
                newCustomerSummaries.setCustomerID((Long) data.get("CustomerID"));
                newCustomerSummaries.setSeasonID((Long) data.get("SeasonID"));
                newCustomerSummaries.setTotalCredit((Long) data.get("Credit"));
                newCustomerSummaries.setTotalRepaid((Long) data.get("TotalRepaid"));


                customerSummariesRepository.save(newCustomerSummaries);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }



}

