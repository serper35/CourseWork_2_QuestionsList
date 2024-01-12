package by.coursework.QuestionsExam.Repository;

import by.coursework.QuestionsExam.Question;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface QuestionRepository {
    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();

}
