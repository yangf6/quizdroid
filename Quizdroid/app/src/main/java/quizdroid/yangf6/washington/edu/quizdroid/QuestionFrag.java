package quizdroid.yangf6.washington.edu.quizdroid;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

public class QuestionFrag extends Fragment {
    private Topic topic;
    private int questionNumber;
    private int correctAnswers;
    private Activity hostActivity;

    public QuestionFrag() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            topic = (Topic) getArguments().getSerializable("topic");
            questionNumber = getArguments().getInt("questionNumber");
            correctAnswers = getArguments().getInt("correctAnswers");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.question_layout, container, false);

        TextView question = (TextView) rootView.findViewById(R.id.question_title_text_view);
        TextView answer1 = (TextView) rootView.findViewById(R.id.radioButton1);
        TextView answer2 = (TextView) rootView.findViewById(R.id.radioButton2);
        TextView answer3 = (TextView) rootView.findViewById(R.id.radioButton3);
        TextView answer4 = (TextView) rootView.findViewById(R.id.radioButton4);
        final Button submit = (Button) rootView.findViewById(R.id.submit_btn);
        final RadioGroup radioGroup = (RadioGroup) rootView.findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                submit.setVisibility(View.VISIBLE);
            }
        });

        final Question curQuestion = topic.getQ().get(questionNumber);
        question.setText(curQuestion.getQuestion());
        answer1.setText(curQuestion.getAnswer1());
        answer2.setText(curQuestion.getAnswer2());
        answer3.setText(curQuestion.getAnswer3());
        answer4.setText(curQuestion.getAnswer4());

        String answer = "";
        switch(curQuestion.getCorrect()) {
            case 1: answer = curQuestion.getAnswer1();
                break;
            case 2: answer = curQuestion.getAnswer2();
                break;
            case 3: answer = curQuestion.getAnswer3();
                break;
            case 4: answer = curQuestion.getAnswer4();
                break;
        }

        final String correctAnswer = answer;

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton selected = (RadioButton) rootView.findViewById(selectedId);
                boolean correct = selected.getText().equals(correctAnswer);
                final int correctAddition = correct ? 1 : 0;

                if (hostActivity instanceof TopicActivity) {
                    ((TopicActivity) hostActivity).loadAnswerFrag(selected.getText().toString(),
                            correctAnswer, correctAnswers + correctAddition, topic, questionNumber);
                }
            }
        });

        return rootView;
    }
//
//    @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//
//        this.hostActivity = activity;
//    }
}
