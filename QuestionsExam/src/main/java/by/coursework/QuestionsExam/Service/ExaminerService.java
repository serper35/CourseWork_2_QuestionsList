package by.coursework.QuestionsExam.Service;

import by.coursework.QuestionsExam.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);

}
