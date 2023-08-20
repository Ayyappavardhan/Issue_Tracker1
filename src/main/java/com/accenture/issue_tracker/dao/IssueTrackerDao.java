package com.accenture.issue_tracker.dao;

import com.accenture.issue_tracker.model.IssueTableData;
import com.accenture.issue_tracker.model.Tags;

import java.time.LocalDateTime;
import java.util.List;

public interface IssueTrackerDao {
    public void saveData(IssueTableData issueTableData);

    int getAllUniqueTagCount();

    int getAllUniqueTagCountWithRangeDate(LocalDateTime startDate, LocalDateTime endDate);

    List<Tags> getAllUniqueTagDataCountWithRangeDate(LocalDateTime startDate, LocalDateTime endDate);

    List<IssueTableData> getAllTheIssues();
}
