package quizdroid.yangf6.washington.edu.quizdroid;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import java.util.List;



public class TopicActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic_layout);

        Bundle bundle = new Bundle();
        bundle = getIntent().getExtras();

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ContentviewFrag contentviewFrag = new ContentviewFrag();
        contentviewFrag.setArguments(bundle);

        ft.add(R.id.container, contentviewFrag);
        ft.commit();
    }

    public void loadQuestionFrag(int questionNumber, int correctAnswers, Topic topic) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        Bundle topicBundle = new Bundle();
        topicBundle.putInt("questionNumber", questionNumber);
        topicBundle.putInt("correctAnswers", correctAnswers);
        topicBundle.putSerializable("topic", topic);

        QuestionFrag questionFrag = new QuestionFrag();
        questionFrag.setArguments(topicBundle);

        ft.replace(R.id.container, questionFrag);
        ft.commit();
    }

    public void loadAnswerFrag(String userAnswer, String correctAnswer, int correctAnswers,
                               Topic topic, int questionNumber) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        Bundle topicBundle = new Bundle();
        topicBundle.putString("userAnswer", userAnswer);
        topicBundle.putString("correctAnswer", correctAnswer);
        topicBundle.putInt("correctAnswers", correctAnswers);
        topicBundle.putInt("questionNumber", questionNumber);
        topicBundle.putSerializable("topic", topic);

        AnswerFrag answerFrag = new AnswerFrag();
        answerFrag.setArguments(topicBundle);

        ft.replace(R.id.container, answerFrag);
        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}