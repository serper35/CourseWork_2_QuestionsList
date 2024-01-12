package by.coursework.QuestionsExam.Repository.Impl;

import by.coursework.QuestionsExam.Question;
import by.coursework.QuestionsExam.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Repository
@Qualifier("Math")
public class MathQuestionRepository implements QuestionRepository {

    List<Question> questionsList = new ArrayList<>(List.of(
            new Question("1*1","1"),
            new Question("2*2","4"),
            new Question("3*3","9"),
            new Question("4*4","16"),
            new Question("5*5","25"),
            new Question("6*6","36"),
            new Question("7*7","49"),
            new Question("10*10","100")
    ));


    @Override
    public Question add(Question question) {
        questionsList.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questionsList.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questionsList);
    }
}
