package th.ac.kku.plaekjangreed.anusorn.project;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import th.ac.kku.plaekjangreed.anusorn.project.ui.main.SectionsPagerAdapter;

//import th.ac.kku.laksana.myapp.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setSelectedTabIndicatorColor(Color.parseColor("#D81B60"));
        tabs.setBackgroundColor(Color.parseColor("#FFFFFF"));
        tabs.setSelectedTabIndicatorHeight((int) (3 * getResources().getDisplayMetrics().density));
        tabs.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#D81B60"));


//        Drawable d = getResources().getDrawable(R.color.white);
//        tabs.setBackgroundDrawable(d);
        tabs.setupWithViewPager(viewPager);

//        BottomNavigationView navigationView = findViewById(R.id.button_nev);
//
//        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                int id = menuItem.getItemId();
//                if(id == R.id.navigation_home){
//
//                    return true;
//                }else if(id == R.id.navigation_scan){
//                    openScanActivity();
//                    return true;
//                }else if(id == R.id.navigation_FAQ){
//                    openFAQActivity();
//                    return true;
//                }
//
//                return false;
//            }
//        });


    }

    public void goToHome(View v) {
        openMainActivity();
    }

    public void goToFAQ (View v) {
        openFAQActivity();
    }

    public void goToSearch(View v) {
        openScanActivity();
    }




    private void openMainActivity() {

    }

    private void openScanActivity() {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
        finish();

    }

    private void openFAQActivity() {
        Intent intent = new Intent(this, FAQActivity.class);
        startActivity(intent);
        finish();

    }





}