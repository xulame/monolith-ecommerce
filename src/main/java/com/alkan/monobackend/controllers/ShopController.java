package com.alkan.monobackend.controllers;

import com.alkan.monobackend.dtos.ShopDto;
import com.alkan.monobackend.request.CreateShopCategoryRequest;
import com.alkan.monobackend.responses.ShopResponse;
import com.alkan.monobackend.services.ShopService;
import com.alkan.monobackend.services.serviceImpl.ShopServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("shops")
public class ShopController {

    private ShopService service;

    public ShopController(ShopService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<ShopResponse> create(@RequestBody ShopDto shopDto){
        return ResponseEntity.ok(new ShopResponse(2000,"Shop created", service.create(shopDto)));
    }
    @GetMapping("/find-all")
    public ResponseEntity<ShopResponse> findAll(){
        return ResponseEntity.ok(new ShopResponse(2000,"Shops found", service.findAll()));
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        return service.delete(id);
    }
    @PostMapping("/add-category")
    public ResponseEntity<ShopResponse> addCategory(@RequestBody CreateShopCategoryRequest request){
        return ResponseEntity.ok(new ShopResponse(2000,"Category added", service.addCategory(request)));
    }
}
