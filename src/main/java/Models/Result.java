package Models;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "result")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "studentId")
    private long studentId;

    @Column(name = "date")
    private Timestamp date;

    @Column(name = "result")
    private int result;
}
