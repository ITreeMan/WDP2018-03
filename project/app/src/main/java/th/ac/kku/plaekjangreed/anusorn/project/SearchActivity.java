package th.ac.kku.plaekjangreed.anusorn.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity{
    public String TAG = "123";
    private List<List_Data> listData;
    private RecyclerView rv;
    private MyAdapter adapter;
    private EditText etSearch;
    private ArrayList<List_Data> arrayList;
    private ImageButton btSearch;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
//        BottomNavigationView navigationView = findViewById(R.id.button_nev);
        etSearch = (EditText) findViewById(R.id.search);
        btSearch = (ImageButton) findViewById(R.id.btOk);
        arrayList = new ArrayList<>();
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!s.toString().isEmpty()){
                    String value = etSearch.getText().toString();
                    search(value);
                }
                else {
                    search("");
                }
            }
        });


        rv=(RecyclerView)findViewById(R.id.recyclerview);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        listData=new ArrayList<>();

        final DatabaseReference nm = FirebaseDatabase.getInstance().getReference("data");
        nm.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    for (DataSnapshot npsnapshot : dataSnapshot.getChildren()){
                        List_Data l=npsnapshot.getValue(List_Data.class);
                        listData.add(l);
                    }
                    adapter=new MyAdapter(listData);
                    rv.setAdapter(adapter);

                }
            }



            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

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


    private void search(String s) {
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("data");
        Query query = myRef.orderByChild("name")
                .startAt(s)
                .endAt(s+"\uf8ff");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChildren()){
                    arrayList.clear();
                    for(DataSnapshot dss: dataSnapshot.getChildren()){
                        final List_Data list_data = dss.getValue(List_Data.class);

                        arrayList.add(list_data);
                    }


                    MyAdapter myAdapter = new MyAdapter(arrayList);
                    rv.setAdapter(myAdapter);
                    myAdapter.notifyDataSetChanged();




                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }



    private void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void openScanActivity() {

    }

    private void openFAQActivity() {
        Intent intent = new Intent(this, FAQActivity.class);
        startActivity(intent);
        finish();

    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}