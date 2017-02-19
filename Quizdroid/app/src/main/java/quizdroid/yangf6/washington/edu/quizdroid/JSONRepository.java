package quizdroid.yangf6.washington.edu.quizdroid;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2/15/17.
 */


class JSONRepository implements ITopicRepository {
    List<Topic> topics;

    public JSONRepository(String json) {
        topics = new ArrayList<Topic>();


        try {
            JSONArray topics= new JSONArray(json);

            for (int i = 0; i < topics.length(); i++) {
                JSONObject obj = topics.getJSONObject(i);
                String title = obj.getString("title");
                String desc = obj.getString("desc");

                List<Quiz> topicQuestions = new ArrayList<Quiz>();
                JSONArray questions = obj.getJSONArray("questions");

                for (int j = 0; j < questions.length(); j++) {
                    JSONObject jsonQuestion = questions.getJSONObject(j);
                    String question = jsonQuestion.getString("text");
                    int answer = jsonQuestion.getInt("answer");
                    JSONArray answers = (JSONArray) jsonQuestion.get("answers");

                    String question1 = answers.get(0).toString();
                    String question2 = answers.get(1).toString();
                    String question3 = answers.get(2).toString();
                    String question4 = answers.get(3).toString();

                    Quiz quiz = new Quiz(question, question1, question2, question3,
                            question4, answer);

                    topicQuestions.add(quiz);
                }

                this.topics.add(new Topic(title, desc, topicQuestions));
            }
        } catch (JSONException error) {
            error.printStackTrace();
        }
    }

    public List<Topic> getAllTopics() {
        return topics;
    }
}
