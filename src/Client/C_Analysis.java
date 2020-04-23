package Client;

import javax.swing.JOptionPane;

import Server.TC_Object;
import Server.TC_listObject;

public class C_Analysis {

	public static C_Analysis mySin = null;
	private C_Analysis_Login A_Login = null;
	private C_Analysis_Join A_Join = null;
	private C_Analysis_Room A_Room = null;
	private C_Analysis_Battle A_Battle = null;
	private Frame_Login F_Login = null;
	private Frame_Room F_Room = null;
	private Frame_Join F_Join = null;
	private Frame_Battle F_Battle = null;
	private C_TC C_TC_mySin = null;
	private String id;

	Frame_Battle_applyRecive F_recive = null;
	Frame_Battle_applySend F_send = null;

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
		this.C_TC_mySin = Sin;
		int index = 0;

		for (int i = 0; i < msg.length(); i++) {
			if (msg.charAt(i) == ' ') {
				index = i;
				break;
			}
		}

		String fist = msg.substring(0, index);
		String second = msg.substring(index + 1);

		switch (fist) {
		case "/server":
			System.out.println(second);
			break;
		case "/login":
			A_Login.ckMsg(second);
			break;
		case "/room":
			A_Room.ckMsg(second);
			break;
		case "/join":
			A_Join.ckMsg(second);
			break;
		case "/battle":
			A_Battle.ckMsg(Sin, second);
			break;
		}

	}
	
	public void relistObject(TC_listObject object) {
		String commend = object.getServerMsg();
		switch(commend) {
		case "/room":
			Frame_Room_BattleList F_battleList = new Frame_Room_BattleList();
			F_battleList.setting(object);
			break;
		}
		
	}

	public void reObject(C_TC mysin, TC_Object object) {
		if (F_Battle == null) {
			if (F_send != null) {
				F_send.Frame_close();
				F_send = null;
			}
			if (object.getPlayer1_id().equals(this.id)) {
				String opponentID = object.getPlayer2_id();
				F_Battle = new Frame_Battle(mysin, this.id, opponentID);
				setFrame_battle(F_Battle);
			} else {
				String opponentID = object.getPlayer1_id();
				F_Battle = new Frame_Battle(mysin, this.id, opponentID);
				setFrame_battle(F_Battle);
			}
			F_Battle.Startsetting(object);
		} else {
			String player1 = object.getPlayer1_id();
			if (player1.equals(this.id)) {
				F_Battle.player1Setting(object);
			} else {
				F_Battle.player2Setting(object);
			}

		}

	}

	public Frame_Room getFrame_Room() {
		return F_Room;
	}

	public void setFrame_JoinSin(Frame_Join j) {
		F_Join = j;
		A_Join.setF_Join(j);
	}

	public void setFrame_loginSin(Frame_Login l) {
		F_Login = l;
		A_Login.setF_Login(l);
	}

	public void setFrame_RoomSin(Frame_Room r) {
		F_Room = r;
		A_Room.setF_Room(r);
	}

	public void setFrame_recive(Frame_Battle_applyRecive r) {
		F_recive = r;
	}

	public void setFrame_send(Frame_Battle_applySend s) {
		F_send = s;
	}

	public void setFrame_battle(Frame_Battle b) {
		F_Battle = b;
	}

	public Frame_Battle_applyRecive getF_recive() {
		return F_recive;
	}

	public Frame_Battle_applySend getF_send() {
		return F_send;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public C_TC getC_TC_mySin() {
		return C_TC_mySin;
	}

	public Frame_Battle getF_Battle() {
		return F_Battle;
	}

	
}
