package sg.edu.np.adrift;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link firstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class firstFragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public firstFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment firstFragment.
     */
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

        //click listener for breath option
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

        return rootView;



    }
}
