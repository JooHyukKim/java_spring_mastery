package com.fastcampus.jpa.bookmanager.domain;

import java.time.LocalDateTime;
import javax.persistence.*;

import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Martin
 * @since 2021/03/10
 */
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
@Entity //JPA 관리 대상으로 지정
@Table(name = "user", indexes = {@Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    @Column(unique = true)
    private String name;

    @Enumerated(value=EnumType.STRING)
    private Gender gender;

    @NonNull
    private String email;

    //    @Column(name="createdAt", nullable = false)
    @Column(updatable = false)
//    @Column(insertable = false)
    private LocalDateTime createdAt;

    @Transient // 영속성을 다루난 db 와 관련없이, db에는 반영도 표시도 안되고 , 객체와 생명주기를 같이함.
    private LocalDateTime updatedAt;
}
