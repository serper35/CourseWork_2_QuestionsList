package by.coursework.QuestionsExam.Service.Impl;

import by.coursework.QuestionsExam.Exception.QuestionAlreadyAddedException;
import by.coursework.QuestionsExam.Exception.QuestionNotFoundException;
import by.coursework.QuestionsExam.Question;
import by.coursework.QuestionsExam.Repository.QuestionRepository;
import by.coursework.QuestionsExam.Service.QuestionService;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Qualifier("Math")
public class MathQuestionService implements QuestionService {
    @Autowired
    @Qualifier("Math")
    private QuestionRepository questionRepository;

//    public MathQuestionService(@Qualifier("Math")QuestionRepository questionRepository) {
//        this.questionRepository = questionRepository;
//    }

    //    List<Question> questionsList = new ArrayList<>(List.of(
//            new Question("1*1","1"),
//            new Question("2*2","4"),
//            new Question("3*3","9"),
//            new Question("4*4","16"),
//            new Question("5*5","25"),
//            new Question("6*6","36"),
//            new Question("7*7","49"),
//            new Question("10*10","100")
//    ));
    @Override
    public Question add(String question, String answer) {
        Question question1 = new Question(question, answer);
        if (questionRepository.getAll().contains(question1)) {
            throw new QuestionAlreadyAddedException("Вопрос уже есть в базе!");
        }

        questionRepository.add(question1);
        return question1;
    }

    @Override
    public Question add(Question question) {
        if (questionRepository.getAll().contains(question)) {
            throw new QuestionAlreadyAddedException("Вопрос уже есть в базе!");
        }

        questionRepository.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (questionRepository.getAll().contains(question)) {
            questionRepository.remove(question);
        } else {
            throw new QuestionNotFoundException("Вопрос отсутствует в базе!");
        }

        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int i = random.nextInt(0, questionRepository.getAll().size());
        List<Question> copy = new ArrayList<>(questionRepository.getAll().size());
        return copy.get(i);
    }
}
