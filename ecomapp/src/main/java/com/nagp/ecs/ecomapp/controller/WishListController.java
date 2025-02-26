/*
 * package com.nagp.ecs.ecomapp.controller;
 * 
 * 
 * import com.nagp.ecs.ecomapp.common.ApiResponse; import
 * com.nagp.ecs.ecomapp.dto.*; import com.nagp.ecs.ecomapp.model.Product; import
 * com.nagp.ecs.ecomapp.model.User; import com.nagp.ecs.ecomapp.model.WishList;
 * import com.nagp.ecs.ecomapp.service.AuthenticationService; import
 * com.nagp.ecs.ecomapp.service.ProductService; import
 * com.nagp.ecs.ecomapp.service.WishListService;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity;
 * 
 * import org.springframework.web.bind.annotation.*;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * @RestController
 * 
 * @RequestMapping("/wishlist") public class WishListController {
 * 
 * @Autowired private WishListService wishListService;
 * 
 * @Autowired private AuthenticationService authenticationService;
 * 
 * @GetMapping("/{token}") public ResponseEntity<List<ProductDto>>
 * getWishList(@PathVariable("token") String token) { int user_id =
 * authenticationService.getUser(token).getId(); List<WishList> body =
 * wishListService.readWishList(user_id); List<ProductDto> products = new
 * ArrayList<ProductDto>(); for (WishList wishList : body) {
 * products.add(ProductService.getDtoFromProduct(wishList.getProduct())); }
 * 
 * return new ResponseEntity<List<ProductDto>>(products, HttpStatus.OK); }
 * 
 * @PostMapping("/add") public ResponseEntity<ApiResponse>
 * addWishList(@RequestBody Product product, @RequestParam("token") String
 * token) { authenticationService.authenticate(token); User user =
 * authenticationService.getUser(token); WishList wishList = new WishList(user,
 * product); wishListService.createWishlist(wishList); return new
 * ResponseEntity<ApiResponse>(new ApiResponse(true, "Add to wishlist"),
 * HttpStatus.CREATED);
 * 
 * }
 * 
 * 
 * }
 */