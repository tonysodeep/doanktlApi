package com.hutech.doananktl.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "sentence"
)
public class Example {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String exampleSentence;

    public UserVocab getVocab() {
        return vocab;
    }

    public void setVocab(UserVocab vocab) {
        this.vocab = vocab;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vocab_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UserVocab vocab;
}
