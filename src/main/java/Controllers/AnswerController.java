package Controllers;

import Beans.AnswerWrapper;
import Errors.NotFoundError;
import Service.AnswerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AnswerController {

    private AnswerService answerService;

    @PostMapping(value = "/answer/save")
    public ResponseEntity<AnswerWrapper> saveQuestion(@RequestBody AnswerWrapper answerWrapper) throws NotFoundError {
        answerWrapper = answerService.saveAnswer(answerWrapper);
        return ResponseEntity.ok(answerWrapper);
    }
}
