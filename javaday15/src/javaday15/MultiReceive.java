package javaday15;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;


public class MultiReceive {

	public static void main(String[] args) {
		try {
			MulticastSocket ms = new MulticastSocket(9999);
			//멀티캐스트에 참여
			ms.joinGroup(InetAddress.getByName("230.100.100.100"));
			System.out.println("멀티 케스트 시작");
			while(true) {
				//전송받은 데이터를 저장하는 바이트 배열 - 크기는 8의 배수로 설정하는 경우가 많음
				byte [] b = new byte[65536];
				//패킷을 생성
				DatagramPacket dp = new DatagramPacket(b, b.length);
				//데이터를 받을 수 있도록 대기
				ms.receive(dp);
				
				//데이터 읽기
				String msg = new String(dp.getData());
				System.out.println(msg.trim());
			}
		}catch(Exception e) {
			System.out.println("예외1:" + e.getMessage());
			e.getStackTrace();
		}
	}
}
