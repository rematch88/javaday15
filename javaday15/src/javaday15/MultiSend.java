package javaday15;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class MultiSend {

	public static void main(String[] args) {
		try {
			MulticastSocket ms = new MulticastSocket();
			Scanner sc = new Scanner(System.in);
			System.out.print("닉네임:");
			String nickname = sc.nextLine();
			
			while(true) {
				System.out.print("전송할 메시지(종료는 end):");
				String msg = sc.nextLine();
				//문자열은 ==로 비교하면 참조를 비교
				//equals 로 비교해야 값을 비교
				if(msg.equals("end")) {
					System.out.println("종료");
					break;
				}
				msg = nickname + ":" + msg;
				DatagramPacket dp =
						new DatagramPacket(msg.getBytes(), msg.getBytes().length,
								InetAddress.getByName("230.100.100.100"), 9999);
				ms.send(dp);
			}
		}catch(Exception e) {
			System.out.println("예외1:" + e.getMessage());
			e.getStackTrace();
		}
	}
}
