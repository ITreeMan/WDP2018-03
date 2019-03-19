package th.ac.kku.plaekjangreed.anusorn.intentmyproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity  {
    private static final int REQUEST_CODE = 10;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void okButtonClicked(View view) {
        EditText EditTextAddress = (EditText) findViewById(R.id.editTextAddress);
        EditText EditTextSubject = (EditText) findViewById(R.id.editTextSubject);
        EditText EditTextMessage = (EditText) findViewById(R.id.editTextMessage);
        // To do 1. create new intent
        Intent intent = new Intent(MainActivity.this, ConfirmFAQ.class);
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

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
//            // Todo 1. get data from ResultActivity
//            TextView tv = findViewById(R.id.result);
//            // Todo 2. set the value of TextView with the received data
//            String text = data.getStringExtra("passText");
//            tv.setText(text);
//        }
//    }

}
