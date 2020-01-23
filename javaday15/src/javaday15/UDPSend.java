package javaday15;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPSend {

	public static void main(String[] args) {
		try {
			//UDP 전송을 위한 소캣 생성
			DatagramSocket ds = new DatagramSocket();
			Scanner sc = new Scanner(System.in);
			while(true) {
				//메시지 입력
				System.out.print("전송할 메시지:");
				String msg = sc.nextLine();
				//전송할 패킷 생성
				DatagramPacket dp = new DatagramPacket(
						msg.getBytes(), msg.getBytes().length,
						InetAddress.getByName("211.183.7.85"), 7777);
				ds.send(dp);
			}
		}catch(Exception e) {
			System.out.println("예외1:" + e.getMessage());
			e.getStackTrace();
		}

	}
}
