package javaday15;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPInfo {

	public static void main(String[] args) {
		
		try {
			//자신의 컴퓨터의 IP 정보 확인 - 자신의 컴퓨터 이름(도메인)과 IP 주소
			InetAddress local = InetAddress.getLocalHost();
			System.out.println(local);
			//다음의 IP 정보 확인
			InetAddress [] googles = InetAddress.getAllByName("www.daum.net");
			for(InetAddress imsi : googles) {
				System.out.println(imsi);
			}
		} catch (UnknownHostException e) {
			System.out.println("예외:"+e.getMessage());
		}

	}

}
