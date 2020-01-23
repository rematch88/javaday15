package javaday15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {
		try {
			//서버 소켓을 생성
			ServerSocket ss = new ServerSocket(9000);
			while(true) {
				System.out.println("서버 대기 중....");
				//클라이언트 접속을 기다림
				Socket socket = ss.accept();
				//접속한 클라이언트 정보 확인
				System.out.println("접속한 클라이언트:" + socket.getInetAddress());
				//클라이언트가 전송한 메시지 확인
				BufferedReader br =
						new BufferedReader(
								new InputStreamReader(
										socket.getInputStream()));
				String msg = br.readLine();
				System.out.println("메시지 : " + msg);
				
				//클라이언트에게 메시지 전송
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				pw.println("서버가 보내는 메시지");
				pw.flush();
				
				br.close();
				pw.close();
				socket.close();
				
			}
			
			
		}catch(Exception e) {
			System.out.println("예외 : " + e.getMessage());
			e.printStackTrace();
		}

	}

}
