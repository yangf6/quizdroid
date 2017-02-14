package quizdroid.yangf6.washington.edu.quizdroid;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private ListView topicList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        QuizApp quizApp = (QuizApp) getApplication();
        final List<Topic> topics = quizApp.getTopics();

        String[] quizTopics = new String[topics.size()];
        for (int i = 0; i < topics.size(); i++) {
            quizTopics[i] = topics.get(i).getTitle();
        }

        topicList = (ListView) findViewById(R.id.listView);

        //ArrayAdapter<String> items = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, quizTopics);
        ArrayAdapter<String> items = new iconArrayAdapter(this, quizTopics);
        topicList.setAdapter(items);

        // Begins the quiz as soon as the user clicks on a topic
        topicList.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, TopicActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("topic", topics.get(position));
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}