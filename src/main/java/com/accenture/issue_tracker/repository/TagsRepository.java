package com.accenture.issue_tracker.repository;

import com.accenture.issue_tracker.model.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface TagsRepository extends JpaRepository<Tags, Long> {

    @Query("SELECT COUNT(DISTINCT t.tag) FROM Tags t")
    int getAllUniqueTagCount();
    @Query(value = "SELECT t.* FROM tags t JOIN issue_table_data itd " +
            "ON t.incident= itd.incident WHERE itd.date_of_creation BETWEEN :startDate AND :endDate",
            nativeQuery = true)
    List<Tags> findAllByIssueTableDataDateOfCreationBetween(LocalDateTime startDate, LocalDateTime endDate);
}
