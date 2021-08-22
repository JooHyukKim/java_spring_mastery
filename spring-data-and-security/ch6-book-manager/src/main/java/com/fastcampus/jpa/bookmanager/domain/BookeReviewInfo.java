package com.fastcampus.jpa.bookmanager.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.swing.text.html.Option;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BookeReviewInfo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private Long bookId;

    @OneToOne(optional = false, mappedBy = "bookReviewInfo") // 1대1 연관관계
    private Book book;

    private float averageReviewScore;

    private int reviewCount;

}