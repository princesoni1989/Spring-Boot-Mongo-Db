package com.springboot.mongo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@Document
public class User  {


    @Id
    private String id;
    private String email;

    private String username;

    private String firstName;

    private String lastName;

    private String password;

    public User(String email, String username, String password, String firstName, String lastName, String photo, Boolean active, boolean accountNotExpired, boolean accountNotLocked, boolean credentialNotExpired, boolean isEnabled) {
        super();
        this.email = email;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(User user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.username = user.getUsername();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
    }

}
