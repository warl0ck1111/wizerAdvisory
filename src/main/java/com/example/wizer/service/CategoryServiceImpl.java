package com.example.wizer.service;

import com.example.wizer.dto.CategoryDto;
import com.example.wizer.model.Category;
import com.example.wizer.repository.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

@Service
public class CategoryServiceImpl implements CRUDService<Category, CategoryDto> {

    @Autowired
    private CategoryRepository categoryRepository;

    private Category category;

    @Override
    public Category create(CategoryDto categoryDto) {
        if (categoryDto.getName().isBlank()){
            throw new IllegalArgumentException("Category Name cannot be empty");
        }

        category = new Category(categoryDto.getName());
        return categoryRepository.save(category) ;
    }

    @Override
    public List<Category> create(List<CategoryDto> categoryDtos) {

        Predicate<CategoryDto> isCategoryNameValid = (x)-> (x.getName() ==null) || !x.getName().isBlank();

        int counter = (int) categoryDtos.stream().filter(isCategoryNameValid.negate()).count();


        categoryDtos.stream().filter(isCategoryNameValid).forEach(x->{
            category = new Category(x.getName());
            categoryRepository.save(category);
        });
        return null;
    }

    @Override
    public Category update(CategoryDto categoryDto) {
        if (categoryDto.getId() <= 0) throw new IllegalArgumentException("Invalid ID supplied");

        if (categoryDto.getName().isBlank()){
            throw new IllegalArgumentException("invalid Category Name");
        }

        category = categoryRepository.findById(categoryDto.getId()).orElseThrow(()-> new NoSuchElementException("There is no record matching the Id" ));
        BeanUtils.copyProperties(categoryDto, category);

        return categoryRepository.save(category) ;
    }

    @Override
    public List<Category> update(List<CategoryDto> d) {

        return null;
    }

    @Override
    public Boolean delete(Long id) {
        if (id <= 0) throw new IllegalArgumentException("Invalid ID supplied");
        categoryRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(long id) {
        if (id <= 0)
            throw new IllegalArgumentException(String.format("Invalid Id \"%d\". Id can not be less than or equal to 0.", id));
        return categoryRepository.findById(id).orElseThrow(()-> new NoSuchElementException("There is no record matching the Id "));
    }
}
