package by.coursework.QuestionsExam.Controller;

import by.coursework.QuestionsExam.Question;
import by.coursework.QuestionsExam.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {

    @Qualifier("Math")
    private QuestionService questionService;

    @Autowired
    public MathQuestionController(@Qualifier("Math")QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public String add(@RequestParam("question") String question,
                      @RequestParam("answer") String answer) {
        questionService.add(question, answer);
        return "Вопрос " + question + " добавлен.";
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("question") String question,
                         @RequestParam("answer") String answer) {
        questionService.remove(new Question(question, answer));
        return "Вопрос " + question + " удален.";
    }

    @GetMapping
    public Collection getAll() {
        return questionService.getAll();
    }
}
