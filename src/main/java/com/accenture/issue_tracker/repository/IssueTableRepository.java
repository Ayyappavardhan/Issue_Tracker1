package com.accenture.issue_tracker.repository;

import com.accenture.issue_tracker.model.IssueTableData;
import com.accenture.issue_tracker.model.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface IssueTableRepository extends JpaRepository<IssueTableData,Long> {

//@Query(value = "SELECT COUNT(DISTINCT t.tag) FROM tags t JOIN issue_table_data itd ON" +
//        " t.incident = itd.incident WHERE itd.date_of_creation >= :startDate AND itd.date_of_creation" +
//        " <= :endDate + INTERVAL 1 DAY",
//        nativeQuery = true)

    @Query(value = "SELECT COUNT(DISTINCT t.tag) FROM tags t JOIN issue_table_data itd " +
            "ON t.incident= itd.incident WHERE itd.date_of_creation BETWEEN :startDate AND :endDate",
            nativeQuery = true)
    int getAllUniqueTagCountWithRangeDate(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);


}
