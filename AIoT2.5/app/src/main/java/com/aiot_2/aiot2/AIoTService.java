package com.aiot_2.aiot2;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
// 서버를 켜놓고 오랫동안 동작을 하지 않으면 서버가 끊길 수 있으므로, 서비스로 만들어 서버가 끊기지 않도록 한다
public class AIoTService extends Service {
    public AIoTService() {
    }

    // ServerThread라고 하는 것을 여기에다가 만들면 됨
    // overide method에서 선택!
    // 이렇게 구성하면 서비스에서 서버를 실행할 수 있음(실행하면 대기상태로 존재함)
    @Override
    public void onCreate() {
        super.onCreate();
        ServerThread thread = new ServerThread();
        thread.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    // 서버기능을 만든다
    class ServerThread extends Thread{
        public void run(){
            // 클라이언트가 이 포트로 접속해야함
            int port = 5001;

            // 예외사항까지 포함!
            try {
                ServerSocket server = new ServerSocket(port);
                Log.d("ServerThread","서버가 실행됨");

                // 서버가 80이란 지정된 포트로 대기상태로 ㄱㄱ함
                while(true){

                    Socket socket = server.accept();
                    // 들어오는 데이터 처리
                    ObjectInputStream instream =  new ObjectInputStream(socket.getInputStream());

                    // 클라이언트에서 받아온 것을 읽을 수 있다.
                    Object input = instream.readObject();
                    Log.d("ServerThread","input : " + input);

                    // 클라이언트 쪽으로 데이터를 보내본다 (server에서 보낸 데이터 확인)
                    String result = "반가워";
                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                    outputStream.writeObject(result + "\n"+" from server.");
                    outputStream.flush();   // 버퍼에 남은 데이터 지워줌
                    Log.d("ServerThread"," output 보냄 ");

                    socket.close(); // 리소스는 한정적이기 때문에... 지워줄수있다. 웬만하면 ㄱㄱ
                }

            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
