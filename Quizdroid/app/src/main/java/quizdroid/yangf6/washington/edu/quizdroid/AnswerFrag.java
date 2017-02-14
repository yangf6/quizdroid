package quizdroid.yangf6.washington.edu.quizdroid;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class AnswerFrag extends Fragment {
    private String userAnswer;
    private String correctAnswer;
    private int correctAnswerCount;
    private Topic topic;
    private int questionNumber;
    private Activity hostActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
//            userAnswer = getArguments().getString("userAnswer");
//            correctAnswer = getArguments().getString("correctAnswer");
            correctAnswerCount = getArguments().getInt("correctAnswers");
            topic = (Topic) getArguments().getSerializable("topic");
            questionNumber = getArguments().getInt("questionNumber");
        }
    }

    public AnswerFrag() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.answer_layout, container, false);

//        TextView userAnswerView = (TextView) rootView.findViewById(R.id.userAnswer);
//        TextView correctAnswerView = (TextView) rootView.findViewById(R.id.correctAnswer);
        TextView score = (TextView) rootView.findViewById(R.id.total_correct_text);
        Button next = (Button) rootView.findViewById(R.id.next_btn);

        // Sets correct page on the layout
//        userAnswerView.setText(userAnswer);
//        correctAnswerView.setText(correctAnswer);
        score.setText(correctAnswerCount + " answers correct out of " + (questionNumber + 1));
        final boolean finished = (questionNumber == topic.getQ().size() - 1);

        if (finished) {
            next.setText("Finish");
        }

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hostActivity instanceof TopicActivity) {
                    if (finished) {
                        Intent i = new Intent(getActivity(), MainActivity.class);
                        startActivity(i);
                    } else {
                        ((TopicActivity) hostActivity).loadQuestionFrag(questionNumber + 1,
                                correctAnswerCount, topic);
                    }
                }
            }
        });


        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        this.hostActivity = activity;
    }
}

