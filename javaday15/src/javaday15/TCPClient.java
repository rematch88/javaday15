package javaday15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {

	public static void main(String[] args) {
		try {
			//서버에 접속하는 소켓을 생성 
			Socket socket = new Socket(InetAddress.getByName("211.183.7.85"),9000);
			//메시지 전송
			Scanner sc = new Scanner(System.in);
			System.out.print("전송할 메시지:");
			String msg = sc.nextLine();
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.println(msg);
			pw.flush();
			
			//메시지 읽기
			BufferedReader br =
					new BufferedReader(
							new InputStreamReader(
									socket.getInputStream()));
			String str = br.readLine();
			System.out.println(str);
			
			br.close();
			pw.close();
			socket.close();
			
		}catch(Exception e) {
			System.out.println("예외:" + e.getMessage());
			e.getStackTrace();
		}

	}

}
