package Beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerWrapper {

    private long id;
    private long questionId;
    private String answer;
    private int point;
}
