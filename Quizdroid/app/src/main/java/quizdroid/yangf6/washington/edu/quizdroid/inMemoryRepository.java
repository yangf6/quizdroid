package quizdroid.yangf6.washington.edu.quizdroid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2/13/17.
 */

public class inMemoryRepository implements TopicRepository {

    private List<Topic> topics = new ArrayList<Topic>();

    public inMemoryRepository() {
        topics = new ArrayList<Topic>();

        List<Question> mathQuestions = new ArrayList<Question>();
        List<Question> physicsQuestions = new ArrayList<Question>();
        List<Question> marvelQuestions = new ArrayList<Question>();

        mathQuestions.add(new Question("1 + 1?", "2", "11", "13", "4", 1));
        mathQuestions.add(new Question("1 * 1?", "1", "3", "11", "111", 1));
        physicsQuestions.add(new Question("Which law states the need to wear seatbelts?",
                "Newton's First Law", "Newton's Second Law", "Newton's Third Law",
                "none of the above", 3));
        physicsQuestions.add(new Question("What is force?", "mass", "mass * acceleration",
                "speed + time", "acceleration * speed", 2));
        marvelQuestions.add(new Question("The Fantastic Four have the headquarters in what building?",
                "Stark Tower", "Fantastic Headquarters", "Baxter Building",
                "Xavier Institute", 3));
        marvelQuestions.add(new Question("Peter Parker works as a photographer for:",
                "The Daily Planet", "The Daily Bugle", "The New York Times",
                "The Rolling Stone", 2));


        Topic math = new Topic("Math","Worst topic of all time", mathQuestions);
        Topic physics = new Topic("Physics", "Find out how close you compare to Albert", physicsQuestions);
        Topic marvel = new Topic("Marvel Super Heroes", "Find out how much you know about Marvel\'s own superheroes", marvelQuestions);

        topics.add(math);
        topics.add(physics);
        topics.add(marvel);
    }

    public inMemoryRepository(List<Topic> topics) {
        this.topics = topics;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }
}