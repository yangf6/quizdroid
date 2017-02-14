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

        loadContentviewFrag();

        submit = (Button) findViewById(R.id.submit_btn);
        next = (Button) findViewById(R.id.next_btn);
        finish = (Button) findViewById(R.id.finish_btn);
    }

    private void  loadContentviewFrag(){
        ContentviewFrag contentviewFrag = new ContentviewFrag();
        Bundle info = new Bundle();
        info.putString("topic",topic);
        contentviewFrag.setArguments(info);
        getFragmentManager().beginTransaction().add(R.id.container, contentviewFrag).commit();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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