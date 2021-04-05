package net_exam;
/**
 * 프로젝트 명 : DataSendReceive
 * 파일 명 : Client.java
 * 작성자 : 송재영
 * 작성일자 : 2021-04-05
 * 설명 : 네트워크 클라이언트 소켓을 구현한 클래스입니다.
 */
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Socket client = null;
		Scanner sc =null;
		BufferedOutputStream bos =null;
		
		try {
			client = new Socket();
			client.connect(new InetSocketAddress("localhost",1234));
			
			bos = new BufferedOutputStream(client.getOutputStream());
			sc = new Scanner(System.in);
			System.out.print("서버에게 전송할 메세지를 입력하세요 >>>");
			String sendMsg=sc.nextLine();
			bos.write(sendMsg.getBytes("UTF-8"));
			bos.flush();
			System.out.println();
			System.out.println("서버(127.0.0.1)로 \"" + sendMsg+"\" 데이터를 전송했습니다.");
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(bos!=null) {bos.close();}
				if(!client.isClosed()) {client.close();}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
