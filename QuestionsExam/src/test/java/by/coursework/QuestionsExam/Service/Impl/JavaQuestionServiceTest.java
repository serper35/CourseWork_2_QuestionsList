package by.coursework.QuestionsExam.Service.Impl;

import by.coursework.QuestionsExam.Exception.QuestionAlreadyAddedException;
import by.coursework.QuestionsExam.Exception.QuestionNotFoundException;
import by.coursework.QuestionsExam.Question;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    JavaQuestionService javaQuestionService = new JavaQuestionService();
    Question question = new Question("1","2");


    @Test
    void shouldAddCorrectly() {
        Question actual = javaQuestionService.add(question);

        assertEquals(question, actual);
    }

    @Test
    void shouldThrowExceptionWhenQuestionAlreadyAdded() {
        Question actual = javaQuestionService.add(question);

        assertThrows(QuestionAlreadyAddedException.class,() -> javaQuestionService.add(question));
    }

    @Test
    void shouldRemoveCorrectly() {
        Question actual = javaQuestionService.add(question);
        javaQuestionService.remove(question);

        assertEquals(question, actual);
    }

    @Test
    void shouldThrowExceptionWhenQuestionNotFound() {
        assertThrows(QuestionNotFoundException.class, () -> javaQuestionService.remove(question));
    }

    @Test
    void getAll() {
        assertEquals(8, javaQuestionService.getAll().size());
    }
}