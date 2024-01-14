package by.coursework.QuestionsExam.Service.Impl;

import by.coursework.QuestionsExam.Exception.QuestionLimitException;
import by.coursework.QuestionsExam.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Mock
    private JavaQuestionService javaQuestionService;

    @Test
    void getQuestions() {
        Question q = new Question("question", "answer");
        Collection<Question> test = new ArrayList<>();
        test.add(q);
        Mockito.when(javaQuestionService.getRandomQuestion()).thenReturn(q);
        Mockito.when(javaQuestionService.getAll()).thenReturn(test);

        Collection<Question> actual = examinerService.getQuestions(1);

        assertIterableEquals(test,actual);
    }

    @Test
    void shouldThrowExceptionWhenAmountIsBiggerThanListSize() {
        assertThrows(QuestionLimitException.class, () -> examinerService.getQuestions(2));
    }
}