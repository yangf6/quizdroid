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

    Button beginMath;
    Button beginPhysics;
    Button beginMarvel;

    Button submit;

    String topic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Intent launchingIntent = getIntent();
        Bundle b = launchingIntent.getExtras();
        topic = b.getString("topic");

        // show the appropriate topic overview page depending on what was clicked in MainActivity
        if (topic.equals("Math")) {
           setContentView(R.layout.activity_topic_math);
        } else if (topic.equals("Physics")) {
           setContentView(R.layout.activity_topic_physics);
        } else {
            setContentView(R.layout.activity_topic_marvel);
        }


        beginMath = (Button) findViewById(R.id.math_begin);
        if (beginMath != null) {
            beginMath.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent startMath = new Intent(TopicActivity.this, QuestionActivity.class);
                    startMath.putExtra("topic", topic);
                    startActivity(startMath);
                    finish();
                }
            });
        }


        beginPhysics = (Button) findViewById(R.id.physics_begin);
        if (beginPhysics != null) {
            beginPhysics.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    i("TopicActivity", "begin physics button clicked");
                    Intent startPhysics = new Intent(TopicActivity.this, QuestionActivity.class);
                    startPhysics.putExtra("topic", topic);
                    startActivity(startPhysics);
                    finish();
                }
            });
        }

        beginMarvel = (Button) findViewById(R.id.marvel_begin);
        if (beginMarvel != null) {
            beginMarvel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    i("TopicActivity", "begin marvel button clicked");
                    Intent startMarvel = new Intent(TopicActivity.this, QuestionActivity.class);
                    startMarvel.putExtra("topic", topic);
                    startActivity(startMarvel);
                    finish();
                }
            });
        }

        submit = (Button) findViewById(R.id.submit);
       }

}