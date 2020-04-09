package Server;

import java.util.ArrayList;

public class S_Analysis {

	public static S_Analysis mySin = null;

	S_Analysis_Login A_Login = null;
	S_Analysis_Room A_Room = null;
	S_Analysis_Battle A_Battle = null;
	S_Analysis_Join A_Join = null;
	ArrayList<S_TC> TCList = new ArrayList<>();
	ArrayList<String> chatList = new ArrayList<>();
	ArrayList<String> idList = new ArrayList<>();

	private S_Analysis() {
		A_Login = new S_Analysis_Login();
		A_Room = new S_Analysis_Room(this);
		A_Battle = new S_Analysis_Battle();
		A_Join = new S_Analysis_Join();
	}

	public static S_Analysis getInstance() {
		if (mySin == null) {
			mySin = new S_Analysis();
		}
		return mySin;
	}

	public void ckMsg(S_TC Sin, String msg) {
		int index = 0;

		for (int i = 0; i < msg.length(); i++) {
			if (msg.charAt(i) == ' ') {
				index = i;
				break;
			}
		}

		String fist = msg.substring(0, index);
		String second = msg.substring(index + 1);
		
		System.out.println(fist);
		System.out.println(second);
		
		switch (fist) {
		case "/login":
			String idNickName = A_Login.Ck_IDPS(second);
			if (idNickName == null) {
				Sin.send("/login false");
			} else {
				Sin.send("/login true " + idNickName);
				Sin.setIDNickName(idNickName);
				idList.add(Sin.getID());
				TCList.add(Sin);
				for(String id : idList) {
					for(S_TC s : TCList) {
						s.send("/room addmember "+id);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
			}
			break;
		case "/room":
			A_Room.ckMsg(Sin,second);
			break;
		case "/join":
			A_Join.ckMsg(Sin,second);
			break;
		}

	}
	public ArrayList<S_TC> getTCList() {
		return TCList;
	}
}
