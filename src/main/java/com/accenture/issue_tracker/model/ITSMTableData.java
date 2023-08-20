package com.accenture.issue_tracker.model;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.util.Date;
import java.util.Objects;
@Entity
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
            name = "ITSM_sequence",
            sequenceName = "ITSM_sequence",
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ITSM_sequence"
    )
    private long id;

    private String incident;
    private String summary;
    private String notes;
    private Date slaTime;
    private Date dateOfCreation;
    private Date resolved;
    private String status;
    private String assignee;

    public ITSMTableData() {
    }

    public ITSMTableData(long id, String incident, String summary, String notes, Date slaTime, Date dateOfCreation, Date resolved, String status, String assignee) {
        this.id = id;
        this.incident = incident;
        this.summary = summary;
        this.notes = notes;
        this.slaTime = slaTime;
        this.dateOfCreation = dateOfCreation;
        this.resolved = resolved;
        this.status = status;
        this.assignee = assignee;
    }

    public ITSMTableData(String incident, String summary, String notes, Date slaTime, Date dateOfCreation, Date resolved, String status, String assignee) {
        this.incident = incident;
        this.summary = summary;
        this.notes = notes;
        this.slaTime = slaTime;
        this.dateOfCreation = dateOfCreation;
        this.resolved = resolved;
        this.status = status;
        this.assignee = assignee;
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

    public Date getSlaTime() {
        return slaTime;
    }

    public void setSlaTime(Date slaTime) {
        this.slaTime = slaTime;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public Date getResolved() {
        return resolved;
    }

    public void setResolved(Date resolved) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ITSMTableData that = (ITSMTableData) o;
        return id == that.id && Objects.equals(incident, that.incident) && Objects.equals(summary, that.summary) && Objects.equals(notes, that.notes) && Objects.equals(slaTime, that.slaTime) && Objects.equals(dateOfCreation, that.dateOfCreation) && Objects.equals(resolved, that.resolved) && Objects.equals(status, that.status) && Objects.equals(assignee, that.assignee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, incident, summary, notes, slaTime, dateOfCreation, resolved, status, assignee);
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
                '}';
    }
}
