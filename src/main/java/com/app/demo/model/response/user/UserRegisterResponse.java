package com.app.demo.model.response.user;
import com.app.demo.model.entity.UserEntity;
import com.app.demo.model.request.address.AddressRequest;
import com.app.demo.model.response.address.AddressResponse;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
public class UserRegisterResponse implements Serializable {
    private Long id;
    private String username;
    private AddressResponse address;

    public UserRegisterResponse(Long id, String username, AddressResponse address) {
        this.id = id;
        this.username = username;
        this.address = address;
    }

    public static UserRegisterResponse fromEntity(UserEntity entity) {
        AddressResponse addr;
        if (entity.getAddress() == null) addr = null;
        else addr = new AddressResponse(entity.getAddress().getId(), entity.getAddress().getAddress());
        return new UserRegisterResponse(
                entity.getId(),
                entity.getUsername(),
                addr
        );
    }
}
