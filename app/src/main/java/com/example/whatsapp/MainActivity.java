package com.example.whatsapp;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.whatsapp.dashboardFragment.DashboardFragment;
import com.example.whatsapp.homeFragment.HomeFragment;
import com.example.whatsapp.navigationFragment.NavigationFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.nav_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

    }

    public BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment;
                    switch (item.getItemId()) {

                        case R.id.navigation_home:
                            fragment = new HomeFragment();
                            loadFragment(fragment);
                            return true;

                        case R.id.navigation_dashboard:
                            fragment = new DashboardFragment();
                            loadFragment(fragment);
                            return true;

                        case R.id.navigation_notifications:
                            fragment = new NavigationFragment();
                            loadFragment(fragment);
                            return true;
                    }

                    return false;
                }
            };

    public void loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
        }

    }


}