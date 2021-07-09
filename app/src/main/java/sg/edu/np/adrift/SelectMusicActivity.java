package sg.edu.np.adrift;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class SelectMusicActivity extends AppCompatActivity {

    ArrayList<selectObject> objectInfoList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_music);

        ImageView imageView =findViewById(R.id.backBtn);
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent intent = new Intent(SelectMusicActivity.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                return false;
            }
        });



        selectObject obj1= new selectObject(R.drawable.smile,"Forest");
        objectInfoList.add(obj1);//first relax feature

        selectObject obj2= new selectObject(R.drawable.smile,"Waves");
        objectInfoList.add(obj2);

        selectObject obj3= new selectObject(R.drawable.smile,"Birds");
        objectInfoList.add(obj3);
        //selectObject obj4= new selectObject(R.drawable.smile,"Waves");
        //objectInfoList.add(obj4);

        //selectObject obj5= new selectObject(R.drawable.smile,"Waves");
        //objectInfoList.add(obj5);
       /* myObject obj2= new myObject(R.drawable.pika,"Nature Simulation");
        objectInfoList.add(obj2);//second relax feature
*/


        for (int i=1; i<5;i++){

            selectObject obj = new selectObject(R.drawable.ic_baseline_lock_24,String.valueOf("Coming soon"));
            objectInfoList.add(obj);
        }

        RecyclerView recyclerViewCustom = findViewById(R.id.recyclerview2);
        SelectAdapter sAdapter = new SelectAdapter(objectInfoList);
        LinearLayoutManager cLayoutManager = new LinearLayoutManager(this);
        recyclerViewCustom.setLayoutManager(cLayoutManager);
        recyclerViewCustom.setItemAnimator(new DefaultItemAnimator());
        recyclerViewCustom.setAdapter(sAdapter);
    }

}



