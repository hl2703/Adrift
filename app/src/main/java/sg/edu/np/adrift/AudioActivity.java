package sg.edu.np.adrift;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class AudioActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    ImageButton imgB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.sleepaudio);
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
                /*Intent intent = new Intent(AudioActivity.this,secondFragment.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);*/
                finish();
                return false;
            }
        });
        // }
    }

    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
        mediaPlayer.release();

    }

}
