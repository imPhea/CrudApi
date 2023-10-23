package com.app.demo.model.response.post;

import com.app.demo.model.entity.PostEntity;

import java.io.Serializable;

public class PostResponse implements Serializable {
    private Long id;
    private String tittle;
    private String description;

    public PostResponse(Long id, String tittle, String description) {
        this.id = id;
        this.tittle = tittle;
        this.description = description;
    }
    public static PostResponse fromEntity(PostEntity entity) {
        return new PostResponse(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription()
        );
    }
}
