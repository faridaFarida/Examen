package Service;

import Beans.QuestionWrapper;
import Models.Questions;
import Repo.QuestionRepo;
import Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

public class QuestionService {

    @Autowired
    private QuestionRepo questionRepo;

    public QuestionWrapper saveQuestion(@RequestBody QuestionWrapper questionWrapper) {
        Questions questions = new Questions();
        questions.setQuestion(questionWrapper.getQuestion());

        questions = questionRepo.save(questions);
        questionWrapper.setId(questions.getId());
        questionWrapper.setQuestion(questions.getQuestion());

        return questionWrapper;
    }
}
