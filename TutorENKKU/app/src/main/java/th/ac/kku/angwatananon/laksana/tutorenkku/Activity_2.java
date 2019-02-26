package th.ac.kku.angwatananon.laksana.tutorenkku;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Activity_2 extends AppCompatActivity {
    ListView serch_subject;
    ArrayAdapter<String> adapter;
    Button btscan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        serch_subject = (ListView) findViewById(R.id.search_subject);
        btscan = (Button) findViewById(R.id.btscan);
        btscan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent3 = new   Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                startActivity(Intent3);
            }
        });
        ArrayList<String> arraySubject = new ArrayList<>();
        arraySubject.addAll(Arrays.asList(getResources().getStringArray(R.array.my_subject)));

        adapter = new ArrayAdapter<String>(Activity_2.this,
                android.R.layout.simple_list_item_1,
                arraySubject
        );

        serch_subject.setAdapter(adapter);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.subject,menu);
        MenuItem  item = menu.findItem(R.id.search_subject);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
        return  super.onCreateOptionsMenu(menu);
    }
}
