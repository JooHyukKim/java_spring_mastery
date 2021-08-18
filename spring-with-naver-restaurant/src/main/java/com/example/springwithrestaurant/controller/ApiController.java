package com.example.springwithrestaurant.controller;

import com.example.springwithrestaurant.wishlist.dto.WishListDto;
import com.example.springwithrestaurant.wishlist.entity.WishListEntity;
import com.example.springwithrestaurant.wishlist.repository.WishListRepository;
import com.example.springwithrestaurant.wishlist.service.WishListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/food")
@RequiredArgsConstructor
public class ApiController {

    private final WishListService wishListService;

    @GetMapping("/search")
    public WishListDto search(@RequestParam String query) {
        return wishListService.search(query);
    }

    @PostMapping("")
    public WishListDto add(@RequestBody WishListDto wishListDto) {
        log.info("{}    ", wishListDto);
        return wishListService.add(wishListDto);
    }

    @GetMapping("/wish-list")
    public List<WishListDto> findALl() {
        return wishListService.findAll();
    }

    @DeleteMapping("/{index}")
    public void delete(@PathVariable int index) {
        wishListService.deleteById(index );
    }

    @PostMapping("/{index}")
    public void addVisit(@PathVariable int index) {
        wishListService.addVisit(index);
    }
}
