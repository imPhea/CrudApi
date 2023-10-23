package com.app.demo.service;
import com.app.demo.exception.AlreadyExistException;
import com.app.demo.exception.BadRequestException;
import com.app.demo.exception.NotFoundException;
import com.app.demo.model.entity.UserEntity;
import com.app.demo.model.request.user.UserLoginRequest;
import com.app.demo.model.request.user.UserRegisterRequest;
import com.app.demo.repository.AddressRepository;
import com.app.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    // this is dependency autowire injection
    @Autowired
    public UserService(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    // for register
    public UserEntity register(UserRegisterRequest req) throws Exception {
        // prepare request to parent's entity
        UserEntity request = req.toEntity();
        // check if username already exist then throw error
        if (this.userRepository.existsByUsername(req.getUsername()))
            throw new AlreadyExistException("Username is already exists!");
        UserEntity userEn;
        try {
            // save user and address to entity
            userEn = this.userRepository.save(request);
            this.addressRepository.save(req.getAddress().toEntity(userEn));
            return this.userRepository.findById(userEn.getId()).orElseThrow(()->new NotFoundException("User not found"));
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    // display all data
    public List<UserEntity> findAll() {
        return this.userRepository.findAll();
    }

    // find user by id
    public UserEntity findOne(Long id) throws NotFoundException {
        return this.userRepository.findById(id).orElseThrow(()->new NotFoundException("User not found!"));
    }

    // update user by id
    public UserEntity update(Long id, UserRegisterRequest req) throws Exception{
        // validate that user has or not
        UserEntity foundUser = this.userRepository.findById(id).orElseThrow(()->new NotFoundException("User not found."));
        // validate check if username already exist then throw error
        // user have in db             username new input
        if (foundUser.getUsername() != req.getUsername())
            if (this.userRepository.existsByUsername(req.getUsername()))
                throw new AlreadyExistException("Username already exist.");

        // prepare data
        foundUser.setUsername(req.getUsername());

        // set save null address to db
        if(req.getAddress() == null)
            foundUser.setAddress(null);
        else foundUser.setAddress(req.getAddress().toEntity(foundUser));

        try {
            System.out.println("Hello address: "+foundUser.getAddress());
            return this.userRepository.save(foundUser);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    // login service
    public UserEntity login(UserLoginRequest req) throws BadRequestException {
        return this.userRepository.findByUsername(req.getUsername()).orElseThrow(()-> new BadRequestException("Invalid username."));
    }

    public void delete(Long id) throws Exception {
        try {
            this.userRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
