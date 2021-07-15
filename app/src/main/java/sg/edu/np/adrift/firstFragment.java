package sg.edu.np.adrift;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class firstFragment extends Fragment {

    TextView name;
    SharedPreferences sharedPreferences;
    public String GLOBAL_PREFS = "MyPrefs";
    public String MY_USERNAME = "MyName";
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public firstFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static firstFragment newInstance(String param1, String param2) {
        firstFragment fragment = new firstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_first, container, false);


//set layout for first fragment
        //click listener for breathing exercise option
        RelativeLayout r= (RelativeLayout) rootView.findViewById(R.id.layout1);
        r.setOnTouchListener(new View.OnTouchListener()
        {

            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                Intent intent = new Intent(r.getContext(), BreatheActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                return false;

            }

        });
        //click listener for music option
        RelativeLayout r2= (RelativeLayout) rootView.findViewById(R.id.layout3);
        r2.setOnTouchListener(new View.OnTouchListener()
        {

            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                Intent intent2 = new Intent(r2.getContext(), SelectMusicActivity.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent2);
                return false;

            }


        });
        name = (TextView) rootView.findViewById(R.id.userName);
        //String username = getActivity().getSharedPreferences(GLOBAL_PREFS,Context.MODE_PRIVATE);;
        //name.setText(user.getUsername());

        //get name in shared pref
        sharedPreferences = this.getActivity().getSharedPreferences(GLOBAL_PREFS, Context.MODE_PRIVATE);
        String nameUser = sharedPreferences.getString(MY_USERNAME, "");
        //text = findViewById(R.id.nameInput);

        name.setText(nameUser);//set name to display


        return rootView;









    }
}
