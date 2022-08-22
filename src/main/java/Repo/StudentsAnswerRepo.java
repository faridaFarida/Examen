package Repo;

import Models.StudentsAnswer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsAnswerRepo extends CrudRepository<StudentsAnswer,Long> {
}
