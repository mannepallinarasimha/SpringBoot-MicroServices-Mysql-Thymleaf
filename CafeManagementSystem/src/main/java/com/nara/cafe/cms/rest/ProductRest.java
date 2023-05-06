package com.nara.cafe.cms.rest;

import com.nara.cafe.cms.wrapper.ProductWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping(path="/product")
public interface ProductRest {

    @PostMapping(path="/add")
    ResponseEntity<String> addNewProduct(@RequestBody(required = true) Map<String, String> requestMap);

    @GetMapping(path="/get")
    ResponseEntity<List<ProductWrapper>> getAllProducts();

    @PostMapping(path="/update")
    ResponseEntity<String> updateProduct(@RequestBody(required = true) Map<String, String> requestMap);

    @PostMapping(path="/delete/{id}")
    ResponseEntity<String> deleteProduct(@PathVariable("id") Integer id);

    @PostMapping(path="/updateProductStatus")
    ResponseEntity<String> updateProductStatus(@RequestBody(required = true) Map<String, String> requestMap);

    @GetMapping(path="/getByCategory/{id}")
    ResponseEntity<List<ProductWrapper>> getProductsByCategory(@PathVariable("id") Integer id);

    @GetMapping(path="/getById/{id}")
    ResponseEntity<ProductWrapper> getProductsById(@PathVariable("id") Integer id);

}
