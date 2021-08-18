package com.example.springwithrestaurant.wishlist.service;

import com.example.springwithrestaurant.naver.NaverClient;
import com.example.springwithrestaurant.naver.dto.SearchLocalReq;
import com.example.springwithrestaurant.wishlist.dto.WishListDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class WishListServiceTest {

    @Autowired
    private WishListService wishListService;

    @Autowired
    private NaverClient naverClient;

    @Test
    public void localSearchTest() {
        var search = new SearchLocalReq();
        search.setQuery("갈비집");

        var result = naverClient.localSearch(search);


        System.out.println(result);
        Assertions.assertNotNull(result.getItems().stream().findFirst().get().getCategory());
    }

    @Test
    public void searchTest() {
        var result = wishListService.search("갈비집");
        System.out.println(result);
        Assertions.assertNotNull(result);
    }

    @Test
    public void addTest() {
        var result = wishListService.search("갈비집");
        Assertions.assertEquals(true, Optional.of(result).isPresent());

        Assertions.assertDoesNotThrow(() -> wishListService.add(result));

        List<WishListDto> wishListDtoList = wishListService.findAll();
        Assertions.assertEquals(1, wishListDtoList.size());

    }

    @Test
    public void findAllTest() {
        var result = wishListService.search("갈비집");
        int firstSize = wishListService.findAll().size();
        Assertions.assertEquals(true, Optional.of(result).isPresent());

        Assertions.assertDoesNotThrow(() -> wishListService.add(result));
        Assertions.assertDoesNotThrow(() -> wishListService.add(result));
        Assertions.assertDoesNotThrow(() -> wishListService.add(result));
        Assertions.assertDoesNotThrow(() -> wishListService.add(result));
        Assertions.assertDoesNotThrow(() -> wishListService.add(result));

        List<WishListDto> wishListDtoList = wishListService.findAll();
        Assertions.assertEquals(firstSize + 5, wishListDtoList.size());

        boolean emp = Optional.of(result).isEmpty();
    }

    @Test
    public void deleteByIdTest() {
        var result = wishListService.search("갈비집");
        Assertions.assertEquals(true, Optional.of(result).isPresent());



        Assertions.assertDoesNotThrow(() -> wishListService.add(result));
        Assertions.assertDoesNotThrow(() -> wishListService.add(result));

        List<WishListDto> wishListDtoList = wishListService.findAll();
        int firstSize = wishListDtoList.size();

        int index = wishListDtoList.get(0).getIndex();
        Assertions.assertDoesNotThrow(() -> wishListService.deleteById(index));

        Assertions.assertEquals(firstSize, wishListService.findAll().size() + 1);


    }


}
