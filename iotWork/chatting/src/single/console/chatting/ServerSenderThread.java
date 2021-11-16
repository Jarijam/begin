package single.console.chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


//서버에서 클라이언트로 메시지를 전송하는 작업을 실행하는 쓰레드
public class ServerSenderThread extends Thread {
	Socket client;
	//쓰레드가 생성될때 클라이언트 정보를 넘겨 받도록 작업
	public ServerSenderThread(Socket client) {
		super();
		this.client = client;
		
	}
	//키보드로 입력한 메시지를 클라이언트로 보내는 작업을 처리
	@Override
	public void run() {
		BufferedReader keyin = null;
		PrintWriter out = null;
		
		try {
			keyin = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(client.getOutputStream(),true);
			String sendMsg=""; //클라이언트로 보낼 메세지
			while(true) {
				sendMsg = keyin.readLine();
				if(sendMsg==null) {
					break;
				}
				out.println(sendMsg);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
