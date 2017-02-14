package quizdroid.yangf6.washington.edu.quizdroid;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;



public class QuestionFrag extends Fragment {


    View view;
    String topic;
    private Activity hostActivity;
    public static int total_questions = 0;
    public static boolean end = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.question_layout,
                container, false);

        if (getArguments() != null) {
            total_questions = getArguments().getInt("totalQuestions");
            topic = getArguments().getString("topic");
        } else {
            total_questions = 0;
            topic = "";
        }
        Button submit = (Button) view.findViewById(R.id.submit_btn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.radioGroup);
                RadioButton radioButton = (RadioButton) view.findViewById(radioGroup.getCheckedRadioButtonId());
                end = false;
                if (radioButton != null) {
                    total_questions++;
                    if (total_questions == 3) {
                        end = true;
                    }
                    Bundle info = new Bundle();
                    info.putBoolean("end", end);
                    info.putInt("totalQuestions", total_questions);
                    info.putString("topic", topic);
                    if (hostActivity instanceof TopicActivity) {
                        ((TopicActivity) hostActivity).loadAnswerFrag(info);
                    }
                }
            }
        });
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.hostActivity = activity;
    }

}
