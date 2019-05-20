package th.ac.kku.laksana.myapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;
import android.widget.ViewFlipper;

public class popUpActivity2 extends AppCompatActivity implements View.OnClickListener{
    ViewFlipper flipper;
    VideoView videoViewPart1,videoViewPart2,videoViewPart3,videoViewPart4,videoViewPart5,videoViewPart6,videoViewPart7,videoViewPart8,videoViewPart9,videoViewPart10,videoViewPart11;
    TextView title;
    MediaController md;
    Button nextbt,prvbt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up2);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        title = (TextView) findViewById(R.id.titleVideo);

        videoViewPart1 = (VideoView) findViewById(R.id.videoView1);
        videoViewPart2 = (VideoView) findViewById(R.id.videoView2);
        videoViewPart3 = (VideoView) findViewById(R.id.videoView3);
        videoViewPart4 = (VideoView) findViewById(R.id.videoView4);
        videoViewPart5 = (VideoView) findViewById(R.id.videoView5);
        videoViewPart6 = (VideoView) findViewById(R.id.videoView6);
        videoViewPart7 = (VideoView) findViewById(R.id.videoView7);
        videoViewPart8 = (VideoView) findViewById(R.id.videoView8);
        videoViewPart9 = (VideoView) findViewById(R.id.videoView9);
        videoViewPart10 = (VideoView) findViewById(R.id.videoView10);
        videoViewPart11 = (VideoView) findViewById(R.id.videoView11);


                flipper = (ViewFlipper) findViewById(R.id.flipper);
        nextbt = (Button) findViewById(R.id.nextPart);
        prvbt = (Button) findViewById(R.id.previousPart);
        nextbt.setOnClickListener(this);
        prvbt.setOnClickListener(this);

        String videURLpart1 = "https://firebasestorage.googleapis.com/v0/b/fir-74804.appspot.com/o/Laplace%20Transform%201.mp4?alt=media&token=6743bacb-b85f-4558-b1c3-7257524311fa";
        Uri uriPart1 = Uri.parse(videURLpart1);
        videoViewPart1.setVideoURI(uriPart1);
        videoViewPart1.requestFocus();
        md = new MediaController(this);
        videoViewPart1.setMediaController(md);
        md.setAnchorView(videoViewPart1);
        videoViewPart1.start();


        String videURLpart2 = "https://firebasestorage.googleapis.com/v0/b/fir-74804.appspot.com/o/Laplace%20Transform%202.mp4?alt=media&token=e303cab0-2242-49c1-8b6f-f3dba39c7703";
        Uri uriPart2 = Uri.parse(videURLpart2);
        videoViewPart2.setVideoURI(uriPart2);
        videoViewPart2.requestFocus();
        md = new MediaController(this);
        videoViewPart2.setMediaController(md);
        md.setAnchorView(videoViewPart2);
        videoViewPart2.start();


        String videURLpart3 = "https://firebasestorage.googleapis.com/v0/b/fir-74804.appspot.com/o/Laplace%20Transform%203.mp4?alt=media&token=f53406d9-df2d-49e1-9db8-e715a8fdb095";
        Uri uriPart3 = Uri.parse(videURLpart3);
        videoViewPart3.setVideoURI(uriPart3);
        videoViewPart3.requestFocus();
        md = new MediaController(this);
        videoViewPart3.setMediaController(md);
        md.setAnchorView(videoViewPart3);
        videoViewPart3.start();


        String videURLpart4 = "https://firebasestorage.googleapis.com/v0/b/fir-74804.appspot.com/o/Laplace%20Transform%204.mp4?alt=media&token=3c645302-503e-4bda-a443-84a174defbec";
        Uri uriPart4 = Uri.parse(videURLpart4);
        videoViewPart4.setVideoURI(uriPart4);
        videoViewPart4.requestFocus();
        md = new MediaController(this);
        videoViewPart4.setMediaController(md);
        md.setAnchorView(videoViewPart4);
        videoViewPart4.start();

        //

        String videURLpart5 = "https://firebasestorage.googleapis.com/v0/b/fir-74804.appspot.com/o/Laplace%20Transform%205.mp4?alt=media&token=27d465e3-4919-4932-81b8-fa11c69bb937";
        Uri uriPart5 = Uri.parse(videURLpart5);
        videoViewPart5.setVideoURI(uriPart5);
        videoViewPart5.requestFocus();
        md = new MediaController(this);
        videoViewPart5.setMediaController(md);
        md.setAnchorView(videoViewPart5);
        videoViewPart5.start();


        String videURLpart6 = "https://firebasestorage.googleapis.com/v0/b/fir-74804.appspot.com/o/Laplace%20Transform%206.mp4?alt=media&token=9bc158b5-c468-486b-9319-3ad7cbb899e8";
        Uri uriPart6 = Uri.parse(videURLpart6);
        videoViewPart6.setVideoURI(uriPart6);
        videoViewPart6.requestFocus();
        md = new MediaController(this);
        videoViewPart6.setMediaController(md);
        md.setAnchorView(videoViewPart6);
        videoViewPart6.start();


        String videURLpart7 = "https://firebasestorage.googleapis.com/v0/b/fir-74804.appspot.com/o/Laplace%20Transform%207.mp4?alt=media&token=57de356c-33fc-4404-b6f0-29bb82b780d1";
        Uri uriPart7 = Uri.parse(videURLpart7);
        videoViewPart7.setVideoURI(uriPart7);
        videoViewPart7.requestFocus();
        md = new MediaController(this);
        videoViewPart7.setMediaController(md);
        md.setAnchorView(videoViewPart7);
        videoViewPart7.start();


        String videURLpart8 = "https://firebasestorage.googleapis.com/v0/b/fir-74804.appspot.com/o/Laplace%20Transform%208.mp4?alt=media&token=82eb4b72-fa38-4df7-bbea-027c945525bd";
        Uri uriPart8 = Uri.parse(videURLpart8);
        videoViewPart8.setVideoURI(uriPart8);
        videoViewPart8.requestFocus();
        md = new MediaController(this);
        videoViewPart8.setMediaController(md);
        md.setAnchorView(videoViewPart8);
        videoViewPart8.start();

        String videURLpart9 = "https://firebasestorage.googleapis.com/v0/b/fir-74804.appspot.com/o/Laplace%20Transform%209.mp4?alt=media&token=01c56f57-4c60-419a-8ecc-bab8c32fca1e";
        Uri uriPart9 = Uri.parse(videURLpart9);
        videoViewPart9.setVideoURI(uriPart9);
        videoViewPart9.requestFocus();
        md = new MediaController(this);
        videoViewPart9.setMediaController(md);
        md.setAnchorView(videoViewPart9);
        videoViewPart9.start();

        String videURLpart10 = "https://firebasestorage.googleapis.com/v0/b/fir-74804.appspot.com/o/Laplace%20Transform%2010.mp4?alt=media&token=4c90b55e-3725-4b80-b3b7-7a7352a94650";
        Uri uriPart10 = Uri.parse(videURLpart10);
        videoViewPart10.setVideoURI(uriPart10);
        videoViewPart10.requestFocus();
        md = new MediaController(this);
        videoViewPart10.setMediaController(md);
        md.setAnchorView(videoViewPart10);
        videoViewPart10.start();

        String videURLpart11 = "";
        Uri uriPart11 = Uri.parse(videURLpart11);
        videoViewPart11.setVideoURI(uriPart11);
        videoViewPart11.requestFocus();
        md = new MediaController(this);
        videoViewPart11.setMediaController(md);
        md.setAnchorView(videoViewPart11);
        videoViewPart11.start();


    }


    public void goToHome(View v){
        popUpActivity2.this.finish();
    }

    @Override
    public void onClick(View v) {
        if(v == nextbt){
            flipper.showNext();
        }
        else if(v == prvbt){
            flipper.showPrevious();
        }


    }

    public void openPdf(View v){
        Intent pdfDiffIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/file/d/1T9VUy7MsAMqSHlZeVgTQAwXyq-8EzbFQ/view?usp=sharing"));
        startActivity(pdfDiffIntent);
    }
}
