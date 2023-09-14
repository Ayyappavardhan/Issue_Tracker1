package com.accenture.issue_tracker.model;

import java.time.LocalDateTime;
import java.util.List;

public record DataInsertRequest(String incident, String service, String status, String assignee,
                                char breachIndicator, LocalDateTime dateOfCreation, List<Tags> tags,
                                String area) {
}
