package com.app.demo.model.request.post;

import com.app.demo.model.entity.PostEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class PostRequest implements Serializable {
    private String title;
    private String description;
    public PostEntity toEntity() {
        PostEntity post = new PostEntity();
        post.setTitle(this.getTitle());
        post.setDescription(this.getDescription());
        return post;
    }
}
