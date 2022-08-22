package Controllers;

import Beans.StudentsAnswerWrapper;
import Errors.NotFoundError;
import Service.StudentsAnswerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class StudentAnswerController {

    private StudentsAnswerService studentsAnswerService;

    @PostMapping(value = "/studentAnswer/save")
    public ResponseEntity<StudentsAnswerWrapper> saveExamen(@RequestBody StudentsAnswerWrapper studentsAnswerWrapper) throws NotFoundError {
        studentsAnswerWrapper = studentsAnswerService.saveExamen(studentsAnswerWrapper);
        return ResponseEntity.ok(studentsAnswerWrapper);
    }
}
