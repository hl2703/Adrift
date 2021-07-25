package sg.edu.np.adrift;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SleepExitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_exit);
        ImageView image = findViewById(R.id.lamp);
        ConstraintLayout constraintLayout =findViewById(R.id.sleeplayout);
        image.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                constraintLayout.setBackgroundColor(getResources().getColor(R.color.black));//set background to black
                image.setImageResource(R.drawable.lamp2);
                TextView text = findViewById(R.id.goodnight);
                Animation animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);//fade out text
                text.startAnimation(animFadeOut);
                countDownTimer();//start timer to show dialogue after 2 seconds

            }
        });


        }


    public void onLightPressed() {
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.ic_baseline_bedtime_24)
                .setTitle("Go To Sleep")
                .setMessage("Would you like to exit the app?")
                .setCancelable(false)
                .setNegativeButton("No", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();//go back to previous activity
                    }

                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finishAffinity();
                        System.exit(0);//exit the app
                    }

                })
                .show();
    }

    private void countDownTimer(){
        CountDownTimer timer = new CountDownTimer(2000,1000) {
            @Override

            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                onLightPressed();
                TextView text = findViewById(R.id.goodnight);
                text.setText("");
            }
        };
        timer.start();
    }

}