package by.coursework.QuestionsExam.Repository.Impl;

import by.coursework.QuestionsExam.Question;
import by.coursework.QuestionsExam.Repository.QuestionRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathQuestionRepositoryTest {
    private QuestionRepository questionRepository = new MathQuestionRepository();

    Question question = new Question("1", "2");

    @Test
    void add() {
        Question actual = questionRepository.add(question);
        assertEquals(question, actual);
    }

    @Test
    void remove() {
        questionRepository.add(question);
        Question actual = questionRepository.remove(question);
        assertEquals(question, actual);
    }

    @Test
    void getAll() {
        assertEquals(8, questionRepository.getAll().size());
    }

}