package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
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

    List<User> findByEmailAndName(String email, String name);

    List<User> findByEmailOrName(String email, String name);

    List<User> findByCreatedAtAfter(LocalDateTime yesterday);

    List<User> findByCreatedAtGreaterThan(LocalDateTime yesterday);

    List<User> findByCreatedAtGreaterThanEqual(LocalDateTime yesterday);

    List<User> findByCreatedAtBetween(LocalDateTime yesterday, LocalDateTime tommorow);

    List<User> findByIdBetween(long start, long finish);

    List<User> findByIdIsNot(long start, long finish);

    List<User> findByIdGreaterThanEqualAndIdLessThanEqual(long start, long finish);

    List<User> findByIdNotEmpty(String id);

    List<User> findByIdNotNull(String id);

    List<User> findByNameStartingWith(String name);

    List<User> findByNameEndingWith(String name);

    List<User> findByNameContaining(String name);

    List<User> findByNameLike(String name);

    Optional<User> findUserByName(String name);
    Optional<User> findUserByNameEquals(String name);
    Optional<User> findUserByNameIs(String name);


}
