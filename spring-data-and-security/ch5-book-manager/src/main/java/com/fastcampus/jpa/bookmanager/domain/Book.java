package com.fastcampus.jpa.bookmanager.domain;

import com.fastcampus.jpa.bookmanager.domain.listener.Auditable;
import com.fastcampus.jpa.bookmanager.domain.listener.MyEntityListener;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
//@EntityListeners(MyEntityListener.class)
public class Book extends BaseEntity  implements Auditable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String author;
//
//    private LocalDateTime createdAt;
//
//    private LocalDateTime updatedAt;

//
//    @PrePersist
//    public void prePersist(){
//        setCreatedAt(LocalDateTime.now());
//        setUpdatedAt(LocalDateTime.now());
//    }
//
//    @PreUpdate
//    public void preUpdate(){
//        setUpdatedAt(LocalDateTime.now());
//    }
}
