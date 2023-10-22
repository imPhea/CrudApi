package com.app.demo.model.response.category;

import com.app.demo.model.entity.CategoryEntity;
import lombok.Getter;

import java.io.Serializable;

// imp serialize use for convert to byte stream in network(api)
@Getter
public class CategoryResponse implements Serializable {
    private  Long id;
    private  String username;
    private  String gmail;

    // constructor
    public CategoryResponse(Long _id, String _username, String _gmail) {
        this.id = _id;
        this.username = _username;
        this.gmail = _gmail;
    }
    public static CategoryResponse fromEntity(CategoryEntity entity) {
        return new CategoryResponse(
                entity.getId(),
                entity.getUsername(),
                entity.getGmail()
            );
        }
}
