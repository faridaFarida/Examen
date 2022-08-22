package Beans;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class StudentWrapper {

    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private String city;
    private Timestamp cityTimeZone;
}
