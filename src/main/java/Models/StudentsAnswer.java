package Models;

import javax.persistence.*;

@Table(name = "studentAnswer")
public class StudentsAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "studentId")
    private long studentId;

    @Column(name = "questionId")
    private long questionId;

    @Column(name = "answerId")
    private long answerId;
}
