package com.hutech.doananktl.controllers;

import com.hutech.doananktl.repositories.UserRepository;
import com.hutech.doananktl.repositories.UserVocabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/v1/userVocabularies")
public class UserVocabController {
    private final UserVocabRepository userVocabRepository;
    private final UserRepository userRepository;

    @Autowired
    public UserVocabController(UserVocabRepository userVocabRepository, UserRepository userRepository) {
        this.userVocabRepository = userVocabRepository;
        this.userRepository = userRepository;
    }


}
