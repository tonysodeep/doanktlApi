package com.hutech.doananktl.services;

import com.hutech.doananktl.models.UserVocab;

import java.util.List;

public interface UserVocabServices {
    List<UserVocab> getAllUserVocabWithUserId(long userId);
    UserVocab updateEmployee(UserVocab userVocab, long id);
}
