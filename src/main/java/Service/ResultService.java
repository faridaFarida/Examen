package Service;

import Beans.QuestionWrapper;
import Beans.ResultWrapper;
import Beans.StudentWrapper;
import Errors.NotFoundError;
import Models.Answers;
import Models.Questions;
import Models.Result;
import Models.Student;
import Repo.AnswerRepo;
import Repo.QuestionRepo;
import Repo.ResultRepo;
import Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

public class ResultService {

    @Autowired
    private ResultRepo resultRepo;
    private StudentRepo studentRepo;
    private AnswerRepo answerRepo;

    public ResultWrapper saveExamDate(@RequestBody ResultWrapper resultWrapper) throws NotFoundError {
        //TODO solo el profesor puede añadir esa informacion
        Result result = new Result();
        Optional<Result> optionalResult = resultRepo.findById(result.getStudentId());

        if (optionalResult.isPresent()) {
            result.setStudentId(resultWrapper.getStudentId());
            result.setDate(resultWrapper.getDate());
            result = resultRepo.save(result);
            resultWrapper.setId(result.getId());
            resultWrapper.setStudentId(result.getStudentId());
            resultWrapper.setDate(result.getDate());
            resultWrapper.setResult(0);

            return resultWrapper;
        } else throw new NotFoundError("Student do not exist");
    }

    public ResultWrapper updateResult(ResultWrapper resultInput) throws NotFoundError {

        Optional<Result> optionalResult = resultRepo.findById(resultInput.getStudentId());
        Optional<Answers> optionalAnswers = answerRepo.findById(resultInput.getId());
        int resultCount = 0;
        if (optionalResult.isPresent()) {
            Result result = optionalResult.get();

            //TODO añadir loop de terminar examen
            if (optionalAnswers.get().getPoint() == 1) {
                resultCount++;
            }
            result.setResult(resultInput.getResult());
            resultRepo.save(result);

            ResultWrapper resultWrapper = new ResultWrapper();
            resultWrapper.setId(result.getId());
            resultWrapper.setStudentId(result.getStudentId());
            resultWrapper.setDate(result.getDate());
            resultWrapper.setResult(result.getResult());

            return resultWrapper;

        } else throw new NotFoundError("Student not found");
    }
}
