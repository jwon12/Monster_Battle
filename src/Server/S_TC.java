package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class S_TC extends Thread {

	private Socket withClient = null;
	private Socket withC_Object = null;
	private ServerSocket serverS_Object = null;
	private S_Analysis Analysis = null;
	private InputStream reMsg = null;
	private OutputStream sendMsg = null;
	private InputStream reMsg2 = null;
	private OutputStream sendMsg2 = null;
	private ObjectInputStream reObject = null;
	private ObjectOutputStream sendObject = null;
	private S_TC mySin = null;
	private String myID = null;
	private String myNickname = null;

	public S_TC(Socket withClient, ServerSocket serverS_Object) throws Exception {
		this.withClient = withClient;
		this.serverS_Object = serverS_Object;
		
		withC_Object = serverS_Object.accept();
		
		Analysis = S_Analysis.getInstance();
		mySin = this;

	}

	@Override
	public void run() {
		recive();
		TC_Object a = new TC_Object();
		a.Battle_msg = "하하하";
//		O_send(a);

	}

	private void O_recive() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					try {
						reMsg2 = withC_Object.getInputStream();
						reObject = new ObjectInputStream(reMsg2);
						TC_Object S_Object = (TC_Object)reObject.readObject();
						
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}
		}).start();

	}
	public void O_send(TC_Object a) {
		try {
			sendMsg2 = withC_Object.getOutputStream();
			sendObject = new ObjectOutputStream(sendMsg2);
			sendObject.writeObject(a);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void recive() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					try {
						reMsg = withClient.getInputStream();
						byte[] reBuffer = new byte[500];
						reMsg.read(reBuffer);
						String msg = new String(reBuffer);
						msg = msg.trim();
						if (msg.indexOf("/bye") == 0) {
							endCat();
							break;
						} else {
							Analysis.ckMsg(mySin, msg);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			}
		}).start();

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

	public void setIDNickName(String idNickName) {
		StringTokenizer ST = new StringTokenizer(idNickName, " ");
		myID = ST.nextToken();
		myNickname = ST.nextToken();
	}

	public String getID() {
		return myID;
	}

}
