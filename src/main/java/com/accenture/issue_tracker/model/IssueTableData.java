package com.accenture.issue_tracker.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
public class IssueTableData {
    /*
    Id->long
    Incident->String
    Service->String
    Status->String
    Assignee->String
    Tags table
    AreaTable
    Breach indiactor->Char
    Date of creation->Itsm time

     */
    @Id
    @SequenceGenerator(
            name = "IssueTableData_sequence",
            sequenceName = "IssueTableData_sequence",
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "IssueTableData_sequence"

    )
    private Long id;
    @Column(name = "incident", unique = true)
    private String incident;
    private String service;
    private String status;
    private String assignee;
    private char breachIndicator;
    private LocalDateTime dateOfCreation;

    @OneToMany(mappedBy = "issueTableData", cascade = CascadeType.ALL)
    private List<Tags> tags;
    private String area;

    public IssueTableData(Long id, String incident, String service, String status, String assignee, char breachIndicator,
                          LocalDateTime dateOfCreation, List<Tags> tags, String area) {
        this.id = id;
        this.incident = incident;
        this.service = service;
        this.status = status;
        this.assignee = assignee;
        this.breachIndicator = breachIndicator;
        this.dateOfCreation = dateOfCreation;
        this.tags = tags;
        this.area = area;
    }

    public IssueTableData(String incident, String service, String status, String assignee, char breachIndicator,
                          LocalDateTime dateOfCreation, List<Tags> tags, String area) {
        this.incident = incident;
        this.service = service;
        this.status = status;
        this.assignee = assignee;
        this.breachIndicator = breachIndicator;
        this.dateOfCreation = dateOfCreation;
        this.tags = tags;
        this.area = area;
    }
    public IssueTableData(String incident, String service, String status, String assignee, char breachIndicator,
                          LocalDateTime dateOfCreation, String area) {
        this.incident = incident;
        this.service = service;
        this.status = status;
        this.assignee = assignee;
        this.breachIndicator = breachIndicator;
        this.dateOfCreation = dateOfCreation;
        this.area = area;
    }


    public IssueTableData() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIncident() {
        return incident;
    }

    public void setIncident(String incident) {
        this.incident = incident;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
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

    public char getBreachIndicator() {
        return breachIndicator;
    }

    public void setBreachIndicator(char breachIndicator) {
        this.breachIndicator = breachIndicator;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IssueTableData that = (IssueTableData) o;
        return breachIndicator == that.breachIndicator && Objects.equals(id, that.id) && Objects.equals(incident,
                that.incident) && Objects.equals(service, that.service) && Objects.equals(status, that.status) &&
                Objects.equals(assignee, that.assignee) && Objects.equals(dateOfCreation, that.dateOfCreation) &&
                Objects.equals(tags, that.tags) && Objects.equals(area, that.area);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, incident, service, status, assignee, breachIndicator, dateOfCreation, tags, area);
    }

    @Override
    public String toString() {
        return "IssueTableData{" +
                "id=" + id +
                ", incident='" + incident + '\'' +
                ", service='" + service + '\'' +
                ", status='" + status + '\'' +
                ", assignee='" + assignee + '\'' +
                ", breachIndicator=" + breachIndicator +
                ", dateOfCreation=" + dateOfCreation +
                ", tags=" + tags +
                ", area='" + area + '\'' +
                '}';
    }
}
