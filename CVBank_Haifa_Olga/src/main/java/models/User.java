package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder

public class User {
    String name;
    String lastName;
    String email;
    String password;
    String confirmPassword;

}
