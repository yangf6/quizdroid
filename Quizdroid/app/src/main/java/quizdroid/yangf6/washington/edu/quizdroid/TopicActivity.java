package quizdroid.yangf6.washington.edu.quizdroid;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        next = (Button) findViewById(R.id.next_btn);
        finish = (Button) findViewById(R.id.finish_btn);
    }

    public void loadAnswerFrag(Bundle info) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        AnswerFrag answerFragment = new AnswerFrag();
        answerFragment.setArguments(info);
        ft.replace(R.id.container, answerFragment);
        ft.commit();
    }

    public void loadQuestionFragment(Bundle info) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        QuestionFrag questionFragment = new QuestionFrag();
        questionFragment.setArguments(info);
        ft.replace(R.id.container, questionFragment);
        ft.commit();
    }


    private void addMathFragment() {
        MathFrag mathFragment = new MathFrag();
        Bundle info = new Bundle();
        info.putString("topic", topic);
        mathFragment.setArguments(info);
        getFragmentManager().beginTransaction().add(R.id.container, mathFragment).commit();
    }

    private void addPhysicsFragment() {
        PhyFrag physicsFragment = new PhyFrag();
        Bundle info = new Bundle();
        info.putString("topic", topic);
        physicsFragment.setArguments(info);
        getFragmentManager().beginTransaction().add(R.id.container, physicsFragment).commit();
    }

    private void addMarvelFragment() {
        SupFrag marvelFragment = new SupFrag();
        Bundle info = new Bundle();
        info.putString("topic", topic);
        marvelFragment.setArguments(info);
        getFragmentManager().beginTransaction().add(R.id.container, marvelFragment).commit();
    }

}