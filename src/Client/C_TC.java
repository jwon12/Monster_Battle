package Client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class C_TC {
	Socket withServer = null;
	C_TC mySin = null;
	private InputStream reMsg = null;
	private OutputStream sendMsg = null;
	Frame_Login F_login = null;
	C_Analysis Analysis = null;
	
	public C_TC(Socket withServer) {
		this.withServer = withServer;
		mySin = this;
		Analysis = C_Analysis.getInstance();		
		start();
	}

	private void start() {
		recive();
		F_login = new Frame_Login(this);
		Analysis.setFrame_loginSin(F_login);
		
	}

	private void recive() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					System.out.println("receive start~~");
					while (true) {
						reMsg = withServer.getInputStream();
						byte[] reBuffer = new byte[500];
						reMsg.read(reBuffer);
						String Smsg = new String(reBuffer);
						Smsg = Smsg.trim();
						Analysis.reMsg(mySin,Smsg);
						
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
	}

}
