package Service;

import Beans.AnswerWrapper;
import Errors.NotFoundError;
import Models.Answers;
import Models.Questions;
import Models.Student;
import Repo.AnswerRepo;
import Repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

public class AnswerService {

    @Autowired
    private AnswerRepo answerRepo;
    private QuestionRepo questionRepo;

    public AnswerWrapper saveAnswer(@RequestBody AnswerWrapper answerWrapper) throws NotFoundError{

        Answers answers = new Answers();
        Optional<Questions> optionalQuestions = questionRepo.findById(answerWrapper.getQuestionId());
        if (optionalQuestions.isPresent()) {
            answers.setQuestionId(answerWrapper.getQuestionId());
            answers.setAnswer(answerWrapper.getAnswer());
            answers.setPoint(answers.getPoint());

            answers = answerRepo.save(answers);
            answerWrapper.setId(answers.getId());
            answerWrapper.setQuestionId(answers.getQuestionId());
            answerWrapper.setAnswer(answers.getAnswer());
            answerWrapper.setPoint(answers.getPoint());

            return answerWrapper;
        }
        else throw new NotFoundError("Question id do not exist");
    }
}
