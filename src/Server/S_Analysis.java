package Server;

import java.util.ArrayList;

public class S_Analysis {
	
	public static S_Analysis mySin = null;
	
	S_Analysis_Login A_Login = null;
	S_Analysis_Room  A_Room = null;
	S_Analysis_Battle A_Battle = null;
	ArrayList<S_TC> TCList = new ArrayList<>();
	ArrayList<String> chatList = new ArrayList<>();
	
	
	private S_Analysis(){
		A_Login = new S_Analysis_Login();
		A_Room =  new S_Analysis_Room();
		A_Battle = new S_Analysis_Battle();
	}
	
	public static S_Analysis getInstance() {
		if(mySin == null) {
			mySin = new S_Analysis();
		}
		return mySin;
	}

	public void ckMsg(S_TC Sin, String msg) {
		int index = 0;
		
		for(int i = 0; i < msg.length() ; i++) {
			if(msg.charAt(i) == ' ') {
				index = i;
				break;
			}
		}
		
		String fist = msg.substring(0, index);
		String second = msg.substring(index+1);
		System.out.println(fist);
		System.out.println(second);
		switch(fist) {
		case "/login":
			String idNickName = A_Login.Ck_IDPS(second);
			if(idNickName == null) {
				Sin.send("/login false");
			}else {
				Sin.send("/login true "+idNickName);
				Sin.setIDNickName(idNickName);
				TCList.add(Sin);
			}
			break;
		case "/room":
			chatList.add(second);
			for(S_TC s : TCList) {
				s.send("/room addmember "+s.getNickName());
			}
			break;
		}
		
	}
}
