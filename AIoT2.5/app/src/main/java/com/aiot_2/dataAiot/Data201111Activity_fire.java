package com.aiot_2.dataAiot;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.aiot_2.aiot2.R;

public class Data201111Activity_fire extends AppCompatActivity {

    VideoView videoView;
    public static String url = "http://sites.google.com/site/ubiaccessmobile/sample_video.mp4";
    //public static String url = "https://www.youtube.com/watch?v=CilcqhTR82o";
    WebView webView;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data201111_fire);

        Toast.makeText(getApplicationContext(),"영상이 준비될때까지 잠시만 기다려주세요.",Toast.LENGTH_SHORT).show();
        // 직접 컨트롤할 수 있도록
        videoView = (VideoView) findViewById(R.id.videoView);

        MediaController controller = new MediaController(this);
        videoView.setMediaController(controller);
        videoView.setVideoURI(Uri.parse(url));
        videoView.requestFocus();   // 파일의 일부를 가져옴. 준비과정이 끝나야 영상을 가져올 수 있음

        // 준비과정을 알려주는 메소드
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                Toast.makeText(getApplicationContext(), "동영상 재생준비 완료", Toast.LENGTH_SHORT).show();
            }
        });

        final WebView webView = (WebView)findViewById(R.id.webView);
        Button startButton = (Button)findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 처음위치로 돌아갈수 있는거
                videoView.seekTo(0);
                videoView.start();

                webView.setWebViewClient(new WebViewClient());

                WebSettings webSettings = webView.getSettings();
                webSettings.setBuiltInZoomControls(true);

                webView.loadUrl("http://35.216.85.216/view2.php");
                //webView.loadUrl("http://www.naver.com");

                /**
                 * 1초마다 실시간으로 데이터 새로고침! (소켓통신 대신 무한loop로 구현함)
                 **/
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(true){
                            handler.postDelayed(this,1000);
                        }
                        webView.reload();
                    }
                },1000);
            }
        });

        /**
         * data 출력
         **/
       /* TextView textView_data = (TextView)findViewById(R.id.textView_data);

        for(int saram = 0 ; saram <= 20 ; saram++){
            if(saram>=15){
                Toast.makeText(getApplicationContext(),"불법침입이 감지되었습니다.",Toast.LENGTH_SHORT).show();
            }
            textView_data.setText("인체감지센서 : " + saram + "\n");

        }*/
    }
}