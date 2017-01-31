package quizdroid.yangf6.washington.edu.quizdroid;


import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhyFrag extends Fragment {


    Button beginPhysics;
    String topic;

    public PhyFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_topic_physics,
                container, false);

        if (getArguments() != null) {
            topic = getArguments().getString("topic");
        }

        beginPhysics = (Button) view.findViewById(R.id.physics_begin);
        beginPhysics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                QuestionFrag questionFragment = new QuestionFrag();
                Bundle info = new Bundle();
                info.putString("topic", topic);
                questionFragment.setArguments(info);
                ft.replace(R.id.container, questionFragment);
                ft.commit();
            }
        });

        return view;
    }

}
