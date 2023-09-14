package com.accenture.issue_tracker.mq;

import com.accenture.issue_tracker.model.DataInsertRequest;
import com.accenture.issue_tracker.model.ITSMTableData;
import com.accenture.issue_tracker.model.Tags;
import com.accenture.issue_tracker.service.AllService;
import com.accenture.issue_tracker.service.ITSMTableDataService;
import com.accenture.issue_tracker.service.JobService;
import jakarta.persistence.Column;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class ITSMTableDataListener {
    private  final AllService allService;
    private static final Logger logger = LoggerFactory.getLogger(JobService.class);

    public ITSMTableDataListener(AllService allService) {
        this.allService = allService;
    }

    @RabbitListener(queues = "#{MQConfig.QUEUE}")
    public void processMessage(ITSMTableData itsmTableData){
        // Perform validations on the received data
        // Example: Validate the data and insert into another table if valid
//        if (isValidData(data)) {
//            // Insert the valid data into another table
//            insertIntoAnotherTable(data);
//        }
        logger.info("Queue listener started");
        String incident = itsmTableData.getIncident();
        String service = itsmTableData.getService();
        String notes = itsmTableData.getNotes();
        LocalDateTime dateOfCreation = itsmTableData.getDateOfCreation();
        LocalDateTime slaTime = itsmTableData.getSlaTime();
        String status = itsmTableData.getStatus();
        String summary = itsmTableData.getSummary();
        LocalDateTime resolved = itsmTableData.getResolved();
        String assignee = itsmTableData.getAssignee().toLowerCase();
        /*
         dataInsertRequest.incident(),
                dataInsertRequest.service(),
                dataInsertRequest.status(),
                dataInsertRequest.assignee(),
                dataInsertRequest.breachIndicator(),
                dataInsertRequest.dateOfCreation(),
                dataInsertRequest.area()
                String incident, String service, String status, String assignee,
                                char breachIndicator, LocalDateTime dateOfCreation, List<Tags> tags,
                                String area
         */
        List<Tags> listOfTags = getListOfTags(notes, service);
        String area = getArea(service);
        char breachIndicator = getBreachIndicator(slaTime, resolved);
        DataInsertRequest dataInsertRequest= new DataInsertRequest(
                incident,
                service,
                status,
                assignee,
                breachIndicator,
                dateOfCreation,
                listOfTags,
                area
        );
        allService.saveData(dataInsertRequest);
        logger.info("Queue listener is over data got inserted into IssueTable"+ dataInsertRequest);

    }
    public char getBreachIndicator(LocalDateTime slaTime, LocalDateTime resolved){
        char ch='Y';
        if(resolved.compareTo(slaTime)<0){
            ch='N';
        }
        return ch;
    }
    public List<Tags> getListOfTags(String notes, String service){
        List<Tags> tagsList= new ArrayList<>();
        String []str= notes.split(" ");
        for(int i=0;i<str.length;i++){
            if(str[i].charAt(0)=='#'){
                Tags tags= new Tags();
                tags.setTag(str[i]);
                tags.setService(service);
                tagsList.add(tags);
            }
        }
        return tagsList;
    }
    /*
    ('Service+' = "aftersales-mobility-program:nsc-us") OR
('Service+' = "bmw-document-management:nsc-us") OR
('Service+' = "buyback-re-engineering:nsc-us") OR
('Service+' = "dealer-service-claims:nsc-us") OR
('Service+' = "digital-warranty:nsc-us") OR
('Service+' = "nhtsa-final-rule-implementation:nsc-us") OR
('Service+' = "product-analysis-dm-w:nsc-us") OR
('Service+' = "ross:nsc-us") OR
('Service+' = "rvtt:nsc-us") OR
('Service+' = "special-tools-management:nsc-us") OR
('Service+' = "vcs:nsc-us") OR
('Service+' = "waps:nsc-us") OR
('Service+' = "warranty-data-warehouse:nsc-us") OR
('Service+' = "warranty-health-assessment-tool:nsc-us") OR
('Service+' = "warranty-national-processing-system:nsc-us") OR
('Service+' = "warranty-parameter-maintenance:nsc-us") OR
('Service+' = "warranty-web:nsc-us") OR
('Service+' = "wret:nsc-us") OR
('Service+' = "warranty-knowledge-portal:nsc-us"))
     */
    public String getArea(String service){
        String area=null;
        if(service.equals("aftersales-mobility-program:nsc-us") || service.equals("bmw-document-management:nsc-us")
        || service.equals("buyback-re-engineering:nsc-us")|| service.equals("dealer-service-claims:nsc-us")||
        service.equals("digital-warranty:nsc-us")||service.equals("nhtsa-final-rule-implementation:nsc-us")||
        service.equals("product-analysis-dm-w:nsc-us")|| service.equals("ross:nsc-us")||service.equals("ross:nsc-us")||
        service.equals("special-tools-management:nsc-us")||service.equals("vcs:nsc-us")||service.equals("waps:nsc-us")||
        service.equals("warranty-web:nsc-us")){
            area="FG-54";
        }
        else{
            area="FG-55";
        }
        return area;
    }
}
