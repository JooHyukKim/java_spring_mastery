package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    @Transactional
    void crud() {
        userRepository.save(new User());
        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
        List<User> users2 = userRepository.findAllById(Lists.newArrayList(1L, 3L, 5L));

        User user1 = new User("jack", "Jack@fastcampus.com");
        User user2 = new User("jack2", "Jack2@fastcampus.com");
        userRepository.saveAll(Lists.newArrayList(user1, user2));


        userRepository.findAll().forEach(System.out::println);
        User user = userRepository.getOne(1L);
        User user3 = userRepository.findById(1L).orElse(null);

        System.out.println(user);
    }

    @Test
    void crud2() {
        userRepository.saveAndFlush(new User("new martin", "newmartin@fastcampus.com"));
        userRepository.findAll().forEach(System.out::println);
    }

    @Test
    void crud3() {
        userRepository.saveAndFlush(new User("new martin", "newmartin@fastcampus.com"));
        userRepository.saveAndFlush(new User("new martin", "newmartin@fastcampus.com"));
        userRepository.saveAndFlush(new User("new martin", "newmartin@fastcampus.com"));
        userRepository.saveAndFlush(new User("new martin", "newmartin@fastcampus.com"));
        Long cnt = userRepository.count();

        boolean exists = userRepository.existsById(1L);

    }


}
