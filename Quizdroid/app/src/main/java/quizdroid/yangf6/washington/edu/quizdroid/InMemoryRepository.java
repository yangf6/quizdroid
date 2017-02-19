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
        physicsQuestions.add(new Quiz("is light a wave?",
                "yes", "no", "unknown",
                "none of the above", 1));
        physicsQuestions.add(new Quiz("is light a practicle?", "yes", "no", "unknown",
                "none of the above", 1));
        marvelQuestions.add(new Quiz("how are you",
                "a", "b", "c",
                "d", 3));
        marvelQuestions.add(new Quiz("how are you",
                "a", "b", "c",
                "d", 3));


        Topic math = new Topic("Math","Math Descr", mathQuestions);
        Topic physics = new Topic("Physics", "Physics Descr",
                physicsQuestions);
        Topic marvel = new Topic("Marvel Super Heroes",
                "Marvel Desecr", marvelQuestions);

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
