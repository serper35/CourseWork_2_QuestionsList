package by.coursework.QuestionsExam.Service.Impl;

import by.coursework.QuestionsExam.Question;
import by.coursework.QuestionsExam.Exception.QuestionLimitException;
import by.coursework.QuestionsExam.Service.ExaminerService;
import by.coursework.QuestionsExam.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private QuestionService questionService;


    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        List<Question> randomQ = new ArrayList<>();

        if (amount > questionService.getAll().size()) {
            throw new QuestionLimitException("В базе недостаточно вопросов для выполнения команды!");
        }

        int step = 0;
        while (step < amount) {
            Question random = questionService.getRandomQuestion();
            if (!randomQ.contains(random)) {
                randomQ.add(random);
                step++;
            }
        }

        return randomQ;
    }
}
