package com.app.demo.model.request.category;

import com.app.demo.model.entity.CategoryEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class CategoryRequest implements Serializable {
    private String username;
    private String gmail;

    public CategoryEntity toEntity () {
        CategoryEntity category = new CategoryEntity();
        category.setUsername(this.username);
        category.setGmail(this.gmail);
        return category;
    }
}
