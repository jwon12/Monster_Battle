package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class S_TC extends Thread {

	private Socket withClient = null;
	private Socket withC_Object = null;
	private Socket withC_listObject = null;
	
	private S_Analysis Analysis = null;
	private InputStream reMsg = null;
	
	private OutputStream sendMsg = null;
	private OutputStream sendObject = null;
	private OutputStream sendObject2 = null;
	
	private ObjectOutputStream send_Object_Output = null;
	private ObjectOutputStream send_listObject_Output = null;
	private S_TC mySin = null;
	private String myID = null;
	private String myNickname = null;

	public S_TC(Socket withClient, ServerSocket serverS_Object, ServerSocket serverS_listObject) throws Exception {
		this.withClient = withClient;
		
		withC_Object = serverS_Object.accept();
		withC_listObject = serverS_listObject.accept();
		
		Analysis = S_Analysis.getInstance();
		mySin = this;

	}

	@Override
	public void run() {
		recive();
	}

	public void list_O_send(TC_listObject a) {
		try {
			sendObject2 = withC_listObject.getOutputStream();
			send_listObject_Output = new ObjectOutputStream(sendObject2);
			send_listObject_Output.writeObject(a);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void O_send(TC_Object a) {
		try {
			sendObject = withC_Object.getOutputStream();
			send_Object_Output = new ObjectOutputStream(sendObject);
			send_Object_Output.writeObject(a);
			
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
						endCat();
						break;
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
