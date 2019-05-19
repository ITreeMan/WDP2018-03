package th.ac.kku.plaekjangreed.anusorn.project;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private Dialog dialogDiff;
    private TextView exam;
    private View diff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        diff = (View) findViewById(R.id.diff);
        diff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                startActivity(new Intent(MainActivity.this,popup_diff.class));
            }
        });


    }


//    public void ShowPopupVideoDiff(View v) {
//        TextView txtclose;
//        dialogDiff.setContentView(R.layout.activity_popup_diff);
//        txtclose = (TextView) dialogDiff.findViewById(R.id.closePopup);
//        txtclose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialogDiff.dismiss();
//            }
//        });
//        dialogDiff.show();
//        dialogDiff.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//    }

    public void goToTutorial(View v) {
        openMainActivity();
    }

    public void goToExam(View v) {
        openExamActivity();
    }

    public void goToHome(View v) {
        openMainActivity();
    }

    public void goToFAQ (View v) {
        openFAQActivity();
    }
    public void goTosearch(View v){
        openSearchActivity();
    }

    private void openSearchActivity() {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
        finish();

    }


    private void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void openExamActivity() {
        Intent intent = new Intent(this, ExamActivity.class);
        startActivity(intent);
        finish();
    }

    private void openFAQActivity() {
        Intent intent = new Intent(this, FAQActivity.class);
        startActivity(intent);
        finish();
    }



}
