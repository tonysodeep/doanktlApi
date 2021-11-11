package com.hutech.doananktl.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users_vocab",
        uniqueConstraints = {

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

}
