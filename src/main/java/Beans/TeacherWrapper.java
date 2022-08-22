package Beans;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class TeacherWrapper {
    private long id;
    private String firstName;
    private String lastName;
}
