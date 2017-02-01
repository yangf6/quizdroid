package quizdroid.yangf6.washington.edu.quizdroid;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;



public class AnswerFrag extends Fragment {

    View view;
    String topic;
    private Activity hostActivity;
    TextView status;
    public static int total_questions = 0;
    public static boolean end = false;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.answer_layout,
                container, false);

        if (getArguments() != null) {
            total_questions = getArguments().getInt("totalQuestions");
            topic = getArguments().getString("topic");
            end = getArguments().getBoolean("end");
        }
        status = (TextView) view.findViewById(R.id.total_correct_text);
        status.setText("You have " + total_questions + " out of 3 correct");


        Button next = (Button) view.findViewById(R.id.next_btn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putInt("totalQuestions", total_questions);
                b.putString("topic", topic);
                if (hostActivity instanceof TopicActivity) {
                    ((TopicActivity) hostActivity).loadQuestionFragment(b);
                }
            }
        });

        Button finish = (Button) view.findViewById(R.id.finish_btn);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startOver = new Intent(getActivity(), MainActivity.class);
                startActivity(startOver);
            }
        });

        if (!end) {
            next.setVisibility(View.VISIBLE);
            finish.setVisibility(View.GONE);
        } else {
            next.setVisibility(View.GONE);
            finish.setVisibility(View.VISIBLE);
        }


        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.hostActivity = activity;
    }
}
