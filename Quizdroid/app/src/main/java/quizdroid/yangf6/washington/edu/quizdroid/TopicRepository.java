package quizdroid.yangf6.washington.edu.quizdroid;

/**
 * Created by apple on 2/12/17.
 */

public class TopicRepository {
    private static TopicRepository instance = new TopicRepository();

    public static TopicRepository getInstance(){
        return instance;
    }

    private List<Question> question = new ArrayList<Question>();

    public List<Question> getAllQuestions(){
        return question;
    }
}
