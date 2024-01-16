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

    private List<QuestionService> questionServices;

    public ExaminerServiceImpl(List<QuestionService> questionService) {
        this.questionServices = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Collection<Question> randomQ = new HashSet<>();

        if (amount > questionServices.get(0).getAll().size() + questionServices.get(1).getAll().size()) {
            throw new QuestionLimitException("В базе недостаточно вопросов для выполнения команды!");
        }


        while (randomQ.size() < amount) {

            Random type = new Random();
            int i = type.nextInt(2);

            if (i == 0) {
                Question random = questionServices.get(0).getRandomQuestion();
                randomQ.add(random);
            } else {
                Question random1 = questionServices.get(1).getRandomQuestion();
                randomQ.add(random1);
            }
        }
        return randomQ;
    }
}

