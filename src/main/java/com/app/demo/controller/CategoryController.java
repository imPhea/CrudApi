package com.app.demo.controller;

import com.app.demo.exception.NotFoundException;
import com.app.demo.model.entity.CategoryEntity;
import com.app.demo.model.request.category.CategoryRequest;
import com.app.demo.model.response.category.CategoryResponse;
import com.app.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping              // create
    public ResponseEntity<CategoryResponse> create(
            @RequestBody CategoryRequest request
    ) throws Exception {
        CategoryEntity category = this.categoryService.create(request);
        return ResponseEntity.ok(CategoryResponse.fromEntity(category));
    }

    @PutMapping("/{id}")      // update
    public ResponseEntity<CategoryResponse> update(@PathVariable Long id, @RequestBody CategoryRequest categoryRequest) throws Exception {
        CategoryEntity category = this.categoryService.update(id, categoryRequest);
        return ResponseEntity.ok(CategoryResponse.fromEntity(category));
    }

    @GetMapping               // display all data
    public ResponseEntity<List<CategoryResponse>> findAll() {
        List<CategoryResponse> category = this.categoryService.findAll().stream().map(CategoryResponse::fromEntity).toList();
        return ResponseEntity.ok(category);
    }

    @GetMapping("/{id}")       // view by id
    public ResponseEntity<CategoryResponse> findOne(@PathVariable Long id) throws NotFoundException {
        CategoryEntity category = this.categoryService.findOne(id);
        return ResponseEntity.ok(CategoryResponse.fromEntity(category));
    }

    @DeleteMapping("/{id}")      // delete by id
    public ResponseEntity<CategoryResponse> delete(@PathVariable Long id) throws Exception {
        CategoryEntity category = this.categoryService.delete(id);
        return ResponseEntity.ok(CategoryResponse.fromEntity(category));
    }

}
