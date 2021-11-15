package com.hutech.doananktl.controllers;

import com.hutech.doananktl.models.User;
import com.hutech.doananktl.models.UserVocab;
import com.hutech.doananktl.repositories.UserRepository;
import com.hutech.doananktl.repositories.UserVocabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/v1/userVocabularies")
public class UserVocabController {
    @Autowired
    UserVocabRepository userVocabRepository;
    @Autowired
    UserRepository userRepository;

    @PostMapping
    public ResponseEntity<UserVocab> addVocabulary(@RequestBody @Valid UserVocab userVocab) {
        Optional<User> optionalLibrary = userRepository.findById(userVocab.getUser().getId());
        if (!optionalLibrary.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        userVocab.setUser(optionalLibrary.get());

        UserVocab saveVocab = userVocabRepository.save(userVocab);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(saveVocab.getId()).toUri();

        return ResponseEntity.created(location).body(saveVocab);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<UserVocab>> getByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(userVocabRepository.findByUserId(userId));
    }


}
