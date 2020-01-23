package javaday15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class DaumMain {

	public static void main(String[] args) {
		try {
			//daum의 주소를 생성
			InetAddress addr = InetAddress.getByName("www.daum.net");
			//TCP 소켓 생성
			Socket socket = new Socket(addr, 80);
			
			//요청 전송
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.println("GET http://www.daum.net");
			pw.flush();
			
			//데이터 읽기 - 문자 단위
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			//읽을 데이터가 없을 때까지 줄 단위로 읽어오기
			while(true) {
				String line = br.readLine();
				if(line == null) {
					break;
				}
				System.out.println(line);
			}
			br.close();
			socket.close();
			
			
		}catch(Exception e) {
			//예외 메시지 출력
			System.out.println("예외" + e.getMessage());
			//예외가 발생한 코드를 역추적
			e.printStackTrace();
		}

	}

}

