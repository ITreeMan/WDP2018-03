package th.ac.kku.plaekjangreed.anusorn.project;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ExamActivity extends AppCompatActivity {
    private Dialog dialogDiff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        dialogDiff = (Dialog) new Dialog(this);
    }

    public void ShowPopupVideoDiff(View v){
        TextView txtclose;
        dialogDiff.setContentView(R.layout.activity_popup_diff);
        txtclose = (TextView) dialogDiff.findViewById(R.id.closePopup);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogDiff.dismiss();
            }
        });
        dialogDiff.show();
        dialogDiff.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

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


    private void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void openExamActivity() {
        Intent intent = new Intent(this, ExamActivity.class);
        startActivity(intent);
    }

    private void openFAQActivity() {
        Intent intent = new Intent(this, FAQActivity.class);
        startActivity(intent);
    }




}
