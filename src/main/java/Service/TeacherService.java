package Service;

import Beans.TeacherWrapper;
import Errors.NotFoundError;
import Models.Teacher;
import Repo.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

public class TeacherService {

    @Autowired
    private TeacherRepo teacherRepo;

    public TeacherWrapper getTeacherById(long id) throws NotFoundError {

        TeacherWrapper teacherWrapper = null;

        Optional<Teacher> optionalTeacher = teacherRepo.findById(id);
        if (optionalTeacher.isPresent()) {
            teacherWrapper = new TeacherWrapper();
            Teacher teacher = optionalTeacher.get();
            teacherWrapper.setId(teacher.getId());
            teacherWrapper.setFirstName(teacher.getFirstName());
            teacherWrapper.setLastName(teacher.getLastName());

        } else throw new NotFoundError("Teacher not found");
        return teacherWrapper;
    }

    public TeacherWrapper saveTeacher(@RequestBody TeacherWrapper teacherWrapper) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(teacherWrapper.getFirstName());
        teacher.setLastName(teacherWrapper.getLastName());

        teacher = teacherRepo.save(teacher);
        teacherWrapper.setId(teacher.getId());
        teacherWrapper.setFirstName(teacher.getFirstName());
        teacherWrapper.setLastName(teacher.getLastName());

        return teacherWrapper;
    }

    public TeacherWrapper updateTeacherById(TeacherWrapper teacherInput) throws NotFoundError {

        Optional<Teacher> optionalTeacher = teacherRepo.findById(teacherInput.getId());
        if (optionalTeacher.isPresent()) {
            Teacher teacher = optionalTeacher.get();

            teacher.setFirstName(teacherInput.getFirstName());
            teacher.setLastName(teacherInput.getLastName());
            teacherRepo.save(teacher);

            TeacherWrapper teacherWrapper = new TeacherWrapper();
            teacherWrapper.setId(teacher.getId());
            teacherWrapper.setFirstName(teacher.getFirstName());
            teacherWrapper.setLastName(teacher.getLastName());

            return teacherWrapper;

        } else throw new NotFoundError("Teacher not found");
    }
}
