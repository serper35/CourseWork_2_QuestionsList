package by.coursework.QuestionsExam.Repository.Impl;

import by.coursework.QuestionsExam.Question;
import by.coursework.QuestionsExam.Repository.QuestionRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Repository
@Primary
public class JavaQuestionRepository implements QuestionRepository {

    List<Question> questionsList = new ArrayList<>(List.of(
            new Question("A","B"),
            new Question("C","D"),
            new Question("E","F"),
            new Question("Why","Because"),
            new Question("What","Sun"),
            new Question("Where","City"),
            new Question("Wnen","Winter"),
            new Question("How","Fast")
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
