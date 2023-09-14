package com.accenture.issue_tracker.model;

import jakarta.persistence.*;

import java.util.Scanner;

@Entity
public class TagDescription {
    @Id
    @SequenceGenerator(
            name = "Tag_description_sequence",
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator ="Tag_description_sequence"
    )
    @Column(name = "tag_description_id")
    private Long id;
    private String Tag;
    private String description;


    public TagDescription() {
    }

    public TagDescription(String tag, String description) {
        Tag = tag;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTag() {
        return Tag;
    }

    public void setTag(String tag) {
        Tag = tag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
