package Service;

import Beans.QuestionWrapper;
import Beans.StudentsAnswerWrapper;
import Errors.NotFoundError;
import Models.Answers;
import Models.Questions;
import Models.Student;
import Models.StudentsAnswer;
import Repo.AnswerRepo;
import Repo.QuestionRepo;
import Repo.StudentRepo;
import Repo.StudentsAnswerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

public class StudentsAnswerService {

    @Autowired
    private StudentsAnswerRepo studentsAnswerRepo;
    private StudentRepo studentRepo;
    private AnswerRepo answerRepo;
    private QuestionRepo questionRepo;

    public StudentsAnswerWrapper saveExamen(@RequestBody StudentsAnswerWrapper studentsAnswerWrapper) throws NotFoundError {
        StudentsAnswer studentsAnswer = new StudentsAnswer();

        Optional<Student> optionalStudent = studentRepo.findById(studentsAnswer.getStudentId());
        Optional<Questions> optionalQuestions = questionRepo.findById(studentsAnswer.getQuestionId());
        Optional<Answers> optionalAnswers = answerRepo.findById(studentsAnswer.getAnswerId());

        if(optionalStudent.isPresent() && optionalQuestions.isPresent() && optionalAnswers.isPresent()) {
            studentsAnswer.setStudentId(studentsAnswerWrapper.getStudentId());
            studentsAnswer.setQuestionId(studentsAnswerWrapper.getQuestionId());
            studentsAnswer.setAnswerId(studentsAnswerWrapper.getAnswerId());

            studentsAnswer = studentsAnswerRepo.save(studentsAnswer);
            studentsAnswerWrapper.setId(studentsAnswer.getId());
            studentsAnswerWrapper.setStudentId(studentsAnswer.getStudentId());
            studentsAnswerWrapper.setQuestionId(studentsAnswer.getQuestionId());
            studentsAnswerWrapper.setAnswerId(studentsAnswer.getAnswerId());

            return studentsAnswerWrapper;
        }
        //TODO dividir por if (comprobar por separado cada id)
        else throw new NotFoundError("Student id and question id and answer do not exist");
    }
}
