package com.nagp.ecs.ecomapp.service;

import java.util.List;
import jakarta.transaction.Transactional;
import com.nagp.ecs.ecomapp.model.*;
import com.nagp.ecs.ecomapp.repository.*;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class WishListService {

    private final WishListRepository wishListRepository;

    public WishListService(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    public void createWishlist(WishList wishList) {
        wishListRepository.save(wishList);
    }

    public List<WishList> readWishList(Integer userId) {
        return wishListRepository.findAllByUserIdOrderByCreatedDateDesc(userId);
    }
}
