package com.example.app.thymeleaf.model;

public class UserMapper {
    public static UserHTTPResponse map(User user) {
        return UserHTTPResponse.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
    }

    public static User map(UserHTTPRequest userHTTPRequest){
        return User.builder()
                .userName(userHTTPRequest.getUserName())
                .password(userHTTPRequest.getPassword())
                .role(userHTTPRequest.getRole())
                .build();
    }

    public static UserHTTPRequest mapRequest(User user) {
        return UserHTTPRequest.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
    }
}
