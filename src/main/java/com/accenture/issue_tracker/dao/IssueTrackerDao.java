package com.accenture.issue_tracker.dao;

import com.accenture.issue_tracker.model.ITSMTableData;
import com.accenture.issue_tracker.model.IssueTableData;
import com.accenture.issue_tracker.model.Tags;

import java.time.LocalDateTime;
import java.util.List;

public interface IssueTrackerDao {


    int getAllUniqueTagCount();

    int getAllUniqueTagCountWithRangeDate(LocalDateTime startDate, LocalDateTime endDate);

    List<Tags> getAllUniqueTagDataCountWithRangeDate(LocalDateTime startDate, LocalDateTime endDate);

    List<IssueTableData> getAllTheIssues();

    int getAllTagsByArea(String area);

    int getAllTagsByAreaBetweenDates(String area, LocalDateTime startDate, LocalDateTime endDate);

    int countUniqueIncidentsByTag(String tag);

    List<String> uniqueIncidentsByTag(String tag);

    int getAllIncidentCountByTagBetweenDates(String tag, LocalDateTime startDate, LocalDateTime endDate);

    void insertRecords(ITSMTableData itsmTableData);

    void saveData(IssueTableData issueTableData);

    List<String> getAllIncidentByAssignee(String assignee);
}
