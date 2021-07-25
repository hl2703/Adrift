package sg.edu.np.adrift;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.concurrent.atomic.AtomicInteger;

public class BreatheActivity extends AppCompatActivity {

    private LottieAnimationView animationView;

    MediaPlayer mediaPlayer;
    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathe);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.breathe);
        mediaPlayer.setLooping(true);
        animationView = findViewById(R.id.animationView);
        countDownTimer();//start countdown

    }

    private void countDownTimer() {

        CountDownTimer timer = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textView = findViewById(R.id.countdownText);
                textView.setText(" " + (millisUntilFinished + 1000) / 1000);//display countdown text
            }

            @Override
            public void onFinish() {

                textView.setVisibility(View.GONE);
                // start the animation
                animationView.playAnimation();
                mediaPlayer.start();
            }
        };
        timer.start();
        imageView = findViewById(R.id.backBtn);
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();//stop audio
                    mediaPlayer.release();
                }
                timer.cancel();//stop timer if user press back before countdown finish
                mediaPlayer.release();
                finish();
                return false;
            }
        });

    }
}



