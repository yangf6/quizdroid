package quizdroid.yangf6.washington.edu.quizdroid;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

import static android.util.Log.i;


public class TopicActivity extends Activity {

    Button next;
    Button finish;


    Button submit;
    TextView yourAnswer;
    TextView correctAnswer;

    String topic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Intent launchingIntent = getIntent();
        Bundle b = launchingIntent.getExtras();
        topic = b.getString("topic");

        setContentView(R.layout.topic_layout);


        if (topic.equals("Math")) {
            addMathFragment();
        } else if (topic.equals("Physics")) {
            addPhysicsFragment();
        } else {
            addMarvelFragment();
        }

        submit = (Button) findViewById(R.id.submit_btn);
        yourAnswer = (TextView) findViewById(R.id.your_answer_text);
        correctAnswer = (TextView) findViewById(R.id.correct_answer_text);
        next = (Button) findViewById(R.id.next_btn);
        finish = (Button) findViewById(R.id.finish_btn);


    public void loadAnswerFrag(Bundle info) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        AnswerFragment answerFragment = new AnswerFragment();
        answerFragment.setArguments(info);
        ft.replace(R.id.container, answerFragment);
        ft.commit();
    }

    public void loadQuestionFragment(Bundle info) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        QuestionFragment questionFragment = new QuestionFragment();
        questionFragment.setArguments(info);
        ft.replace(R.id.container, questionFragment);
        ft.commit();
    }


    private void addMathFragment() {
        // creating instance of the HelloWorldFragment.
        MathFragment mathFragment = new MathFragment();
        Bundle info = new Bundle();
        info.putString("topic", topic);
        mathFragment.setArguments(info);
        // adding fragment to relative layout by using layout id
        getFragmentManager().beginTransaction().add(R.id.container, mathFragment).commit();
    }

    private void addPhysicsFragment() {
        // creating instance of the HelloWorldFragment.
        PhysicsFragment physicsFragment = new PhysicsFragment();
        Bundle info = new Bundle();
        info.putString("topic", topic);
        physicsFragment.setArguments(info);
        // adding fragment to relative layout by using layout id
        getFragmentManager().beginTransaction().add(R.id.container, physicsFragment).commit();
    }

    private void addMarvelFragment() {
        // creating instance of the HelloWorldFragment.
        MarvelFragment marvelFragment = new MarvelFragment();
        Bundle info = new Bundle();
        info.putString("topic", topic);
        marvelFragment.setArguments(info);
        // adding fragment to relative layout by using layout id
        getFragmentManager().beginTransaction().add(R.id.container, marvelFragment).commit();
    }

}