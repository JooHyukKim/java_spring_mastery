package com.fastcampus.jpa.bookmanager.domain.listener;

import com.fastcampus.jpa.bookmanager.BeanUtils;
import com.fastcampus.jpa.bookmanager.domain.User;
import com.fastcampus.jpa.bookmanager.domain.UserHistory;
import com.fastcampus.jpa.bookmanager.repository.UserHistoryRepository;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class UserEntityListener {


    @PreUpdate
    @PrePersist
    public void preUpdateAndPreUpdate(Object o) {
        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);
        User user = (User) o;

        UserHistory userHistory = new UserHistory();
        userHistory.setUserId(user.getId());
        userHistory.setName(user.getName());
        userHistory.setEmail(user.getEmail());

        userHistoryRepository.save(userHistory);

    }
}
