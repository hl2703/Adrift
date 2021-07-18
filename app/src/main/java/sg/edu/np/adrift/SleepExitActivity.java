package sg.edu.np.adrift;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;

public class SleepExitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_exit);
        ImageView i = findViewById(R.id.lamp);
        ConstraintLayout c =findViewById(R.id.sleeplayout);
        i.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                c.setBackgroundColor(getResources().getColor(R.color.black));
                i.setImageResource(R.drawable.lamp2);
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
            }
        };
        timer.start();
    }

}