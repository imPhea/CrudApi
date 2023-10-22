package com.app.demo.model.request.address;
import com.app.demo.model.entity.AddressEntity;
import com.app.demo.model.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
public class AddressRequest implements Serializable {
    private String address;

    public AddressEntity toEntity(UserEntity parentEntity) {
        AddressEntity address = new AddressEntity();
        address.setAddress(this.address);
        address.setUser(parentEntity);
        return address;
    }
}
