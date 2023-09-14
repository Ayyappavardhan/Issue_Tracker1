package com.accenture.issue_tracker.dao;

import com.accenture.issue_tracker.model.ITSMTableData;
import com.accenture.issue_tracker.model.IssueTableData;
import com.accenture.issue_tracker.model.Tags;
import com.accenture.issue_tracker.repository.ITSMTAbleRepository;
import com.accenture.issue_tracker.repository.IssueTableRepository;
import com.accenture.issue_tracker.repository.TagsRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository("issueTrackerDaoImpl")
public class IssueTrackerDaoImp implements IssueTrackerDao{

    private final IssueTableRepository repository;
    private final ITSMTAbleRepository itsmtAbleRepository;

    private final TagsRepository tagsRepository;
    public IssueTrackerDaoImp(IssueTableRepository repository, ITSMTAbleRepository itsmtAbleRepository, TagsRepository tagsRepository) {
        this.repository = repository;
        this.itsmtAbleRepository = itsmtAbleRepository;
        this.tagsRepository = tagsRepository;
    }




    @Override
    public int getAllUniqueTagCount() {
       return tagsRepository.getAllUniqueTagCount();
    }

    @Override
    public int getAllUniqueTagCountWithRangeDate(LocalDateTime startDate,
                                                 LocalDateTime endDate) {
        return repository.getAllUniqueTagCountWithRangeDate(startDate,endDate);
    }

    @Override
    public List<Tags> getAllUniqueTagDataCountWithRangeDate(LocalDateTime startDate,
                                                            LocalDateTime endDate) {
        return tagsRepository.findAllByIssueTableDataDateOfCreationBetween(startDate,endDate);
    }

    @Override
    public List<IssueTableData> getAllTheIssues() {
        return repository.findAll();

    }

    @Override
    public int getAllTagsByArea(String area) {
       return repository.findAllByTagsOrderByArea(area);
    }

    @Override
    public int getAllTagsByAreaBetweenDates(String area, LocalDateTime startDate,
                                             LocalDateTime endDate) {
        return repository.getAllTagsByAreaBetweenDates(area,startDate,endDate);

    }

    @Override
    public int countUniqueIncidentsByTag(String tag) {
        return tagsRepository.countUniqueIncidentsByTag(tag);
    }

    @Override
    public List<String> uniqueIncidentsByTag(String tag) {
        return tagsRepository.uniqueIncidentsByTag(tag);
    }

    @Override
    public int getAllIncidentCountByTagBetweenDates(String tag, LocalDateTime startDate,
                                                    LocalDateTime endDate) {
        return repository.getAllIncidentCountByTagBetweenDates(tag,startDate,endDate);
    }

    @Override
    public void insertRecords(ITSMTableData itsmTableData) {
        itsmtAbleRepository.save(itsmTableData);
    }

    @Override
    public void saveData(IssueTableData issueTableData) {
        repository.save(issueTableData);
    }

    @Override
    public List<String> getAllIncidentByAssignee(String assignee) {
        return repository.findAllIncidentNumbersByAssignee(assignee);
    }
}
