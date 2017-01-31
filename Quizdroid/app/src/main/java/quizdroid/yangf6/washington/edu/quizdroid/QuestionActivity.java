package quizdroid.yangf6.washington.edu.quizdroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;


public class QuestionActivity extends Activity {


    Button submit;
    String topic;
    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent launchingIntent = getIntent();
        topic = launchingIntent.getStringExtra("topic");
        Bundle b = launchingIntent.getExtras();


        setContentView(R.layout.question_layout);


        submit = (Button) findViewById(R.id.submit_btn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
                radioButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                if(radioButton != null) {
                    Intent showAnswer = new Intent(QuestionActivity.this, AnswerActivity.class);
                    RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
                    startActivity(showAnswer);
                    finish();
                }
            }
        });
    }

}
