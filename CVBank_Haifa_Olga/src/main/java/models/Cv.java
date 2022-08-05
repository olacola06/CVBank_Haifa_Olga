package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString

public class Cv {
    String name;
    String position;
    String birthday;
    String country;
    String city;
    String phone;
    String email;
    String companyName;
    String companyLocation;
    String companyUrl;
}
