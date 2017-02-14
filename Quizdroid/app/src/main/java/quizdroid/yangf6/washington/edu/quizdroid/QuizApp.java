package quizdroid.yangf6.washington.edu.quizdroid;

import android.app.Application;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2/9/17.
 */

public class QuizApp extends Application {

    private static final String TAG = "QuizApp";
    private static QuizApp instance = null;
    private static TopicRepository quiz;
    private List<Topic> topics;

    public QuizApp() {
        if (instance == null) {
            instance = this;
        } else {
            throw new RuntimeException("Cannot create more than one " + TAG);
        }
        topics = new ArrayList<Topic>();
        quiz = new TopicRepository();
    }

    public List<Topic> getTopics(){
        return topics;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        Log.d(TAG, "it's running!");

    }
}
