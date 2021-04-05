package net_exam;
/**
 * 프로젝트 명 : DataSendReceive
 * 파일 명 : Server.java
 * 작성자 : 송재영
 * 작성일자 : 2021-04-05
 * 설명 : 네트워크 서버 소켓을 구현한 클래스입니다.
 */

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		ServerSocket server =null;
		Socket client =null;
		BufferedInputStream bis =null;
		
		try {
		
			server = new ServerSocket();
			server.bind(new InetSocketAddress("localhost",1234));
			client = server.accept();
			InetSocketAddress isa = (InetSocketAddress)client.getRemoteSocketAddress();
			InetAddress addr = isa.getAddress();
			
			
			bis = new BufferedInputStream(client.getInputStream());
			byte []b = new byte[1024];
			int length = bis.read(b);
			String receiveMsg = new String(b,0,length,"UTF-8");
			System.out.println("클라이언트 ("+addr+")로부터 \""+receiveMsg+"\" 데이터를 받았습니다.");
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally 
		{
			try {
				if(bis!=null) {bis.close();}
				if(!server.isClosed()) {server.close();}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
		
		
		
	}
}
