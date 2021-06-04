package com.example.app.thymeleaf.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserHTTPRequest {
    private long id;
    private String userName;
    private String password;
    private Roles role;

    public UserHTTPRequest(long id, String userName, String password, Roles role) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public static UserHTTPRequestBuilder builder() {
        return new UserHTTPRequestBuilder();
    }

    public static final class UserHTTPRequestBuilder {
        private long id;
        private String userName;
        private String password;
        private Roles role;

        private UserHTTPRequestBuilder() {
        }

        public UserHTTPRequestBuilder id(long id) {
            this.id = id;
            return this;
        }

        public UserHTTPRequestBuilder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public UserHTTPRequestBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserHTTPRequestBuilder role(Roles role) {
            this.role = role;
            return this;
        }

        public UserHTTPRequest build() {
            UserHTTPRequest userHTTPRequest = new UserHTTPRequest();
            userHTTPRequest.setId(id);
            userHTTPRequest.setUserName(userName);
            userHTTPRequest.setPassword(password);
            userHTTPRequest.setRole(role);
            return userHTTPRequest;
        }
    }
}
