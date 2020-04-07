package Client;

public class C_Analysis {

	public static C_Analysis mySin = null;
	C_Analysis_Login A_Login = null;
	C_Analysis_Join A_Join = null;
	C_Analysis_Room A_Room = null;
	C_Analysis_Battle A_Battle = null;
	Frame_Login F_Login = null;
	Frame_Room F_Room = null;
	
	
	
	private C_Analysis() {
		A_Login = new C_Analysis_Login();
		A_Join = new C_Analysis_Join();
		A_Room = new C_Analysis_Room();
		A_Battle = new C_Analysis_Battle();
		
	}

	public static C_Analysis getInstance() {
		if (mySin == null) {
			mySin = new C_Analysis();
		}
		return mySin;
	}

	public void reMsg(C_TC Sin, String msg) {
		int index = 0;

		for (int i = 0; i < msg.length(); i++) {
			if (msg.charAt(i) == ' ') {
				index = i;
				break;
			}
		}
		
		String fist = msg.substring(0, index);
		String second = msg.substring(index+1);
		
		switch(fist) {
		case "/login":
			A_Login.ckMsg(second);
			break;
		case "/room":
			A_Room.ckMsg(second);
			break;
		}

	}
	
	public void setFrame_loginSin(Frame_Login l) {
		F_Login = l;
		A_Login.setF_Login(l);
	}
	public void setFrame_RoomSin(Frame_Room r) {
		F_Room = r;
//		A_Room.setF_Room(r);
	}

}
