package sg.edu.np.adrift;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class NameActivity extends AppCompatActivity {
    public String GLOBAL_PREFS = "MyPrefs";
    public String MY_USERNAME = "MyName";

    ImageButton button;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        getSupportActionBar().hide();
        EditText name = findViewById(R.id.input);

        //when user click confirm button
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //store name input into shared pref
                sharedPreferences = getSharedPreferences(GLOBAL_PREFS, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(MY_USERNAME, name.getText().toString());
                editor.apply();
                Intent intent = new Intent(NameActivity.this, MainActivity.class);
                //go to main activity page
                startActivity(intent);
        }
    });


}
}