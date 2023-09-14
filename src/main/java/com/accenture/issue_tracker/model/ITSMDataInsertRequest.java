package com.accenture.issue_tracker.model;

import java.time.LocalDateTime;

public record ITSMDataInsertRequest(String incident, String summary, String notes, LocalDateTime slaTime,
                                    LocalDateTime dateOfCreation, LocalDateTime resolved, String status, String assignee, String service) {
}
