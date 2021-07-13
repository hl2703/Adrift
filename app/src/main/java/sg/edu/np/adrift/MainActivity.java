package sg.edu.np.adrift;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    public String GLOBAL_PREFS = "MyPrefs";
    public String MY_USERNAME = "MyName";

    TextView text;

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        if (isFirstRun) {
            //show start activity

            startActivity(new Intent(MainActivity.this, NameActivity.class));
            Toast.makeText(MainActivity.this, "First Run", Toast.LENGTH_LONG)
                    .show();
        }


        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", false).commit();




            ActionBar actionBar = getSupportActionBar();
            actionBar.hide();//hide action bar
            //implement bottom nav bar
            BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
            NavHostFragment navHostFragment =
                    (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
            NavController navController = navHostFragment.getNavController();

            AppBarConfiguration appBarConfiguration =
                    new AppBarConfiguration.Builder(R.id.firstFragment, R.id.secondFragment, R.id.thirdFragment).build();

            NavigationUI.setupWithNavController(bottomNavigationView, navController);
            //get name in shared pref
            sharedPreferences = getSharedPreferences(GLOBAL_PREFS, MODE_PRIVATE);
            String name = sharedPreferences.getString(MY_USERNAME, "");
            text = findViewById(R.id.nameInput);
            text.setText(name);//display name
        }

}

