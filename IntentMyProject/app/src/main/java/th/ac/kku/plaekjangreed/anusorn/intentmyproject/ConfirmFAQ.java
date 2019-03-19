package th.ac.kku.plaekjangreed.anusorn.intentmyproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;

public class ConfirmFAQ extends AppCompatActivity {

    TextView mailTextIntent;
    TextView subjectTextIntent;
    TextView MessageTextIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_faq);

        mailTextIntent = (TextView) findViewById(R.id.mail_text_intent);
        subjectTextIntent = (TextView)findViewById(R.id.subject_Text_intent);
        MessageTextIntent = (TextView)findViewById(R.id.message_Text_intent);

        Button buttonIntent = (Button)findViewById(R.id.okButtonIntent);
        buttonIntent.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/email");
                intent.putExtra(Intent.EXTRA_EMAIL
                        , new String[] {mailTextIntent.getText().toString()});
                intent.putExtra(Intent.EXTRA_SUBJECT
                        , subjectTextIntent.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT
                        , MessageTextIntent.getText().toString());
                startActivity(Intent.createChooser(intent, "Send email with"));
            }
        });
        setIntentData();
    }

    public void setIntentData() {
        Bundle extras = getIntent().getExtras();
        String inputAddress = extras.getString("address");
        String inputSubject = extras.getString("subject");
        String inputMessage = extras.getString("message");
        TextView viewMail = (TextView) findViewById(R.id.mail_text_intent);
        TextView viewSubject = (TextView) findViewById(R.id.subject_Text_intent);
        TextView viewMessage = (TextView) findViewById(R.id.message_Text_intent);
        viewMail.setText(inputAddress);
        viewSubject.setText(inputSubject);
        viewMessage.setText(inputMessage);
    }



}
