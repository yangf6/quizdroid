package quizdroid.yangf6.washington.edu.quizdroid;

import android.app.Application;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2/9/17.
 */

//public class QuizApp extends Application {
//
//    private static final String TAG = "QuizApp";
//    private static QuizApp instance = null;
//    private static TopicRepository quiz;
//    private List<Topic> topics;
//
//    public QuizApp() {
//        if (instance == null) {
//            instance = this;
//        } else {
//            throw new RuntimeException("Cannot create more than one " + TAG);
//        }
//        topics = new ArrayList<Topic>();
//        quiz = new inMemoryRepository();
//    }
//
//    public List<Topic> getAllTopics(){
//        return topics;
//    }
//
//    @Override
//    public void onCreate(){
//        super.onCreate();
//        Log.d(TAG, "it's running!");
//
//    }
//}

import android.app.Application;
import android.util.Log;
import org.json.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;






public class QuizApp extends Application {

    private static QuizApp instance = null;

    private ITopicRepository repo;

    public QuizApp() {
        if (instance == null) {
            instance = this;
        } else {
            throw new RuntimeException("Cannot create more than one QuizApp");
        }
    }

    @Override
    public void onCreate() {
        Log.i("QuizApp", "onCreate() called");
        super.onCreate();
        repo = new InMemoryRepository(); // if JSON fails, backup to use InMemoryRepo

    }

    public List<Topic> getAllTopics() {
        return repo.getAllTopics();
    }

}