package com.app.demo.model.request.user;

import com.app.demo.model.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class UserLoginRequest implements Serializable {
    private String username;
}
