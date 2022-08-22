package Controllers;

import Beans.TeacherWrapper;
import Errors.NotFoundError;
import Service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class TeacherController {
    private TeacherService teacherService;

    @GetMapping(value = "/teacher/{id}")
    public ResponseEntity<TeacherWrapper> getTeacher(@PathVariable Long id) throws NotFoundError {
        TeacherWrapper teacherWrapper = teacherService.getTeacherById(id);
        return ResponseEntity.ok(teacherWrapper);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<TeacherWrapper> saveTeacher(@RequestBody TeacherWrapper teacherWrapper) {
        teacherWrapper = teacherService.saveTeacher(teacherWrapper);
        return ResponseEntity.ok(teacherWrapper);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<TeacherWrapper> updateTeacher(@PathVariable TeacherWrapper teacherWrapper) throws NotFoundError {
        teacherWrapper = teacherService.updateTeacherById(teacherWrapper);
        return ResponseEntity.ok(teacherWrapper);
    }
}
