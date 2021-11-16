package socket_echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
//예를 들어 아두이노 센서 장착 후 지속적인 데이터를 받아오는 작업들을 할때.
public class MyEchoClient01 {
	public static void main(String[] args) {
		Socket server = null;
		BufferedReader in = null; //서버에서 보내는 메시지를 읽기위한 스트림객체
		PrintWriter out = null;
		BufferedReader keyin = null; //서버로 보내기 위해 키보드를 통해 입력한 메시지를 읽기 위한 스트림객체 
		try {
			server = new Socket("192.168.0.140", 12345);
			System.out.println("서버에 접속 성공");
			//네트워크를 통해서 입출력을 하기 위한 IO스트림객체를 생성
			in = new BufferedReader(new InputStreamReader(server.getInputStream()));
			out = new PrintWriter(server.getOutputStream(),true);
			keyin = new BufferedReader(new InputStreamReader(System.in)); //키보드 입력 읽기
			
			
			//=====================<<< 통신 시작>>>====================
			// 키보드로 입력한 데이터를 서버로 지속전송하기 
			// 서버가 다시 보내오는 메세지를 콘솔에 출력
			String sendMsg = "";
			String resMsg = "";
			while((sendMsg = keyin.readLine())!=null) {
				//1. 클라이언트 -> 서버(키보드로 입력하는 메시지를 서버로 전송)
				out.println(sendMsg);
				//2. 클라이언트 <- 서버
				resMsg = in.readLine();
				System.out.println("서버가 보내는 메세지===>"+resMsg);
				
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
