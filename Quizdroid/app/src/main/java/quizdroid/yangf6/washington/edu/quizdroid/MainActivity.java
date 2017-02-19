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
import java.util.List;


public class MainActivity extends Activity {
    private ListView topicList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        QuizApp app = (QuizApp) getApplication();
        final List<Topic> topics = app.getAllTopics();

        String[] quizTopics = new String[topics.size()];
        for (int i = 0; i < topics.size(); i++) {
            quizTopics[i] = topics.get(i).getTitle();
        }

        topicList = (ListView) findViewById(R.id.quizView);

        ArrayAdapter<String> items = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, quizTopics);
        topicList.setAdapter(items);

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