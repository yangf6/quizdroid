package quizdroid.yangf6.washington.edu.quizdroid;

import java.io.Serializable;
import java.util.List;

/**
 * Created by apple on 2/15/17.
 */

class Topic implements Serializable {
    private String title;
    private String description;
    private List<Quiz> questions;

    public Topic(String title, String description, List<Quiz> questions) {
        this.title = title;
        this.description = description;
        this.questions = questions;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Quiz> getQuestions() {
        return questions;
    }
}