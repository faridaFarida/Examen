package Repo;

import Models.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepo extends CrudRepository<Teacher, Long> {
}
