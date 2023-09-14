package com.accenture.issue_tracker.model;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
@Entity
@Table(name = "ITSM")
public class ITSMTableData {
    /*
    Id->long
    Incident->String
    service->String
    Summary->String
    Notes->String
    SLA time->itsm time
    Date of creation->itsm time
    Resolved->istm time
    Status->String
    Assignee->String

     */
    @Id
    @SequenceGenerator(
            name = "ITSM_Sequence",
            initialValue = 1,
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ITSM_Sequence"
    )
    private Long id;

    private String incident;
    private String summary;
    private String notes;
    private LocalDateTime slaTime;
    private LocalDateTime dateOfCreation;
    private LocalDateTime resolved;
    private String status;
    private String assignee;
    private String service;


    public ITSMTableData() {
    }

    public ITSMTableData(Long id, String incident, String summary, String notes, LocalDateTime slaTime,
                         LocalDateTime dateOfCreation, LocalDateTime resolved, String status, String assignee,String service) {
        this.id = id;
        this.incident = incident;
        this.summary = summary;
        this.notes = notes;
        this.slaTime = slaTime;
        this.dateOfCreation = dateOfCreation;
        this.resolved = resolved;
        this.status = status;
        this.assignee = assignee;
        this.service=service;
    }

    public ITSMTableData(String incident, String summary, String notes, LocalDateTime slaTime,
                         LocalDateTime dateOfCreation, LocalDateTime resolved, String status, String assignee,String service) {
        this.incident = incident;
        this.summary = summary;
        this.notes = notes;
        this.slaTime = slaTime;
        this.dateOfCreation = dateOfCreation;
        this.resolved = resolved;
        this.status = status;
        this.assignee = assignee;
        this.service=service;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIncident() {
        return incident;
    }

    public void setIncident(String incident) {
        this.incident = incident;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDateTime getSlaTime() {
        return slaTime;
    }

    public void setSlaTime(LocalDateTime slaTime) {
        this.slaTime = slaTime;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public LocalDateTime getResolved() {
        return resolved;
    }

    public void setResolved(LocalDateTime resolved) {
        this.resolved = resolved;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ITSMTableData that = (ITSMTableData) o;
        return id == that.id && Objects.equals(incident, that.incident) && Objects.equals(summary, that.summary) && Objects.equals(notes, that.notes) && Objects.equals(slaTime, that.slaTime) && Objects.equals(dateOfCreation, that.dateOfCreation) && Objects.equals(resolved, that.resolved) && Objects.equals(status, that.status) && Objects.equals(assignee, that.assignee) && Objects.equals(service, that.service);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, incident, summary, notes, slaTime, dateOfCreation, resolved, status, assignee, service);
    }

    @Override
    public String toString() {
        return "ITSMTableData{" +
                "id=" + id +
                ", incident='" + incident + '\'' +
                ", summary='" + summary + '\'' +
                ", notes='" + notes + '\'' +
                ", slaTime=" + slaTime +
                ", dateOfCreation=" + dateOfCreation +
                ", resolved=" + resolved +
                ", status='" + status + '\'' +
                ", assignee='" + assignee + '\'' +
                ", service='" + service + '\'' +
                '}';
    }
}
