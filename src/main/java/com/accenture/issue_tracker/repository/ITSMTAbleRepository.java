package com.accenture.issue_tracker.repository;

import com.accenture.issue_tracker.model.ITSMTableData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITSMTAbleRepository extends JpaRepository<ITSMTableData,Long> {
}
