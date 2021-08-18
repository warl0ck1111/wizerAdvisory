package com.example.wizer.controller;

import com.example.wizer.dto.CategoryDto;
import com.example.wizer.model.Category;
import com.example.wizer.response.JsonResponse;
import com.example.wizer.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryService;

    @PostMapping("/create")
    public ResponseEntity<?> createCategory(@RequestBody CategoryDto dto){


        Category category = categoryService.create(dto);
        return new ResponseEntity<>(new JsonResponse(HttpStatus.OK,"Category Successfully.", category), HttpStatus.OK);
    }

    @PostMapping("/edit")
    public ResponseEntity<?> editCategory(@RequestBody CategoryDto dto){

        Category category = categoryService.create(dto);
        return new ResponseEntity<>(new JsonResponse(HttpStatus.OK,"Category updated Successfully.", category), HttpStatus.OK);
    }


    @GetMapping("/list")
    public ResponseEntity<?> listCategory(){
        return new ResponseEntity<>(new JsonResponse(categoryService.findAll()), HttpStatus.OK);
    }

}
