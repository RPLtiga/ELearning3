package com.example.lenovo.rpl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

public class Navigation extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        Bundle extras = getIntent().getExtras();

//        Bundle bundle = new Bundle();
//        String myMessage = "Stackoverflow is cool!";
//        bundle.putString("dbnama", myMessage );

        //VARIABLE
//        Bundle bundle = new Bundle();

//        if (extras != null) {
//            String dbnim = extras.getString("dbnim");
//            String dbnama = extras.getString("dbnim");
//
//            bundle.putString("dbnim", dbnim );
//            bundle.putString("dbnama", dbnim );
//            bundle.putString("dbtlogin", dbnim );
//            bundle.putString("dbprodi", dbnim );
//            bundle.putString("dbdpa", dbnim );
//        }


        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            Dummy dummy = new Dummy();
            dummy.setArguments(extras);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    dummy).commit();

        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    Bundle extras = getIntent().getExtras();

                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new Dummy();
                            break;
                        case R.id.nav_makul:
                            selectedFragment = new daftar_makul();
                            break;
                        case R.id.nav_search:
                            selectedFragment = new Dummy();
                            break;
                        case R.id.nav_profile:
                            selectedFragment = new ProfileActivity();
                            break;
                    }

                    assert selectedFragment != null;
                    selectedFragment.setArguments(extras);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
    };
}
