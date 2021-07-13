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
        Button b = findViewById(R.id.close);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TipsActivity.this, MainActivity.class);


                startActivity(intent);

            }
        });
        // }

        fragmentManager = getSupportFragmentManager();

        final PaperOnboardingFragment paperOnboardingFragment = PaperOnboardingFragment.newInstance(getDataForOnBoarding());
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, paperOnboardingFragment);
        fragmentTransaction.commit();

    }

    private ArrayList<PaperOnboardingPage> getDataForOnBoarding() {
        PaperOnboardingPage s0= new PaperOnboardingPage("How To Sleep Better ",  "",

                Color.parseColor("#FFFFFFFF"), R.drawable.sleep, R.drawable.ic_baseline_snooze_24);
        PaperOnboardingPage s1= new PaperOnboardingPage("Create a restful environment",  "",

                Color.parseColor("#FFFFFFFF"), R.drawable.bed, R.drawable.ic_baseline_snooze_24);
        PaperOnboardingPage s2= new PaperOnboardingPage(" Write down your worries",  "",

                Color.parseColor("#FFFFFFFF"), R.drawable.note, R.drawable.ic_baseline_snooze_24);
        PaperOnboardingPage s3= new PaperOnboardingPage("Do deep breathing exercises",  "",

                Color.parseColor("#FFFFFFFF"), R.drawable.yoga, R.drawable.ic_baseline_snooze_24);
        PaperOnboardingPage s4= new PaperOnboardingPage("Reflect before sleep",  "",

                Color.parseColor("#FFFFFFFF"), R.drawable.write, R.drawable.ic_baseline_snooze_24);
        PaperOnboardingPage s5= new PaperOnboardingPage(" Listen to relaxing sounds and music",  "",

                Color.parseColor("#FFFFFFFF"), R.drawable.music, R.drawable.ic_baseline_snooze_24);
        ArrayList<PaperOnboardingPage> elements=new ArrayList<>();
        elements.add(s0);
        elements.add(s1);
        elements.add(s2);
        elements.add(s3);
        elements.add(s4);
        elements.add(s5);
        return elements;
    }


}