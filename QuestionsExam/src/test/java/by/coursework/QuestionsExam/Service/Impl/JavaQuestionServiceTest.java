package by.coursework.QuestionsExam.Service.Impl;

import by.coursework.QuestionsExam.Exception.QuestionAlreadyAddedException;
import by.coursework.QuestionsExam.Exception.QuestionNotFoundException;
import by.coursework.QuestionsExam.Question;
import by.coursework.QuestionsExam.Repository.Impl.JavaQuestionRepository;
import by.coursework.QuestionsExam.Service.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    @Mock
    JavaQuestionRepository questionRepository;
    @InjectMocks
    JavaQuestionService javaQuestionService;
    Question question = new Question("1","2");


    @Test
    void shouldAddCorrectly() {
        when(questionRepository.add(question)).thenReturn(question);
        Question actual = javaQuestionService.add(question);

        assertEquals(question, actual);
    }

    @Test
    void shouldThrowExceptionWhenQuestionAlreadyAdded() {
        Collection<Question> test = new ArrayList<>();
        test.add(question);
        when(questionRepository.getAll()).thenReturn(test);

        assertThrows(QuestionAlreadyAddedException.class,() -> javaQuestionService.add(question));
    }

    @Test
    void shouldRemoveCorrectly() {
        Collection<Question> test = new ArrayList<>();
        test.add(question);
        when(questionRepository.getAll()).thenReturn(test);
        when(questionRepository.remove(question)).thenReturn(question);
        Question actual = javaQuestionService.remove(question);

        assertEquals(question, actual);
    }
//
    @Test
    void shouldThrowExceptionWhenQuestionNotFound() {
        when(questionRepository.getAll()).thenReturn(Collections.singletonList(new Question("23423", "234")));
        assertThrows(QuestionNotFoundException.class, () -> javaQuestionService.remove(question));
    }
//
    @Test
    void getAll() {
        when(questionRepository.getAll()).thenReturn(Collections.singletonList(new Question("23423", "234")));
        assertEquals(1, javaQuestionService.getAll().size());
    }

    @Test
    void getRandom() {Collection<Question> test = new ArrayList<>();
        test.add(question);
        when(questionRepository.getAll()).thenReturn(test);
        Question actual = javaQuestionService.getRandomQuestion();

        assertTrue(javaQuestionService.getAll().contains(question));
    }
}