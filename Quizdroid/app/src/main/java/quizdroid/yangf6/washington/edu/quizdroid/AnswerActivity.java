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

public class AnswerActivity extends Activity {

    RadioGroup radioGroup;
    RadioButton option1;
    RadioButton option2;
    RadioButton option3;
    RadioButton option4;
    RadioButton radioButton;
    Button next;
    Button finish;
    Button submit;

    int pos;
    String topic;
    int total_questions;
    int total_correct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle b = this.getIntent().getExtras();
        pos = b.getInt("pos");
        int size = b.getInt("size");
        String theirAnswer = b.getString("answer");
        String correct = b.getString("correct");
        topic = b.getString("topic");
        boolean hasMoreQuestions = b.getBoolean("end");
        total_questions = b.getInt("total questions");
        total_correct = b.getInt("total correct");

        setContentView(R.layout.answer_layout);

        next = (Button) findViewById(R.id.next_btn);
        finish = (Button) findViewById(R.id.finish_btn);

        option1 = (RadioButton) findViewById(R.id.radioButton1);
        option2 = (RadioButton) findViewById(R.id.radioButton2);
        option3 = (RadioButton) findViewById(R.id.radioButton3);
        option4 = (RadioButton) findViewById(R.id.radioButton4);


       TextView total = (TextView) findViewById(R.id.total_correct_text);
        total.setText("You have 5   out of " + total_questions + " correct");
        if (hasMoreQuestions) {
            next.setVisibility(View.VISIBLE);
            finish.setVisibility(View.GONE);
        } else {
            next.setVisibility(View.GONE);
            finish.setVisibility(View.VISIBLE);
        }

//        next = (Button) findViewById(R.id.next_btn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent showAnswer = new Intent(AnswerActivity.this, QuestionActivity.class);
                showAnswer.putExtra("pos", pos + 1);
                showAnswer.putExtra("size", 3);

                showAnswer.putExtra("topic", topic);
                showAnswer.putExtra("total questions", total_questions);
                startActivity(showAnswer);
                finish();
            }
        });

        finish = (Button) findViewById(R.id.finish_btn);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startOver = new Intent(AnswerActivity.this, MainActivity.class);
                startOver.putExtra("pos", 0);
                startActivity(startOver);
                finish();
            }
        });

    }

}
