package Beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentsAnswerWrapper {

    private long id;
    private long studentId;
    private long questionId;
    private long answerId;
}
