package com.example.femivio.service;

import com.example.femivio.model.Food;
import com.example.femivio.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    public Food addFood(Food food) {
        return foodRepository.save(food);
    }

    public Food getFoodById(Long id) {
        return foodRepository.findById(id).orElse(null);
    }
}
