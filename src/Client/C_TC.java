package Client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class C_TC {
	Socket withServer = null;
	C_TC mySin = null;
	private InputStream reMsg = null;
	private OutputStream sendMsg = null;
	
	public C_TC(Socket withServer) {
		this.withServer = withServer;
		mySin = this;
		start();
	}

	private void start() {
		recive();
		
	}

	private void recive() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					System.out.println("receive start~~");
					while (true) {
						reMsg = withServer.getInputStream();
						byte[] reBuffer = new byte[100];
						reMsg.read(reBuffer);
						String Smsg = new String(reBuffer);
						Smsg = Smsg.trim();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("receive end~");
					return;
				}

			}
		}).start();
		
	}
	public void send(String Msg) {
		try {
			sendMsg = withServer.getOutputStream();
			sendMsg.write(Msg.getBytes());
			if (Msg.indexOf("/bye") == 0) {
				endCat();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("send end~~");
			return;
		}

	}

	private void endCat() {
		// TODO Auto-generated method stub
		
	}

}
