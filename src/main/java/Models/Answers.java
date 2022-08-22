package Models;

import javax.persistence.*;

@Table(name = "answer")
public class Answers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "questionId")
    private long questionId;

    @Column(name = "answer")
    private String answer;

    @Column(name = "point")
    private int point;
}
