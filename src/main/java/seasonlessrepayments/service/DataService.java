package seasonlessrepayments.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

        String fileName = "src/main/java/com/oaf/seasonless/txt.json";

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


        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

}

