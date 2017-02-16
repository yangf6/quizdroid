package quizdroid.yangf6.washington.edu.quizdroid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2/15/17.
 */

// An implementation of a TopicRepository that has hardcoded values for the topics
class InMemoryRepository implements ITopicRepository{
    private List<Topic> topics;

    public InMemoryRepository() {
        topics = new ArrayList<Topic>();

        List<Quiz> mathQuestions = new ArrayList<Quiz>();
        List<Quiz> physicsQuestions = new ArrayList<Quiz>();
        List<Quiz> marvelQuestions = new ArrayList<Quiz>();

        mathQuestions.add(new Quiz("What is 1 + 1?", "2", "11", "13", "4", 1));
        mathQuestions.add(new Quiz("What is 1 * 1?", "1", "3", "11", "111", 1));
        physicsQuestions.add(new Quiz("Which law states the need to wear seatbelts?",
                "Newton's First Law", "Newton's Second Law", "Newton's Third Law",
                "none of the above", 3));
        physicsQuestions.add(new Quiz("What is force?", "mass", "mass * acceleration",
                "speed + time", "acceleration * speed", 2));
        marvelQuestions.add(new Quiz("The Fantastic Four have the headquarters in what building?",
                "Stark Tower", "Fantastic Headquarters", "Baxter Building",
                "Xavier Institute", 3));
        marvelQuestions.add(new Quiz("Peter Parker works as a photographer for:",
                "The Daily Planet", "The Daily Bugle", "The New York Times",
                "The Rolling Stone", 2));


        Topic math = new Topic("Math","Worst topic of all time", mathQuestions);
        Topic physics = new Topic("Physics", "Find out how close you compare to Albert",
                physicsQuestions);
        Topic marvel = new Topic("Marvel Super Heroes",
                "Find out how much you know about Marvel\'s own superheroes", marvelQuestions);

        topics.add(math);
        topics.add(physics);
        topics.add(marvel);
    }

    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopicByTitle(String title) {
        for (Topic topic : topics) {
            if (topic.getTitle().equals(title)) {
                return topic;
            }
        }
        return null;
    }
}
