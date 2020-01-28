package com.appsnipp.admin.Navigation_Profile;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.appsnipp.admin.BottomNavigationBehaviour;
import com.appsnipp.admin.Navigation_Profile.ui.dashboard.DashBoardFragment;
import com.appsnipp.admin.R;

public class Navigation_Activity extends AppCompatActivity {
    Fragment fragment;
    DashBoardFragment dash;

    FragmentManager manager;
    FragmentTransaction transaction;
    BottomNavigationView bottomNavigationView;
    NavigationView navigationView;
    private AppBarConfiguration mAppBarConfiguration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        manager=getSupportFragmentManager();
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
         navigationView =findViewById(R.id.nav_view);
        bottomNavigationView = findViewById(R.id.nav_view_bottom);


        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) bottomNavigationView.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehaviour());






        //bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        bottomNavigationView.setSelectedItemId(R.id.navB_home);
        navigationView=findViewById(R.id.nav_view);
        navigationView.setCheckedItem(R.id.nav_home);







        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_account, R.id.nav_member,
                R.id.nav_election, R.id.nav_document, R.id.nav_resource, R.id.nav_complain,R.id.navB_home,R.id.navB_notice,
                R.id.navB_building,R.id.navB_profile,
                R.id.nav_event,R.id.nav_visitor)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);
        NavigationUI.setupWithNavController(navigationView, navController);

        findViewById(R.id.floatingActionButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.openDrawer(GravityCompat.START);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
  if(R.id.navB_home!=bottomNavigationView.getSelectedItemId()) {
      bottomNavigationView.setSelectedItemId(R.id.navB_home);

  }
        if (getSupportFragmentManager().getBackStackEntryCount() > 0 ) {
            getSupportFragmentManager().popBackStackImmediate(0,FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
        else{
            super.onBackPressed();
        }
//        super.onBackPressed();
    }





}
