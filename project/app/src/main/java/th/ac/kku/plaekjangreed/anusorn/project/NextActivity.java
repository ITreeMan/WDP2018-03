package th.ac.kku.plaekjangreed.anusorn.project;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class NextActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    String TAG = "Anusorn1234" ;
    TextView textView ;
    private Button logOut , download ;
    private FirebaseDatabase database ;
    private   DatabaseReference myRef;
    private Uri downloadUrl ;
    private String dwnldUri ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        imageView = (ImageView) findViewById(R.id.iv_show);
        //imageView.setImageDrawable(getResources().getDrawable(R.drawable.nongpee));
//        download = (Button)findViewById(R.id.download);
        if (user != null) {
            // Name, email address, and profile photo Url
            String email = user.getEmail();



            logOut = (Button)findViewById(R.id.logOutBtn);
            // Check if user's email is verified
            boolean emailVerified = user.isEmailVerified();

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getToken() instead.
            String uid = user.getUid();

            ((Button)findViewById(R.id.logOutBtn)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FirebaseAuth.getInstance().signOut();
                    onBackPressed();
                    Intent toMain1 = new Intent(NextActivity.this, LogInActivity.class);
                    startActivity(toMain1);

                }
            });
        }

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");

        // readDB();
        //  writeDB();

        writeNewUser("Plaekjangreed","Anusorn","p_anusorn@kkumail.com");
        readNewUser();

        mStorageRef = FirebaseStorage.getInstance().getReference();
        Button buttonLoadImage = (Button) findViewById(R.id.buttonLoadPicture);
        Button buttonUploadImg = (Button)findViewById(R.id.buttonLoadPicture);
        buttonLoadImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });

//        download.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Picasso.with(NextActivity.this).load(downloadUrl.toString()).into(imageView);
//                tv_path_load.setText("download " + downloadUrl.getLastPathSegment());
//            }
//        });
    }
    private void writeDB(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");
    }

    private void readDB(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
                Toast.makeText(NextActivity.this,"" +
                        "Value is " + value, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }


    private void writeNewUser(String useId,String name,String email){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        String key = myRef.child("users").push().getKey();
        User user = new User(name,email);
        Map<String, Object> userValues = user.toMap();

        Map<String,Object> childUpdates = new HashMap<>();
        childUpdates.put("/users/" + useId,userValues);
        myRef.updateChildren(childUpdates);
    }

    private void readNewUser(){
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.child("users").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                User user = dataSnapshot.getValue(User.class);
               /* Toast.makeText(NextActivity.this,
                        "Username is " + user.toMap().get("username"),
                        Toast.LENGTH_LONG).show();*/
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                User user = dataSnapshot.getValue(User.class);
               /* Toast.makeText(NextActivity.this,
                        "Email is " + user.toMap().get("email"),
                        Toast.LENGTH_LONG).show();*/
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    @SuppressLint("InlinedApi")
    private static String[] PERMISSIONS_STORAGE ={
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    private TextView tv_path_load ;

    public static void verifyStoragePermissions(Activity activity) {
        int permission = ActivityCompat.checkSelfPermission(activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if(permission != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

    private StorageReference mStorageRef;
    private static final String TAG2 = "FileUpload";
    private static int RESULT_LOAD_IMAGE = 1 ;
    public ImageView imageView ;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            //Toast.makeText(NextActivity.this,"img is " +selectedImage.getLastPathSegment(),Toast.LENGTH_LONG).show();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            final String picturePath =cursor.getString(columnIndex);
            //Toast.makeText(NextActivity.this,"picture path is " + picturePath,Toast.LENGTH_LONG).show();
            cursor.close();
            tv_path_load = (TextView) findViewById(R.id.tv_path_load);
//            tv_path_load.setText("choose " + picturePath);
            verifyStoragePermissions(NextActivity.this);
            imageView = (ImageView) findViewById(R.id.iv_show);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));


            Button button = (Button) findViewById(R.id.buttonUpload);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    uploadFile(picturePath);
                }
            });

        }
    }

    public void uploadFile(final String picturePath) {
        Uri file = Uri.fromFile(new File(picturePath));
        StorageReference riversRef = mStorageRef.child("images/"+file.getLastPathSegment());
        riversRef.putFile(file)

                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        //Toast.makeText(NextActivity.this,"Upload Success!!" + picturePath,Toast.LENGTH_LONG).show();
                        // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
                        Task<Uri> downloadUrl = taskSnapshot.getStorage().getDownloadUrl();
                        //TextView tv_path_up = (TextView) findViewById(R.id.tv_path_up);
//                        tv_path_load.setText("Upload "+picturePath);
                        tv_path_load.setText("Upload Success ");
                    }
                });
    }
}
