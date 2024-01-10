package by.coursework.QuestionsExam.Controller;

import by.coursework.QuestionsExam.Question;
import by.coursework.QuestionsExam.Service.ExaminerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/random")
public class ExamController {

//    @Autowired
    private ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping
    public Collection<Question> getRandomList(@RequestParam("amount") int amount) {
        return examinerService.getQuestions(amount);
    }
}
