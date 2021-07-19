package sg.edu.np.adrift;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        countDownTimer();
        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {

            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, secondsDelayed * 7000);


    }

    private void countDownTimer(){
        CountDownTimer timer = new CountDownTimer(7000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(millisUntilFinished/1000==6) {
                    TextView text = findViewById(R.id.textView44);
                    Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
                    text.startAnimation(animFadeIn);
                    text.setText("Breathe in...");
                }
                if(millisUntilFinished/1000==4) {
                    TextView text = findViewById(R.id.textView45);
                    Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
                    text.startAnimation(animFadeIn);
                    text.setText("Let go...");
                }
                if(millisUntilFinished/1000==2) {
                    TextView text = findViewById(R.id.textView46);
                    Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
                    text.startAnimation(animFadeIn);
                    text.setText("Adrift...");
                }
            }

            @Override
            public void onFinish() {

            }
        };
        timer.start();
    }

}
