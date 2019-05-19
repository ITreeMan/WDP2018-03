package th.ac.kku.laksana.myapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class popUpActivity extends AppCompatActivity {
    private String[]

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

//
//        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.list_video,vidioDiff);
//        ListView listView = (ListView) findViewById(R.id.window_list);
//        listView.setAdapter(adapter);

    }
    public void goToHome(View v){
        popUpActivity.this.finish();
    }

}
