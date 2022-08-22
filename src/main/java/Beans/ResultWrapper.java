package Beans;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter
public class ResultWrapper {

    private long id;
    private long studentId;
    private Timestamp date;
    private int result;
}
