package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Martin
 * @since 2021/03/10
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);

    User findByEmail(String email);

    User getByEmail(String email);

    User readByEmail(String email);

    User searchByEmail(String email);

    User queryByEmail(String email);

    User findSomethingByEmail(String email);

    List<User> findFirst1ByName(String email);

    List<User> findTop1ByName(String email);

    List<User> findFirst2ByName(String email);

    List<User> findTop2ByName(String email);


//    List<User> findByName(String name);
//    Set<User> findByName(String name);

}
