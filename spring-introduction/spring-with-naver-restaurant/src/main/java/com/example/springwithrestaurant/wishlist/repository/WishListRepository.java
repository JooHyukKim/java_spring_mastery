package com.example.springwithrestaurant.wishlist.repository;

import com.example.springwithrestaurant.db.MemoryDbRepositoryAbstract;
import com.example.springwithrestaurant.wishlist.entity.WishListEntity;
import org.springframework.stereotype.Repository;

@Repository
public class WishListRepository extends MemoryDbRepositoryAbstract<WishListEntity> {

}
