package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Gender;
import com.fastcampus.jpa.bookmanager.domain.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

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

    @Autowired
    private UserHistoryRepository userHistoryRepository;

    private void print(Object obj) {
        System.out.println(obj);
    }

    @Test
    void userHistoryTest() {
        User user = new User();
        user.setEmail("martin2@fastcampus.com");
        user.setName("martin");

        userRepository.save(user);

        user.setName("martin-new-new");
        userRepository.save(user);

        userRepository.findAll().forEach(System.out::println);
        userHistoryRepository.findAll().forEach(System.out::println);

    }

    @Test
    void preUpdateTest() {
//        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
//        System.out.println("as is "+ user2);
//
//        userRepository.save(user2);
//
//        System.out.println("as is "+ user2);
//        userRepository.findBy(user2.getUpdatedAt())
//        Assertions.assertNotEquals(user2.getUpdatedAt(), user3.getUpdatedAt());
    }

    @Test
    void prePersistTest() {
        User user = new User();
        user.setEmail("martin2@fastcampus.com");
        user.setName("martin");
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        userRepository.save(user);

        System.out.println(userRepository.findByEmail(user.getEmail()));
    }

    @Test
    void listenerTest() {
        User user = new User();
        user.setEmail("martin2@fastcampus.com");
        user.setName("martin");

        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);

        userRepository.save(user2);

        userRepository.deleteById(4L);
    }


    @Test
    void enumTest() {
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setGender(Gender.MALE);

        userRepository.save(user);

        userRepository.findAll().forEach(System.out::println);

        System.out.println(userRepository.findRawRecord().get("gender"));
    }

//    @Test
//    void insertAndUpdateTest() {
//        User user = new User();
//        user.setName("martin");
//        user.setName("martin2@fastcampus.com");
//
//        userRepository.save(user);
//
//        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
//    }

    @Test
    void crud6() {
        /*
        print("---------------------------------------------------------------------");
        print(userRepository.findByName("martin", Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))));
        print(userRepository.findFirstByName("martin", Sort.by(Sort.Order.desc("id"))));



        print("---------------------------------------------------------------------");
        print(userRepository.findByName("martin"));
        print("---------------------------------------------------------------------");
        Sort sort = Sort.by(Sort.Order.desc("id"));
        print(userRepository.findByName("martin", PageRequest.of(1, 1, sort)));

        */

//        print(userRepository.findLast1ByName("martin"));
//        print(userRepository.findLast1ByNameOOrderByIdDesc("martin"));
//        print(userRepository.findTopByNameOrderByIdDescEmailAsc("mar"));
    }

    /*

    @Test
    void crud4() {
        String martinEmail = "martin@fastcampus.com";
        String martinName = "martin";
        System.out.println(userRepository.findByEmailAndName(martinEmail, martinName));
        System.out.println(userRepository.findByEmailOrName(martinEmail, martinName));
        System.out.println(userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
        System.out.println(userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));

        System.out.println("findByIdGreaterThanEqualAndIdLessThanEqual " + userRepository.findByIdGreaterThanEqualAndIdLessThanEqual(1, 3));
        System.out.println("findByIdBetween" + userRepository.findByIdBetween(1, 3));

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

    }*/
}




























