package com.aiot_2.aiot2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
//public class SystemActivity extends AppCompatActivity {
public class SystemActivity extends YouTubeBaseActivity {

    Handler handler = new Handler();
    ScrollView scrollView;
    VideoView videoView;
    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener listener;
    //public static String url = "http://clips.vorwaerts-gmbh.de/VfE_html5.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system);

        //final Button dataBringButton = (Button) findViewById(R.id.data_bring_system);
        Button dataButton = (Button) findViewById(R.id.webButton);

        // 아래바 버튼 선언
        Button systemButton = (Button) findViewById(R.id.systemButton_system);
        Button alarmButton = (Button) findViewById(R.id.alarmButton_system);
        Button securityButton = (Button) findViewById(R.id.securityButton_system);
        Button settingButton = (Button) findViewById(R.id.settingsButton_system);

        // 아래바 알람버튼
        alarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AlarmActivity.class);
                startActivity(intent);
            }
        });

        // 아래바 시스템관리버튼
        systemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        // 아래바 보안관리버튼
        securityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SecurityActivity.class);
                startActivity(intent);
            }
        });

        // 아래바 설정버튼
        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FireActivity.class);
                startActivity(intent);
            }
        });

        // 앱을 누르면 서비스로 만든 서버 시작
        final Intent intent = new Intent(getApplicationContext(),AIoTService.class);
        startService(intent);

        // 데이터 출력버튼
        final WebView webView = (WebView)findViewById(R.id.webView);

        /**
         * 영상데이터 출력
         **/
        /*Uri url = Uri.parse("android.resource://"+ getPackageName() +"/"+R.raw.output);
        Toast.makeText(getApplicationContext(),"영상이 준비될때까지 잠시만 기다려주세요.",Toast.LENGTH_SHORT).show();
        // 영상을 직접 컨트롤할 수 있도록!
        videoView = (VideoView) findViewById(R.id.videoView);

        MediaController controller = new MediaController(this);
        videoView.setMediaController(controller);
        //videoView.setVideoURI(Uri.parse(url));
        videoView.setVideoURI(url);
        videoView.requestFocus();   // 파일의 일부를 가져옴. 준비과정이 끝나야 영상을 가져올 수 있음

        // 준비과정을 알려주는 메소드
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                Toast.makeText(getApplicationContext(), "동영상 재생준비 완료", Toast.LENGTH_SHORT).show();
            }
        }); */
        final EditText youtubeText = (EditText)findViewById(R.id.youtubeText);
        youTubePlayerView = findViewById(R.id.youtubeView);
        listener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(youtubeText.getText().toString()); // 동영상 (실시간 가능)
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        /**
         * web 브라우저 불러오기 & 영상 재생
         **/
        final EditText webEditText = (EditText)findViewById(R.id.webEditText);

        webView.setWebViewClient(new webViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setBuiltInZoomControls(true);
        dataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 영상데이터 재생
                //videoView.seekTo(0);
                //videoView.start();
                youTubePlayerView.initialize("AIzaSyBbFX9UPgdJLeGDmEOEFAhKdgMsjLfsLZM", listener); // api

                webView.loadUrl(webEditText.getText().toString());
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
         * JSON 으로 파싱한 데이터 출력 버튼
         **/
        /*jsonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Json 파싱",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),JsonActivity.class);
                startActivity(intent);
            }
        });*/

        /**
         * port, host ip를 입력하여 통신
         **/
        /*dataBringButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"TCP/IP연결",Toast.LENGTH_SHORT).show();
                ClientThread thread = new ClientThread();
                thread.start();
            }
        });*/

        /**
         * AsyncTask로 구현
         * url 연결하여 통신
         **/
        // 소켓통신 버튼
        /*serverStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"URL연결",Toast.LENGTH_SHORT).show();
                // URL 설정
                String url = "http://34.64.76.14/hello.php";

                // AsyncTask를 통해 HttpURLConnection 수행
                NetworkTask networkTask = new NetworkTask(url, null);
                networkTask.execute();
            }
        });*/

        /**
         * url입력하여 웹과 통신하도록 AsyncTask로 구현
         **/
    }

    // webviewclient 정의
    class webViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){

            return super.shouldOverrideUrlLoading(view, url);
        }
    }

        public class NetworkTask extends AsyncTask<Void, Void, String> {

            private String url;
            private ContentValues values;

            public NetworkTask(String url, ContentValues values) {
                this.url = url;
                this.values = values;
            }

            @Override
            protected String doInBackground(Void... voids) {
                String result;
                RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
                result = requestHttpURLConnection.request(url, values);
                // 해당 URL로부터 결과물을 얻어온다

                return result;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);

                scrollView = (ScrollView)findViewById(R.id.outputScroll);
                // doInBackground()로 부터 리턴된 값이 onPostExecuted의 매개변수로 넘어오므로 s를 출력한다.
                //output.append("받은 데이터 : " + s + "\n");

            }
        }

        /**
         * 영상데이터 전체화면 꽉차게!!
         **/
        public class MotiveVideoView extends VideoView {

            public MotiveVideoView(Context context) {
                super(context);
            }

            public MotiveVideoView(Context context, AttributeSet attrs) {
                super(context, attrs);
            }

            @Override
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
            }
        }
}
