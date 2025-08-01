// src/main/java/com/example/femivio/controller/FoodController.java

package com.example.femivio.controller;

import com.example.femivio.Repository.FoodRepository;
import com.example.femivio.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
@CrossOrigin(origins = "*")
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;

    @GetMapping
    public List<Food> getAllFood() {
        return foodRepository.findAll();
    }
}
