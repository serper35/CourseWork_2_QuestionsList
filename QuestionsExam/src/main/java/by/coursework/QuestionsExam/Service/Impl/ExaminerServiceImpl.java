package by.coursework.QuestionsExam.Service.Impl;

import by.coursework.QuestionsExam.Question;
import by.coursework.QuestionsExam.Exception.QuestionLimitException;
import by.coursework.QuestionsExam.Service.ExaminerService;
import by.coursework.QuestionsExam.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    @Autowired
    private QuestionService questionService;
    @Autowired
    @Qualifier("Math")
    private QuestionService questionServiceMath;


    public ExaminerServiceImpl(QuestionService questionService,
                               @Qualifier("Math") QuestionService questionServiceMath) {
        this.questionService = questionService;
        this.questionServiceMath = questionServiceMath;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Collection<Question> randomQ = new HashSet<>();

        if (amount > questionService.getAll().size() + questionServiceMath.getAll().size()) {
            throw new QuestionLimitException("В базе недостаточно вопросов для выполнения команды!");
        }

        while (randomQ.size() < amount) {
            Random type = new Random();
            int i = type.nextInt(2);

            if (i == 0) {
                Question random = questionService.getRandomQuestion();
                randomQ.add(random);
            } else {
                Question random1 = questionServiceMath.getRandomQuestion();
                randomQ.add(random1);
            }
        }
        return randomQ;

    }
}
