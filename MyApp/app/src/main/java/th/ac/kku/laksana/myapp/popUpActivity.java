package th.ac.kku.laksana.myapp;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class popUpActivity extends AppCompatActivity {

    VideoView videoView;
    TextView title;
    MediaController md;
    int numberVideo = 1;
    String videURL = "https://firebasestorage.googleapis.com/v0/b/testlaksana.appspot.com/o/1.mp4?alt=media&token=f16b578e-5321-46de-b4c8-8795bb890ec3";
    Uri uri = Uri.parse(videURL);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        title = (TextView) findViewById(R.id.titleVideo);
        videoView = (VideoView) findViewById(R.id.videoView);
        Button nextbt = (Button) findViewById(R.id.nextPart);

        videoView.setVideoURI(uri);
        videoView.requestFocus();
        md = new MediaController(this);
        videoView.setMediaController(md);
        md.setAnchorView(videoView);
        videoView.start();




    }


    public void goToHome(View v){
        popUpActivity.this.finish();
        numberVideo =1;
    }

}
