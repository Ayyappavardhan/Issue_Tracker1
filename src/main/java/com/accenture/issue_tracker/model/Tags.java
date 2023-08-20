package com.accenture.issue_tracker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Tags {
    @Id
    @SequenceGenerator(
            name = "tag_sequence",
            sequenceName = "tag_sequence",
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tag_sequence"
    )

    private Long id;
    private String service;
    private String tag;
    @JsonIgnore
    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(
            name = "incident",
            referencedColumnName = "incident"
    )
    private IssueTableData issueTableData;

    public Tags(Long id, String service, String tag, IssueTableData issueTableData) {
        this.id = id;
        this.service = service;
        this.tag = tag;
        this.issueTableData = issueTableData;
    }

    public Tags(String service, String tag, IssueTableData issueTableData) {
        this.service = service;
        this.tag = tag;
        this.issueTableData = issueTableData;
    }

    public Tags(String service, String tag) {
        this.service = service;
        this.tag = tag;
    }

    public Tags() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public IssueTableData getIssueTableData() {
        return issueTableData;
    }

    public void setIssueTableData(IssueTableData issueTableData) {
        this.issueTableData = issueTableData;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tags tags = (Tags) o;
        return Objects.equals(id, tags.id) && Objects.equals(service, tags.service) && Objects.equals(tag, tags.tag) && Objects.equals(issueTableData, tags.issueTableData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, service, tag, issueTableData);
    }

    @Override
    public String toString() {
        return "Tags{" +
                "id=" + id +
                ", service='" + service + '\'' +
                ", tag='" + tag + '\'' +
                ", issueTableData=" + issueTableData +
                '}';
    }
}
