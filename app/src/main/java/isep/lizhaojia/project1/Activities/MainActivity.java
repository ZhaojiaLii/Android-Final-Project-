package isep.lizhaojia.project1.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

import isep.lizhaojia.project1.R;
import isep.lizhaojia.project1.fragments.fragment_aboutus;
import isep.lizhaojia.project1.fragments.fragment_account;
import isep.lizhaojia.project1.fragments.fragment_background;
import isep.lizhaojia.project1.fragments.fragment_bill;
import isep.lizhaojia.project1.fragments.fragment_expenditure;
import isep.lizhaojia.project1.fragments.fragment_main_currency;
import isep.lizhaojia.project1.fragments.fragment_profile;
import isep.lizhaojia.project1.fragments.fragment_upgrade;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private ArrayList<String> mNames = new ArrayList<>();
    private  ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declare
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        NavigationView navigationView = findViewById(R.id.nav_layout);


        //active bottom navigation listener
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new fragment_bill()).commit();


        //active sidebar listener
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.setDrawerListener(toggle);


       //set sidebar click listener
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open,R.string.close);
        drawerLayout.setDrawerListener(toggle);
        navigationView.setNavigationItemSelectedListener(this);




    }

    //sidebar controller
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }        return super.onOptionsItemSelected(item);
    }

    //bottom navigation listener execution
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;
            switch (menuItem.getItemId()){
                case R.id.navigation_bill:
                    selectedFragment = new fragment_bill();
                    break;
                case R.id.navigation_expenditure:
                    selectedFragment = new fragment_expenditure();
                    break;
                case R.id.navigation_account:
                    selectedFragment = new fragment_account();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
            return true;
        }
    };

    //sidebar click listener
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment selectedFragment = null;
        switch (menuItem.getItemId()){
            case R.id.my_currency:
                selectedFragment = new fragment_main_currency();
                break;
            case R.id.background:
                selectedFragment = new fragment_background();
                break;
            case R.id.upgrade:
                selectedFragment = new fragment_upgrade();
                break;
            case R.id.about:
                selectedFragment = new fragment_aboutus();
                break;
            case R.id.userinfo:
                selectedFragment = new fragment_profile();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
        return true;

    }

}
