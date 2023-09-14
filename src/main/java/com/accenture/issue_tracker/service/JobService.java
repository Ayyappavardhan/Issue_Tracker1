package com.accenture.issue_tracker.service;

import com.accenture.issue_tracker.model.ITSMTableData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service

public class JobService {
    private static final Logger logger = LoggerFactory.getLogger(JobService.class);

    private  final AllService service;

    public JobService(AllService service) {
        this.service = service;
    }


    @Scheduled(fixedRate =  1000) // Run every 15 days (in milliseconds)
    public void runJob() {
        logger.info("job run started");
        // Retrieve data from the third-party system using a database query or API call
        List<ITSMTableData> records = retrieveDataFromThirdPartySystem();

        for (ITSMTableData record : records) {
            service.insertRecords(record);
        }
        logger.info("job run completed");
    }


    private List<ITSMTableData> retrieveDataFromThirdPartySystem() {
        List<ITSMTableData> records = new ArrayList<>();


        // Implement the logic to retrieve data from the third-party system using a database query or API call
        // For example, if you are using a database query:

//        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itsm?useSSL=false&serverTimezone=UTC&user=root&password=root" )) {
//            String query = "SELECT  incident, service, status, assignee, sla_time, date_of_creation, resolved, summary,notes FROM third_party_table";
//            try (PreparedStatement statement = connection.prepareStatement(query)) {
//                try (ResultSet resultSet = statement.executeQuery()) {
//                    while (resultSet.next()) {
//                        ITSMTableData record = new ITSMTableData();
//                        record.setIncident(resultSet.getString("incident"));
//                        record.setService(resultSet.getString("service"));
//                        record.setStatus(resultSet.getString("status"));
//                        record.setAssignee(resultSet.getString("assignee"));
//                        record.setSlaTime(resultSet.getTimestamp("sla_time").toLocalDateTime());
//                        record.setDateOfCreation(resultSet.getTimestamp("date_of_creation").toLocalDateTime());
//                        record.setResolved(resultSet.getTimestamp("resolved").toLocalDateTime());
//                        record.setSummary("summary");
//                        record.setNotes("notes");
//                        records.add(record);
//
//                    }
//                }
//            }
//        } catch (SQLException e) {
//            // Handle any exceptions that occur during the database query
//            e.printStackTrace();
//        }

        return records;
    }

}
