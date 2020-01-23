package javaday15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class StringDownload {

	public static void main(String[] args) {
		try {
			// 다운로드 받을 URL 생성
			URL url = new URL("https://www.naver.com");
			// URL 연결 객체 생성
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			// 연결 옵션 설정
			con.setConnectTimeout(30000); // 30초 동안 연결이 안되면 연결 시도 종료
			// 캐시 사용을 하지 않음
			con.setUseCaches(false);

			// 데이터를 읽어올 스트림을 생성
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			// 많은 양의 문자열을 읽어야 하는 경우
			StringBuilder sb = new StringBuilder();
			while (true) {
				// 한줄 읽기
				String line = br.readLine();
				// 읽은 데이터가 없으면 반복문 중단
				if (line == null) {
					break;
				}
				// 데이터가 있으면 sb에 추가
				sb.append(line + "\n");
			}

			// StringBuilder의 데이터를 String으로 변환
			String html = sb.toString();
			System.out.println(html);

		} catch (Exception e) {
			System.out.println("다운로드 예외:" + e.getMessage());
			e.printStackTrace();
		}

	}

}
