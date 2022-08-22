package Controllers;

import Beans.QuestionWrapper;
import Service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class QuestionController {

    private QuestionService questionService;

    @PostMapping(value = "/question/save")
    public ResponseEntity<QuestionWrapper> saveQuestion(@RequestBody QuestionWrapper questionWrapper) {
        questionWrapper = questionService.saveQuestion(questionWrapper);
        return ResponseEntity.ok(questionWrapper);
    }
}
