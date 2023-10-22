package com.app.demo.model.request.user;
import com.app.demo.model.entity.UserEntity;
import com.app.demo.model.request.address.AddressRequest;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
public class UserRegisterRequest implements Serializable {
    private String username;
    private AddressRequest address;

    public AddressRequest getAddress() {
        return address;
    }
    public void setAddress(AddressRequest address) {
        this.address = address;
    }

    public UserEntity toEntity() {
        UserEntity user = new UserEntity();
        user.setUsername(username);
        return user;
    }
}
