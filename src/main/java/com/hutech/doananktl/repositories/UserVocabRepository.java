package com.hutech.doananktl.repositories;

import com.hutech.doananktl.models.UserVocab;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserVocabRepository extends JpaRepository<UserVocab,Long> {
    List<UserVocab> findByUserId(Long userId);
}
