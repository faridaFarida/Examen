package Service;

import Beans.StudentWrapper;
import Errors.NotFoundError;
import Models.Student;
import Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public StudentWrapper getStudentById(long id) throws NotFoundError {

        StudentWrapper studentWrapper = null;

        Optional<Student> optionalStudent = studentRepo.findById(id);
        if (optionalStudent.isPresent()) {
            studentWrapper = new StudentWrapper();
            Student student = optionalStudent.get();
            studentWrapper.setId(student.getId());
            studentWrapper.setFirstName(student.getFirstName());
            studentWrapper.setLastName(student.getLastName());
            studentWrapper.setAge(student.getAge());
            studentWrapper.setCity(student.getCity());
            studentWrapper.setCityTimeZone(student.getCityTimeZone());

        } else throw new NotFoundError("Student not found");
        return studentWrapper;
    }

    public StudentWrapper saveStudent(@RequestBody StudentWrapper studentWrapper) {
        Student student = new Student();
        student.setFirstName(studentWrapper.getFirstName());
        student.setLastName(studentWrapper.getLastName());
        student.setAge(studentWrapper.getAge());
        student.setCity(studentWrapper.getCity());
        student.setCityTimeZone(studentWrapper.getCityTimeZone());

        student = studentRepo.save(student);
        studentWrapper.setId(student.getId());
        studentWrapper.setFirstName(student.getFirstName());
        studentWrapper.setLastName(student.getLastName());
        studentWrapper.setAge(student.getAge());
        studentWrapper.setCity(student.getCity());
        studentWrapper.setCityTimeZone(student.getCityTimeZone());

        return studentWrapper;
    }

    public StudentWrapper updateStudentById(StudentWrapper studentInput) throws NotFoundError {

        Optional<Student> optionalStudent = studentRepo.findById(studentInput.getId());
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();

            student.setFirstName(studentInput.getFirstName());
            student.setLastName(studentInput.getLastName());
            student.setAge(studentInput.getAge());
            student.setCity(studentInput.getCity());
            student.setCityTimeZone(studentInput.getCityTimeZone());
            studentRepo.save(student);

            StudentWrapper studentWrapper = new StudentWrapper();
            studentWrapper.setId(student.getId());
            studentWrapper.setFirstName(student.getFirstName());
            studentWrapper.setLastName(student.getLastName());
            studentWrapper.setAge(student.getAge());
            studentWrapper.setCity(student.getCity());
            studentWrapper.setCityTimeZone(student.getCityTimeZone());

            return studentWrapper;

        } else throw new NotFoundError("Student not found");
    }
}
