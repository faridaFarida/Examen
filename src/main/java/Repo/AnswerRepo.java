package Repo;

import Models.Answers;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepo extends CrudRepository<Answers,Long> {
}
