package sg.edu.np.adrift;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.ramotion.paperonboarding.PaperOnboardingFragment;
import com.ramotion.paperonboarding.PaperOnboardingPage;

import java.util.ArrayList;

public class TipsActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
        getSupportActionBar().hide();
        //back btn
        Button button = findViewById(R.id.close);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });

        fragmentManager = getSupportFragmentManager();

        final PaperOnboardingFragment paperOnboardingFragment = PaperOnboardingFragment.newInstance(getDataForOnBoarding());
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, paperOnboardingFragment);
        fragmentTransaction.commit();

    }

    private ArrayList<PaperOnboardingPage> getDataForOnBoarding() {
        PaperOnboardingPage s0= new PaperOnboardingPage("How To Improve Sleep ",  "",

                Color.parseColor("#FFFFFFFF"), R.drawable.sleep, R.drawable.ic_baseline_cloud_24);
        PaperOnboardingPage s1= new PaperOnboardingPage("Create a Conducive Environment",  "",

                Color.parseColor("#FFFFFFFF"), R.drawable.bed, R.drawable.ic_baseline_cloud_24);
        PaperOnboardingPage s2= new PaperOnboardingPage(" Write down your Worries",  "",

                Color.parseColor("#FFFFFFFF"), R.drawable.note, R.drawable.ic_baseline_cloud_24);
        PaperOnboardingPage s3= new PaperOnboardingPage("Do Deep Breathing Exercises",  "",

                Color.parseColor("#FFFFFFFF"), R.drawable.yoga, R.drawable.ic_baseline_cloud_24);
        PaperOnboardingPage s4= new PaperOnboardingPage("Reflect before Sleep",  "",

                Color.parseColor("#FFFFFFFF"), R.drawable.reflect, R.drawable.ic_baseline_cloud_24);

        PaperOnboardingPage s5= new PaperOnboardingPage("Listen to Relaxing Sounds and Music",  "",

                Color.parseColor("#FFFFFFFF"), R.drawable.music, R.drawable.ic_baseline_cloud_24);

        PaperOnboardingPage s6= new PaperOnboardingPage("Stick to a Sleep Schedule",  "",

                Color.parseColor("#FFFFFFFF"), R.drawable.time, R.drawable.ic_baseline_cloud_24);
        PaperOnboardingPage s7= new PaperOnboardingPage("Practice Gratitude",  "",

                Color.parseColor("#FFFFFFFF"), R.drawable.writing, R.drawable.ic_baseline_cloud_24);
        PaperOnboardingPage s8= new PaperOnboardingPage("Feeling tired? It's Time to Sleep!",  "",

                Color.parseColor("#FFFFFFFF"), R.drawable.sleep, R.drawable.ic_baseline_cloud_24);

        ArrayList<PaperOnboardingPage> elements=new ArrayList<>();
        elements.add(s0);
        elements.add(s1);
        elements.add(s3);
        elements.add(s4);
        elements.add(s2);
        elements.add(s7);
        elements.add(s5);
        elements.add(s6);
        elements.add(s8);
        return elements;
    }


}