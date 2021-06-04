package com.example.app.thymeleaf.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserHTTPResponse {
    private long id;
    private String userName;
    private String password;
    private Roles role;

    public UserHTTPResponse(long id, String userName, String password, Roles role) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public static UserHTTPResponseBuilder builder() {
        return new UserHTTPResponseBuilder();
    }

    public static final class UserHTTPResponseBuilder {
        private long id;
        private String userName;
        private String password;
        private Roles role;

        private UserHTTPResponseBuilder() {
        }

        public UserHTTPResponseBuilder id(long id) {
            this.id = id;
            return this;
        }

        public UserHTTPResponseBuilder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public UserHTTPResponseBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserHTTPResponseBuilder role(Roles role) {
            this.role = role;
            return this;
        }

        public UserHTTPResponse build() {
            return new UserHTTPResponse(id, userName, password, role);
        }
    }
}
