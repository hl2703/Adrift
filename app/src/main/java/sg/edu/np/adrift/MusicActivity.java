package sg.edu.np.adrift;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MusicActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    ImageButton imgB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent receivingEnd = getIntent();
        String name = receivingEnd.getStringExtra("Name");
        setContentView(R.layout.activity_music);
        TextView m =findViewById(R.id.textView3);
        m.setText(name);

        //if(m.getText()=="Forest") {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.forest);
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

            ImageView imageView = findViewById(R.id.backBtn);
            imageView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    Intent intent = new Intent(MusicActivity.this, SelectMusicActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
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