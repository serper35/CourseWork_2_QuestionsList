package by.coursework.QuestionsExam.Service.Impl;

import by.coursework.QuestionsExam.Exception.QuestionAlreadyAddedException;
import by.coursework.QuestionsExam.Exception.QuestionNotFoundException;
import by.coursework.QuestionsExam.Question;
import by.coursework.QuestionsExam.Repository.QuestionRepository;
import by.coursework.QuestionsExam.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Primary
public class JavaQuestionService implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

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
        copy.addAll(questionRepository.getAll());
        return copy.get(i);
    }
}
