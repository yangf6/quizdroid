package quizdroid.yangf6.washington.edu.quizdroid;


import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;



public class TopicActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

        Bundle bundle = new Bundle();
        bundle = getIntent().getExtras();

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        OverviewFragment overviewFragment = new OverviewFragment();
        overviewFragment.setArguments(bundle);

        ft.add(R.id.container, overviewFragment);
        ft.commit();
    }

    public void loadQuestionFrag(int questionNumber, int correctAnswers, Topic topic) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        Bundle topicBundle = new Bundle();
        topicBundle.putInt("questionNumber", questionNumber);
        topicBundle.putInt("correctAnswers", correctAnswers);
        topicBundle.putSerializable("topic", topic);

        QuestionFragment questionFragment = new QuestionFragment();
        questionFragment.setArguments(topicBundle);

        ft.replace(R.id.container, questionFragment);
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

        AnswerFragment answerFragment = new AnswerFragment();
        answerFragment.setArguments(topicBundle);

        ft.replace(R.id.container, answerFragment);
        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_topic, menu);
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
