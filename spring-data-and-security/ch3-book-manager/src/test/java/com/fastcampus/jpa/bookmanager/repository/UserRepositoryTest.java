package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.User;
import jdk.vm.ci.meta.Local;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;
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
    void crud4() {
        String martinEmail = "martin@fastcampus.com";
        String martinName = "martin";
        System.out.println(userRepository.findByEmailAndName(martinEmail, martinName));
        System.out.println(userRepository.findByEmailOrName(martinEmail, martinName));
        System.out.println(userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
        System.out.println(userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));

        System.out.println("findByIdGreaterThanEqualAndIdLessThanEqual " + userRepository.findByIdGreaterThanEqualAndIdLessThanEqual(1,3));
        System.out.println("findByIdBetween" + userRepository.findByIdBetween(1,3));

        System.out.println("findByNameLike" + userRepository.findByNameLike("%" + "rti" + "%"));


    }

    @Test
    void crud5() {
        String martinEmail = "martin@fastcampus.com";
        String martinName = "martin";
        System.out.println("findByEmail : " + userRepository.findByEmail(martinEmail));
        System.out.println("getByEmail : " + userRepository.getByEmail(martinEmail));
        System.out.println("readByEmail : " + userRepository.readByEmail(martinEmail));
        System.out.println("searchByEmail : " + userRepository.searchByEmail(martinEmail));
        System.out.println("queryByEmail : " + userRepository.queryByEmail(martinEmail));

        System.out.println(userRepository.findSomethingByEmail(martinEmail));

        System.out.println(userRepository.findFirst1ByName(martinName));
        System.out.println(userRepository.findTop1ByName(martinName));

        System.out.println(userRepository.findFirst2ByName(martinName));
        System.out.println(userRepository.findTop2ByName(martinName));

        System.out.println(userRepository.findByEmailAndName(martinEmail, martinName));
        System.out.println(userRepository.findByEmailOrName(martinEmail, martinName));

    }
}




























