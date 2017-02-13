package quizdroid.yangf6.washington.edu.quizdroid;

import android.app.Application;
import android.util.Log;

/**
 * Created by apple on 2/9/17.
 */

public class QuizApp extends Application {

    private static final String TAG = "MyActivity";


    @Override
    public void onCreate(){
        Log.d(TAG, "it's running!");
    }
}
