package com.hutech.doananktl.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users_vocab",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "vocabName"),
        })
public class UserVocab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String vocabName;

    @NotBlank
    private String vocabVietnameseName;

    @NotBlank
    private String vocabMeaning;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVocabName() {
        return vocabName;
    }

    public void setVocabName(String vocabName) {
        this.vocabName = vocabName;
    }

    public String getVocabVietnameseName() {
        return vocabVietnameseName;
    }

    public void setVocabVietnameseName(String vocabVietnameseName) {
        this.vocabVietnameseName = vocabVietnameseName;
    }

    public String getVocabMeaning() {
        return vocabMeaning;
    }

    public void setVocabMeaning(String vocabMeaning) {
        this.vocabMeaning = vocabMeaning;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
