package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

/**
 * @author Martin
 * @since 2021/03/10
 */
@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void crud() { // create, read, update, delete
        List<User> users = userRepository.findAll();
        users.forEach(user -> {
            System.out.println(user);
        });

        userRepository.save(new User("david", "david@fastcampus.com"));

        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setEmail("martin-updated@fastcampus.com");

        userRepository.save(user);
    }

    @Test
    void crud2() {
        Page<User> users = userRepository.findAll(PageRequest.of(1, 3));

        System.out.println("page : " + users);
        System.out.println("getTotalElements : " + users.getTotalElements());
        System.out.println("getTotalPages : " + users.getTotalPages());
        System.out.println("getNumberOfElements : " + users.getNumberOfElements());
        System.out.println("getSort : " + users.getSort());
        System.out.println("getSize : " + users.getSize());

        users.getContent().forEach(System.out::println);
    }

    @Test
    void crud3() {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("name")
                .withMatcher("email", endsWith());

        Example<User> example = Example.of(new User("Ma", "fastcampus.com"), matcher);

        userRepository.findAll(example).forEach(System.out::println);

        ExampleMatcher matcher1 = ExampleMatcher.matching().withMatcher("email", contains());

        userRepository.findAll(example).forEach(System.out::println);
    }

    @Test
    void crud4() {
        userRepository.save(new User("david", "david@fastcampus.com"));

        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setEmail("martin-updated@fastcampus.com");

        userRepository.save(user);
    }

    @Test
    void crud5() {
    }
}




























