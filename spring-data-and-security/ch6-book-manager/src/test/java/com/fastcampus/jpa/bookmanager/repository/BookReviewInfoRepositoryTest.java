package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Book;
import com.fastcampus.jpa.bookmanager.domain.BookeReviewInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookReviewInfoRepositoryTest {
    @Autowired
    private BookReviewInfoRepository bookReviewInfoRepository;

    @Autowired
    private BookRepository bookRepository;


//    @Test
//    void crudTest() {
//        BookeReviewInfo bookeReviewInfo = new BookeReviewInfo();
//        bookeReviewInfo.setBookId(1L);
//        bookeReviewInfo.setAverageReviewScore(4.5f);
//        bookeReviewInfo.setReviewCount(2);
//
//        bookReviewInfoRepository.save(bookeReviewInfo);
//
//        System.out.println(">>>>" + bookReviewInfoRepository.findAll());
//    }


    @Test
    void crudTest2() {
        givenBookReviewInfo();

        Book result = bookReviewInfoRepository
                .findById(1L)
                .orElseThrow(RuntimeException::new)
                .getBook();

        System.out.println(">>>> " + result);

    }

    private Book givenBook() {
        Book book = new Book();
        book.setName("JPA 초격차");
        book.setAuthorId(1L);
        book.setPublisherId(1L);

        return bookRepository.save(book);
    }

    private void givenBookReviewInfo() {
        BookeReviewInfo bookeReviewInfo = new BookeReviewInfo();
        bookeReviewInfo.setBook(givenBook());
        bookeReviewInfo.setAverageReviewScore(4.5f);
        bookeReviewInfo.setReviewCount(2);

        bookReviewInfoRepository.save(bookeReviewInfo);

        System.out.println(">>>> " + bookReviewInfoRepository.findAll());

    }


}