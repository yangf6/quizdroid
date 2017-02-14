package quizdroid.yangf6.washington.edu.quizdroid;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.List;



public class TopicActivity extends Activity {

    Button next;
    Button finish;
    Button submit;
    String topic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Intent launchingIntent = getIntent();
        Bundle b = launchingIntent.getExtras();
        topic = b.getString("topic");

        setContentView(R.layout.topic_layout);
        QuizApp quizApp = (QuizApp) getApplication();
        List<Topic> topicList = quizApp.getTopics();

        addContentviewFrag();

        submit = (Button) findViewById(R.id.submit_btn);
        next = (Button) findViewById(R.id.next_btn);
        finish = (Button) findViewById(R.id.finish_btn);
    }

    public void loadAnswerFrag(Bundle b) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        AnswerFrag answerFragment = new AnswerFrag();
        answerFragment.setArguments(b);
        ft.replace(R.id.container, answerFragment);
        ft.commit();
    }

    public void loadQuestionFragment(Bundle b) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        QuestionFrag questionFragment = new QuestionFrag();
        questionFragment.setArguments(b);
        ft.replace(R.id.container, questionFragment);
        ft.commit();
    }


    private void addMathFragment() {
        MathFrag mathFragment = new MathFrag();
        Bundle b = new Bundle();
        b.putString("topic", topic);
        mathFragment.setArguments(b);
        getFragmentManager()
                .beginTransaction()
                .add(R.id.container, mathFragment)
                .commit();
    }

    private void addPhysicsFragment() {
        PhyFrag physicsFragment = new PhyFrag();
        Bundle b = new Bundle();
        b.putString("topic", topic);
        physicsFragment.setArguments(b);
        getFragmentManager()
                .beginTransaction()
                .add(R.id.container, physicsFragment)
                .commit();
    }

    private void addMarvelFragment() {
        SupFrag marvelFragment = new SupFrag();
        Bundle b = new Bundle();
        b.putString("topic", topic);
        marvelFragment.setArguments(b);
        getFragmentManager()
                .beginTransaction()
                .add(R.id.container, marvelFragment)
                .commit();
    }

}