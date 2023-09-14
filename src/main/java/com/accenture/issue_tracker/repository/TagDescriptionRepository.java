package com.accenture.issue_tracker.repository;

import com.accenture.issue_tracker.model.TagDescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagDescriptionRepository extends JpaRepository<TagDescription,Long> {
}
