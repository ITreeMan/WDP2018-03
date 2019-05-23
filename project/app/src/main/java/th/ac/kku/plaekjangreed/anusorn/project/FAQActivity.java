package th.ac.kku.plaekjangreed.anusorn.project;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.NoCopySpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class FAQActivity extends AppCompatActivity{

    int count_click = 0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
//        BottomNavigationView navigationView = findViewById(R.id.button_nev);

//        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                int id = menuItem.getItemId();
//                if(id == R.id.navigation_home){
//                    openMainActivity();
//                    return true;
//                }else if(id == R.id.navigation_scan){
//                    openScanActivity();
//                    return true;
//                }else if(id == R.id.navigation_FAQ){
//                    openFAQActivity();
//                    return true;
//                }
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

    public void goTologin(View v) {
        count_click +=1;
        Log.w("count : ",String.valueOf(count_click) );

        if (count_click == 7) {
            openLoginActivity();
            count_click=0;
        }

    }

    private void openLoginActivity() {
        Intent intent = new Intent(this, LogInActivity.class);
        startActivity(intent);
        finish();
    }

    private void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void openScanActivity() {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
        finish();
    }

    private void openFAQActivity() {

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
