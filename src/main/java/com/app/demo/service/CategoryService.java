package com.app.demo.service;

import com.app.demo.exception.AlreadyExistException;
import com.app.demo.exception.NotFoundException;
import com.app.demo.model.entity.CategoryEntity;
import com.app.demo.model.request.category.CategoryRequest;
import com.app.demo.repository.CategoryRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    // extend one for use all in class
    private final CategoryRepository categoryRepository;

    @Autowired // use for know is injection jol
    public CategoryService(CategoryRepository _categoryRepository) {
        this.categoryRepository = _categoryRepository;
    }

    public CategoryEntity create(CategoryRequest request) throws Exception {
        //prepare request to entity
        CategoryEntity data = request.toEntity();
        // check name in db exist or not
        if (this.categoryRepository.existsByUsername(data.getUsername()))
            throw new AlreadyExistException("This username is already exist in database!");
        try {
            return this.categoryRepository.save(request.toEntity());
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }


    public CategoryEntity update(Long id, CategoryRequest request) throws Exception {
        // b4 update check exist or not
        CategoryEntity foundData = this.categoryRepository.findById(id).orElseThrow(()-> new NotFoundException("Category not found!"));
        // add request data to existing data
        foundData.setUsername(request.getUsername());
        foundData.setGmail(request.getGmail());
        try {
            // update entity
            return this.categoryRepository.save(foundData);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public List<CategoryEntity> findAll() {
        return this.categoryRepository.findAll();
    }

    public CategoryEntity findOne(Long id) throws NotFoundException {
        return this.categoryRepository.findById(id).orElseThrow(()->new NotFoundException("Category not found!"));
    }

    public CategoryEntity delete(Long id) throws Exception {
        // get category data from db by id
        CategoryEntity category = this.findOne(id);
        try {
            // if everything work well then delete
            this.categoryRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception(e);
        }
        return category;
    }
}
