package Controllers;

import Beans.StudentWrapper;
import Errors.NotFoundError;
import Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class StudentController {

    private StudentService studentService;

    @GetMapping(value = "/student/{id}")
    public ResponseEntity<StudentWrapper> getStudent(@PathVariable Long id) throws NotFoundError {
        StudentWrapper studentWrapper = studentService.getStudentById(id);
        return ResponseEntity.ok(studentWrapper);
    }

    @PostMapping(value = "/student/save")
    public ResponseEntity<StudentWrapper> saveStudent(@RequestBody StudentWrapper studentWrapper) {
        studentWrapper = studentService.saveStudent(studentWrapper);
        return ResponseEntity.ok(studentWrapper);
    }

    @PutMapping(value = "/student/update/{id}")
    public ResponseEntity<StudentWrapper> updateStudent(@PathVariable StudentWrapper studentWrapper) throws NotFoundError {
        studentWrapper = studentService.updateStudentById(studentWrapper);
        return ResponseEntity.ok(studentWrapper);
    }
}
