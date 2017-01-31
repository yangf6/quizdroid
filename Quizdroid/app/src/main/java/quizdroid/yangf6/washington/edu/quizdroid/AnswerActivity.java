package quizdroid.yangf6.washington.edu.quizdroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class AnswerActivity extends Activity {

    private Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle b = this.getIntent().getExtras();
        setContentView(R.layout.answer_layout);

        submit = (Button) findViewById(R.id.submit);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startOver = new Intent(AnswerActivity.this, MainActivity.class);
                startActivity(startOver);
                finish();
            }
        });

    }

}
