package sg.edu.np.adrift;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.Lottie;
import com.airbnb.lottie.LottieAnimationView;

public class MusicActivity2 extends AppCompatActivity {

        MediaPlayer mediaPlayer;
        ImageButton imgB;
        LottieAnimationView lottie;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            getSupportActionBar().hide();
            super.onCreate(savedInstanceState);

            Intent receivingEnd = getIntent();
            String name = receivingEnd.getStringExtra("Name");
            setContentView(R.layout.activity_music);
            TextView m =findViewById(R.id.textView3);
            m.setText(name);
            //set animation
            lottie=findViewById(R.id.animationView);
            lottie.setAnimation(R.raw.wave);
            lottie.playAnimation();
            //play music
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.waves);
            mediaPlayer.setLooping(true);

            mediaPlayer.start();

            //pause play func
            //Button pButton=findViewById(R.id.pButton);
            imgB = findViewById(R.id.imageButton);
            imgB.setOnClickListener(new View.OnClickListener() {

                public void onClick(View view) {

                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.pause();


                        imgB.setImageResource(R.drawable.play);

                    } else {
                        mediaPlayer.start();

                        imgB.setImageResource(R.drawable.pause);
                    }
                }
            });
            //back btn
            ImageView imageView = findViewById(R.id.backBtn);
            imageView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    Intent intent = new Intent(MusicActivity2.this, SelectMusicActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                    return false;
                }
            });
            // }
        }

        protected void onPause() {
            super.onPause();
            mediaPlayer.stop();//stop audio
            mediaPlayer.release();

        }

    }

