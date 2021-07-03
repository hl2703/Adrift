package sg.edu.np.adrift;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//implement bottom nav bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();//hide action bar
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        NavController navController = navHostFragment.getNavController();

        AppBarConfiguration appBarConfiguration =
                new AppBarConfiguration.Builder(R.id.firstFragment, R.id.secondFragment,R.id.thirdFragment).build();

        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }
}