package com.fastcampus.jpa.bookmanager.domain;

import java.time.LocalDateTime;
import javax.persistence.*;

import com.fastcampus.jpa.bookmanager.domain.listener.Auditable;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
@EntityListeners(value = AuditingEntityListener.class)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
//@EntityListeners(value = {MyEntityListener.class, UserEntityListener.class})
//@Table(name = "user", indexes = {@Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class User extends BaseEntity implements Auditable  {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    @Column(unique = false)
    private String name;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @NonNull
    private String email;

    //    @Column(name="createdAt", nullable = false)
//    @Column(updatable = false)
////    @Column(insertable = false)
//    @CreatedDate
//    private LocalDateTime createdAt;
//
////    @Transient // 영속성을 다루난 db 와 관련없이, db에는 반영도 표시도 안되고 , 객체와 생명주기를 같이함.
//    @LastModifiedDate
//    private LocalDateTime updatedAt;

//    @PrePersist
//    public void prePersist() {
//        this.setCreatedAt(LocalDateTime.now());
//        this.setUpdatedAt(LocalDateTime.now());
//        System.out.println(">>> prePersist");
//    }
//
//    @PreUpdate
//    public void PreUpdate() {
//        this.setUpdatedAt(LocalDateTime.now());
//        System.out.println("PreUpdate >> ");
//    }

    @PreRemove
    public void PreRemove() {
        System.out.println("PreRemove >> ");
    }

    @PostPersist
    public void PostPersist() {
        System.out.println("PostPersist >> ");
    }

    @PostUpdate
    public void PostUpdate() {
        System.out.println("PostUpdate >> ");
    }

    @PostRemove
    public void PostRemove() {
        System.out.println("PostRemove >> ");
    }

    @PostLoad
    public void PostLoad() {
        System.out.println("PostLoad >> ");
    }

}
