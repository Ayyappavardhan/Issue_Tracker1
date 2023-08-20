package com.accenture.issue_tracker.dao;

import com.accenture.issue_tracker.model.IssueTableData;
import com.accenture.issue_tracker.model.Tags;
import com.accenture.issue_tracker.repository.IssueTableRepository;
import com.accenture.issue_tracker.repository.TagsRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository("issueTrackerDaoImpl")
public class IssueTrackerDaoImp implements IssueTrackerDao{

    private final IssueTableRepository repository;

private final TagsRepository tagsRepository;
    public IssueTrackerDaoImp(IssueTableRepository repository, TagsRepository tagsRepository) {
        this.repository = repository;
        this.tagsRepository = tagsRepository;
    }


    @Override
    public void saveData(IssueTableData issueTableData) {
        repository.save(issueTableData);
    }

    @Override
    public int getAllUniqueTagCount() {
       return tagsRepository.getAllUniqueTagCount();
    }

    @Override
    public int getAllUniqueTagCountWithRangeDate(LocalDateTime startDate, LocalDateTime endDate) {
        return repository.getAllUniqueTagCountWithRangeDate(startDate,endDate);
    }

    @Override
    public List<Tags> getAllUniqueTagDataCountWithRangeDate(LocalDateTime startDate, LocalDateTime endDate) {
        return tagsRepository.findAllByIssueTableDataDateOfCreationBetween(startDate,endDate);
    }

    @Override
    public List<IssueTableData> getAllTheIssues() {
        return repository.findAll();

    }
}
