package com.app.demo.model.response.user;

import com.app.demo.model.entity.UserEntity;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class UserLoginResponse implements Serializable {
    private final Long id;
    private final String username;

    public UserLoginResponse(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public static UserLoginResponse fromEntity(UserEntity entity) {
        return new UserLoginResponse(entity.getId(), entity.getUsername());
    }
}
