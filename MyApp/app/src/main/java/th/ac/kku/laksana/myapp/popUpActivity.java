package th.ac.kku.laksana.myapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;
import android.widget.ViewFlipper;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class popUpActivity extends AppCompatActivity implements View.OnClickListener{
    ViewFlipper flipper;
    VideoView videoViewPart1,videoViewPart2,videoViewPart3,videoViewPart4;
    TextView title;
    MediaController md;
    int numberVideo = 1;
    Button nextbt,prvbt,fullsrceenbt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        title = (TextView) findViewById(R.id.titleVideo);

        videoViewPart1 = (VideoView) findViewById(R.id.videoView1);
        videoViewPart2 = (VideoView) findViewById(R.id.videoView2);
        videoViewPart3 = (VideoView) findViewById(R.id.videoView3);
        videoViewPart4 = (VideoView) findViewById(R.id.videoView4);
        flipper = (ViewFlipper) findViewById(R.id.flipper);
        nextbt = (Button) findViewById(R.id.nextPart);
        prvbt = (Button) findViewById(R.id.previousPart);
        fullsrceenbt = (Button) findViewById(R.id.btfullscreen);
        fullsrceenbt.setOnClickListener(this);
        nextbt.setOnClickListener(this);
        prvbt.setOnClickListener(this);

        String videURLpart1 = "https://firebasestorage.googleapis.com/v0/b/fir-74804.appspot.com/o/1.mp4?alt=media&token=4c23a369-bc0f-4c5c-ad73-7eac5cf54e2e";
        Uri uriPart1 = Uri.parse(videURLpart1);
        videoViewPart1.setVideoURI(uriPart1);
        videoViewPart1.requestFocus();
        md = new MediaController(this);
        videoViewPart1.setMediaController(md);
        md.setAnchorView(videoViewPart1);
        videoViewPart1.start();


        String videURLpart2 = "https://firebasestorage.googleapis.com/v0/b/fir-74804.appspot.com/o/2.mp4?alt=media&token=eb6cdaea-1331-4426-a4ea-85731fb9fc3c";
        Uri uriPart2 = Uri.parse(videURLpart2);
        videoViewPart2.setVideoURI(uriPart2);
        videoViewPart2.requestFocus();
        md = new MediaController(this);
        videoViewPart2.setMediaController(md);
        md.setAnchorView(videoViewPart2);
        videoViewPart2.start();


        String videURLpart3 = "https://firebasestorage.googleapis.com/v0/b/fir-74804.appspot.com/o/3.mp4?alt=media&token=3a8c9d2f-c32e-4b0f-90de-4712e4538a2c";
        Uri uriPart3 = Uri.parse(videURLpart3);
        videoViewPart3.setVideoURI(uriPart3);
        videoViewPart3.requestFocus();
        md = new MediaController(this);
        videoViewPart3.setMediaController(md);
        md.setAnchorView(videoViewPart3);
        videoViewPart3.start();


        String videURLpart4 = "https://firebasestorage.googleapis.com/v0/b/fir-74804.appspot.com/o/4.mp4?alt=media&token=e7022eff-a5bc-4297-b501-61a929f8ae90";
        Uri uriPart4 = Uri.parse(videURLpart4);
        videoViewPart4.setVideoURI(uriPart4);
        videoViewPart4.requestFocus();
        md = new MediaController(this);
        videoViewPart4.setMediaController(md);
        md.setAnchorView(videoViewPart4);
        videoViewPart4.start();
    }


    public void goToHome(View v){
        popUpActivity.this.finish();
    }

    @Override
    public void onClick(View v) {
        if(v == nextbt){
            flipper.showNext();
        }
        else if(v == prvbt){
            flipper.showPrevious();
        }
        else if(v == fullsrceenbt){

        }


    }

    public void openPdf(View v){
        Intent pdfDiffIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/file/d/1T9VUy7MsAMqSHlZeVgTQAwXyq-8EzbFQ/view?usp=sharing"));
        startActivity(pdfDiffIntent);
    }
}
