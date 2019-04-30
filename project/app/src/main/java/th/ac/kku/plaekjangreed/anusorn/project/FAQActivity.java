package th.ac.kku.plaekjangreed.anusorn.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FAQActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
    }


    public void okButtonClicked(View view) {
        EditText EditTextAddress = (EditText) findViewById(R.id.editTextAddress);
        EditText EditTextSubject = (EditText) findViewById(R.id.editTextSubject);
        EditText EditTextMessage = (EditText) findViewById(R.id.editTextMessage);
        // To do 1. create new intent
        Intent intent = new Intent(FAQActivity.this, ConfirmFAQ.class);
        // To do 2. put extra value with the intent
        String address = String.valueOf(EditTextAddress.getText());
        String subject = String.valueOf(EditTextSubject.getText());
        String message = String.valueOf(EditTextMessage.getText());
        intent.putExtra("address", address);
        intent.putExtra("subject", subject);
        intent.putExtra("message", message);
        // To do 3. use startActivityForResult with REQUEST_CODE
        startActivityForResult(intent, REQUEST_CODE);
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

    public void goTosearch(View v){ openSearchActivity();}


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
