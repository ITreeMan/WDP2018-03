package th.ac.kku.laksana.myapp;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class openfullScreen extends AppCompatActivity {

    VideoView videofull;
    String urlfull="";
    MediaController mdfull;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_openfull_screen);
        videofull = (VideoView) findViewById(R.id.videofull);


        urlfull = getIntent().getStringExtra("full");

        Uri uri1 = Uri.parse(urlfull);
        videofull.setVideoURI(uri1);
        videofull.requestFocus();
        mdfull = new MediaController(this);
        videofull.setMediaController(mdfull);
        mdfull.setAnchorView(videofull);
        videofull.start();
    }

    @Override
    public void onBackPressed() {
        openfullScreen.this.finish();
    }
}
