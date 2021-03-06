package Client;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;

import Server.TC_Object;
import Server.TC_listObject;


public class C_TC {
	private Socket withServer = null;
	private Socket withObjectServer = null;
	private Socket withlistObjectServer = null;
	private C_TC mySin = null;
	private InputStream reMsg = null;
	private InputStream reMsg2 = null;
	private InputStream re_list= null;
	private ObjectInputStream reObject = null;
	private ObjectInputStream relistObject = null;
	private OutputStream sendMsg = null;
	private Frame_Login F_login = null;
	private C_Analysis Analysis = null;

	public C_TC(Socket withServer, Socket withObjectServer, Socket withlistObjectServer) {
		this.withServer = withServer;
		this.withObjectServer = withObjectServer;
		this.withlistObjectServer = withlistObjectServer;
		mySin = this;
		Analysis = C_Analysis.getInstance();
		start();
	}

	private void start() {
		recive();
		F_login = new Frame_Login(this);
		Analysis.setFrame_loginSin(F_login);
		Orecive();
		list_O_recive();
	}

	private void list_O_recive() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						re_list = withlistObjectServer.getInputStream();
						relistObject = new ObjectInputStream(re_list);
						TC_listObject Object = (TC_listObject) relistObject.readObject();
						Analysis.relistObject(Object);
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

			}
		}).start();

	}
	
	private void Orecive() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						reMsg2 = withObjectServer.getInputStream();
						reObject = new ObjectInputStream(reMsg2);
						TC_Object Object = (TC_Object) reObject.readObject();
						Analysis.reObject(mySin,Object);
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

			}
		}).start();

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
						Analysis.reMsg(mySin, Smsg);

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
