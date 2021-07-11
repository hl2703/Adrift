package sg.edu.np.adrift;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.concurrent.atomic.AtomicInteger;

public class BreatheActivity extends AppCompatActivity {

    private LottieAnimationView animationView;
    TextView textView ;

    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathe);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //play music
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.breathe);
        mediaPlayer.setLooping(true);
        animationView=findViewById(R.id.animationView);
//start countdown
        final Handler handler = new Handler();
        final TextView textView = (TextView) findViewById(R.id.textView);
        final java.util.concurrent.atomic.AtomicInteger n = new AtomicInteger(3);
        final Runnable counter = new Runnable() {
            @Override
            public void run() {
                textView.setText(Integer.toString(n.get()));
                if(n.getAndDecrement() >= 1 )
                    handler.postDelayed(this, 1000);
                else {
                    textView.setVisibility(View.GONE);
                    // start the game
                    mediaPlayer.start();
                    animationView.playAnimation();
                }
            }
        };
        handler.postDelayed(counter, 1000);
        //animationView = findViewById(R.id.animationView);

//back button
        ImageView imageView =findViewById(R.id.backBtn);
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent intent = new Intent(BreatheActivity.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                return false;
            }
        });


    }

    @Override
    protected void onPause() {
        //stop music player
        super.onPause();
        mediaPlayer.stop();
        mediaPlayer.release();

    }

}

