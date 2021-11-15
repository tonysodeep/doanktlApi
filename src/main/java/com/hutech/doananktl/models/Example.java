package com.hutech.doananktl.models;

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
}
