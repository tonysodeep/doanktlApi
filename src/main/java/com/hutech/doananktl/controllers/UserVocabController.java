package com.hutech.doananktl.controllers;

import com.hutech.doananktl.exception.ResourceNotFoundException;
import com.hutech.doananktl.models.UserVocab;
import com.hutech.doananktl.repositories.CategoryRepository;
import com.hutech.doananktl.repositories.UserRepository;
import com.hutech.doananktl.repositories.UserVocabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.hutech.doananktl.utils.ResponseUtil.resourceUri;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/v1/userVocabularies")
public class UserVocabController {
    @Autowired
    UserVocabRepository userVocabRepository;
    @Autowired
    UserRepository userRepository;

    @PostMapping("user/{userID}/vocabularies")
    public ResponseEntity<UserVocab> addVocabulary(@PathVariable(value = "userID") Long userId,
                                                   @Valid @RequestBody UserVocab userVocabRequest) {
        return userRepository.findById(userId).map(user -> {
            userVocabRequest.setUser(user);
            return userVocabRepository.save(userVocabRequest);
        }).map(
                userVocab -> ResponseEntity.created(resourceUri(userVocab.getId())).body(userVocab)
        ).orElseThrow(
                () -> new ResourceNotFoundException("not fould", "aaa", userId)
        );
    }

//    @GetMapping("user/{userID}/vocabularies")
//    public Page<UserVocab> getAllVocabByUserId(
//            @PathVariable(value = "userID") Long userID,
//            Pageable pageable
//    ) {
//        return userVocabRepository.findByVocabUserId(userID, pageable);
//    }


}
