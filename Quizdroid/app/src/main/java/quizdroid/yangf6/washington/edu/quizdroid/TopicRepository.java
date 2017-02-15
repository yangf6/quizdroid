package quizdroid.yangf6.washington.edu.quizdroid;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by apple on 2/12/17.
 */

public interface TopicRepository {

    public List<Topic> getAllTopics();

    public void setTopics(List<Topic> topics);
}