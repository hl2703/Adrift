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

    //Boolean isPlaying=false;
    MediaPlayer mediaPlayer;
    TextView textView;
    ImageView imageView;
//Boolean playerExist=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathe);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.breathe);
        mediaPlayer.setLooping(true);
        //play music
        //mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.breathe);

        animationView = findViewById(R.id.animationView);
        //start countdown
        /*final Handler handler = new Handler();
        final TextView textView = (TextView) findViewById(R.id.textView);
        final java.util.concurrent.atomic.AtomicInteger n = new AtomicInteger(3);
        final Runnable counter = new Runnable() {
            @Override
            public void run() {
                textView.setText(Integer.toString(n.get()));
                if (n.getAndDecrement() >= 1)
                    handler.postDelayed(this, 1000);
                else {

                        textView.setVisibility(View.GONE);
                        // start the game
                    animationView.playAnimation();
                    mediaPlayer.setLooping(true);
                    mediaPlayer.start();
                       // playerExist=true;

                    }
                }

        };
        handler.postDelayed(counter, 1000);
        //animationView = findViewById(R.id.animationView);*/

        //back button
        /*imageView = findViewById(R.id.backBtn);
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
               *//* mediaPlayer.stop();
                mediaPlayer.release();*//*
                //isPlaying=false;
               *//* if(mediaPlayer.isPlaying()==true) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }*//*
             *//*   Intent intent = new Intent(BreatheActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);*//*
                //if(playerExist==true){
                    //mediaPlayer.stop();
                   // mediaPlayer.release();

               // }
               // playerExist=false;
                if(mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    //  }

                }

                mediaPlayer.release();
               finish();
                return false;
            }
        });*/
        countDownTimer();

    }
    private void countDownTimer(){

        CountDownTimer timer = new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textView=findViewById(R.id.countdownText);
                textView.setText(" "+(millisUntilFinished+1000)/1000);


            }

            @Override
            public void onFinish() {

                textView.setVisibility(View.GONE);
                // start the game
                animationView.playAnimation();

                mediaPlayer.start();
            }
        };
        timer.start();
        imageView = findViewById(R.id.backBtn);
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    //  }

                }
                timer.cancel();
                mediaPlayer.release();
                finish();
                return false;
            }
        });

    }
    //@Override
   /* protected void onPause() {
        //stop music player
        super.onPause();

//
        //if(playerExist==true) {
if(mediaPlayer.isPlaying()) {
    mediaPlayer.stop();
    mediaPlayer.release();
    //  }

}
    }*/
}



