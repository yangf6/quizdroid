package quizdroid.yangf6.washington.edu.quizdroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class QuestionActivity extends Activity {

    RadioButton option1;
    RadioButton option2;
    RadioButton option3;
    RadioButton option4;
    RadioButton radioButton;
    Button submit;
    int pos = 0;
    String selection;
    String topic;
    int total_questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent launchingIntent = getIntent();
        topic = launchingIntent.getStringExtra("topic");
        Bundle b = launchingIntent.getExtras();
        pos = b.getInt("pos");


        setContentView(R.layout.question_layout);


        submit = (Button) findViewById(R.id.submit_btn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total_questions++;
                Intent showAnswer = new Intent(QuestionActivity.this, AnswerActivity.class);
                RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
                showAnswer.putExtra("total questions", total_questions);
                boolean hasMoreQuestions = true;
                if (pos + 1 >= 3) {
                    hasMoreQuestions = false;
                }
                showAnswer.putExtra("end", hasMoreQuestions);
                startActivity(showAnswer);
                finish();
            }
        });
    }

}
