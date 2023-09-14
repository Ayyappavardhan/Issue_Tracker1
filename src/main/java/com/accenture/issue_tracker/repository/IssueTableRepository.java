package com.accenture.issue_tracker.repository;

import com.accenture.issue_tracker.model.IssueTableData;
import com.accenture.issue_tracker.model.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface IssueTableRepository extends JpaRepository<IssueTableData,Long> {

    @Query(value = "SELECT COUNT(DISTINCT t.tag) FROM tags t JOIN issue_table_data itd " +
            "ON t.incident= itd.incident WHERE itd.date_of_creation BETWEEN :startDate AND :endDate",
            nativeQuery = true)
    int getAllUniqueTagCountWithRangeDate(@Param("startDate") LocalDateTime startDate,
                                          @Param("endDate") LocalDateTime endDate);

    @Query(value = "SELECT COUNT( distinct t.tag) FROM issue_table_data itd LEFT JOIN tags t " +
            "ON itd.incident = t.incident" +
            " WHERE itd.area = :area",
            nativeQuery = true)

    int findAllByTagsOrderByArea( @Param("area") String area);


    @Query(value = "SELECT COUNT(DISTINCT t.tag) FROM issue_table_data itd LEFT JOIN tags t " +
            "ON itd.incident = t.incident " +
            "WHERE itd.area = :area AND itd.date_of_creation >= :startDate AND itd.date_of_creation " +
            "<= :endDate",
            nativeQuery = true)
    int getAllTagsByAreaBetweenDates(@Param("area") String area,
                                            @Param("startDate") LocalDateTime startDate,
                                            @Param("endDate") LocalDateTime endDate);
    @Query(value = "SELECT count (distinct t.incident) from issue_table_data itd  " +
            "LEFT JOIN tags t on itd.incident=t.incident where t.tag = :tag and  itd.date_of_creation >= :startDate " +
            "AND itd.date_of_creation <= :endDate", nativeQuery = true )

    int getAllIncidentCountByTagBetweenDates(@Param("tag") String tag, @Param("startDate") LocalDateTime startDate,
                                             @Param("endDate") LocalDateTime endDate);


    @Query("SELECT itd.incident FROM IssueTableData itd WHERE itd.assignee = :assignee")
    List<String> findAllIncidentNumbersByAssignee(@Param("assignee") String assignee);

}
