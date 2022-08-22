package Models;

import javax.persistence.*;

@Table(name = "question")
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "question")
    private String question;
}
