package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class S_TC extends Thread{
	
	private Socket withClient = null;
	private S_Analysis Analysis = null;
	private InputStream reMsg = null;
	private OutputStream sendMsg = null;
	private S_TC mySin = null;
	
	public S_TC(Socket withClient) {
		this.withClient = withClient;
		Analysis = S_Analysis.getInstance();
		mySin = this;
	}

	@Override
	public void run() {
		recive();
	}

	private void recive() {
		
		while(true) {
			try {
				reMsg = withClient.getInputStream();
				byte[] reBuffer = new byte[100];
				reMsg.read(reBuffer);
				String msg = new String(reBuffer);
				msg = msg.trim();
				if (msg.indexOf("/bye") == 0) {
					endCat();
					break;
				}else {
					Analysis.ckMsg(mySin,msg);	
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
		
	}
	
	public void send(String reMsg) {
		try {
			sendMsg = withClient.getOutputStream();
			sendMsg.write(reMsg.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("send end~~");
			return;
		}
	}

	private void endCat() {
		try {
			withClient.close();
			reMsg.close();
			sendMsg.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
