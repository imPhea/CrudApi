package com.app.demo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "addresses")
@Getter
@Setter
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String address;

    @OneToOne
    @JoinColumn(name = "userId", nullable = false, referencedColumnName = "id")
    private UserEntity user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getAddress(), that.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAddress());
    }
}
