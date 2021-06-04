package com.example.app.thymeleaf.service;

import com.example.app.thymeleaf.model.User;
import com.example.app.thymeleaf.model.UserHTTPRequest;
import com.example.app.thymeleaf.model.UserHTTPResponse;
import com.example.app.thymeleaf.model.UserMapper;
import com.example.app.thymeleaf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.StreamSupport.stream;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserHTTPResponse getUserById(long id){
        UserHTTPResponse response = null;
        Optional<User> userEntity = userRepository.findById(id);
        if(userEntity.isPresent()){
            response = UserMapper.map(userEntity.get());
        }
        return response;
    }

    public User findUser(long id) {
        return userRepository.findById(id).get();
    }

    public List<UserHTTPResponse> getAllUsers(){
        return stream(userRepository.findAll().spliterator(), false)
                .map(UserMapper::map)
                .collect(Collectors.toList());
    }

    public void saveUser(UserHTTPRequest userHTTPRequest){
        User user = UserMapper.map(userHTTPRequest);
        userRepository.save(user);
    }

    public void updateUserById(long id, UserHTTPRequest request){
        User entity = UserMapper.map(request);
        entity.setId(id);
        userRepository.save(entity);
    }

    public boolean deleteUserById(long id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
