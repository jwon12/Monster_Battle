package Server;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class S_Main {
	
	ServerSocket serverS = null;
	Socket withClient = null;
	S_Analysis Analysis = S_Analysis.getInstance();
	
	ArrayList<Socket> CList = new ArrayList<>();
	
	S_Main() throws Exception{
		serverS = new ServerSocket();
		serverS.bind(new InetSocketAddress("10.0.0.109",9999));
		
		while(true) {
			System.out.println("서버 대기중");
			withClient = serverS.accept();
			CList.add(withClient);
			System.out.println(withClient.getInetAddress()+"클라이언트 접속 함");
			S_TC s = new S_TC(withClient);
			s.start();
		}
		
		
		
		
	}
	
	
	
	
	
	
	public static void main(String[] args) throws Exception {
		new S_Main();

	}

}
