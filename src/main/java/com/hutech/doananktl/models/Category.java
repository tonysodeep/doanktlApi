package com.hutech.doananktl.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "category"
)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String categoryName;

    @ManyToMany(mappedBy = "categories")
    private Set<UserVocab> userVocabList = new HashSet<>();

    public Set<UserVocab> getUserVocabList() {
        return userVocabList;
    }

    public void setUserVocabList(Set<UserVocab> userVocabList) {
        this.userVocabList = userVocabList;
    }
}
