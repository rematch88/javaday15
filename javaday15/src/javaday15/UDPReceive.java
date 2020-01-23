package javaday15;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceive {

	public static void main(String[] args) {
		try {
			//받는 소켓 생성
			DatagramSocket socket = new DatagramSocket(7777);

			//데이터 전송 받아서 읽기
			while(true) {
				//데이터를 저장할 패킷을 생성
				//이 두개의 문장을 반복문 바깥에 만들면 통신은 되는데 긴 메시지를 보내고 짧은 메시지르 보내면
				//짧은 메시지 뒤에 긴 메시지의 내용이 추가되는 형태가 됩니다.
				//반복문 안에서 계속 사용해야하는 데이터는 반복문 안에서 초기화를 해주어야 합니다.
				byte [] b = new byte[65536];
				DatagramPacket dp = new DatagramPacket(b, b.length);
				
				//대기하고 있다가 데이터를 전송 받으면 동작
				socket.receive(dp);
				//보낸곳 확인
				System.out.println("보낸곳:"+dp.getAddress().getHostAddress());
				//데이터 확인
				String msg = new String(b);
				System.out.println(msg);
			}
		}catch(Exception e) {
			System.out.println("예외1:" + e.getMessage());
			e.getStackTrace();
		}

	}

}
