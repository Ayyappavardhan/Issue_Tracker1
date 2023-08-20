package com.accenture.issue_tracker.service;

import com.accenture.issue_tracker.dao.IssueTrackerDao;
import com.accenture.issue_tracker.model.DataInsertRequest;
import com.accenture.issue_tracker.model.IssueTableData;
import com.accenture.issue_tracker.model.Tags;
import org.springframework.beans.factory.annotation.Qualifier;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class Service  {
    private final IssueTrackerDao issueTrackerDao;

    public Service(@Qualifier("issueTrackerDaoImpl") IssueTrackerDao issueTrackerDao) {
        this.issueTrackerDao = issueTrackerDao;
    }

    public void saveData(DataInsertRequest dataInsertRequest) {
        IssueTableData issueTableData = new IssueTableData(
                dataInsertRequest.incident(),
                dataInsertRequest.service(),
                dataInsertRequest.status(),
                dataInsertRequest.assignee(),
                dataInsertRequest.breachIndicator(),
                dataInsertRequest.dateOfCreation(),
                dataInsertRequest.area()
        );

        List<Tags> tagsList = new ArrayList<>();
        for (Tags tag : dataInsertRequest.tags()) {
            Tags tags = new Tags(dataInsertRequest.service(), tag.getTag(), issueTableData);
            tagsList.add(tags);
        }

        issueTableData.setTags(tagsList);

        System.out.println("saved");
        issueTrackerDao.saveData(issueTableData);
    }

    public int getAllUniqueTagCount() {
       return issueTrackerDao.getAllUniqueTagCount();

    }

    public int getAllUniqueTagCountWithRangeDate(LocalDateTime startDate, LocalDateTime endDate) {
        return issueTrackerDao.getAllUniqueTagCountWithRangeDate(startDate,endDate);
    }

    public List<Tags> getAllUniqueTagDataCountWithRangeDate(LocalDateTime startDate, LocalDateTime endDate) {
        return issueTrackerDao.getAllUniqueTagDataCountWithRangeDate(startDate,endDate);
    }

    public List<IssueTableData> getAllTheIssues() {
        return issueTrackerDao.getAllTheIssues();


    }
}
