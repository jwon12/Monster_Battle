package Client;

import javax.swing.JOptionPane;

public class C_Analysis_Battle {
	C_TC myTC = null;
	public void ckMsg(C_TC sin, String msg) {
		myTC = sin;
		int index = 0;
		for(int i = 0 ; i < msg.length() ; i++) {
			if(msg.charAt(i) == ' ') {
				index = i;
				break;
			}
		}
		String commend = msg.substring(0,index);
		String tail = msg.substring(index+1);
		switch(commend) {
		case "apply":
			apply(tail);
			break;
		case "start":
			start(tail);
			break;
		case "reject":
			reject(tail);
		}		
	}

	private void reject(String tail) {
		String reID = tail;
		C_Analysis a = C_Analysis.getInstance();
		Frame_Battle_applySend applySend = a.getF_send();
		applySend.Frame_close();
		JOptionPane.showMessageDialog(null, reID+" 님이 거절하셨습니다.");
	}

	private void start(String msg) {
		int index = 0;
		for(int i = 0 ; i < msg.length() ; i++) {
			if(msg.charAt(i) == ' ') {
				index = i;
				break;
			}
		}
		String sendID = msg.substring(0,index);
		String reID = msg.substring(index+1);
		C_Analysis a = C_Analysis.getInstance();
		Frame_Room myRoom = a.getFrame_Room();
		String myID = myRoom.getMyID();
		
		
		Frame_Battle_applySend applySend = a.getF_send();
		if(applySend != null) {
			applySend.Frame_close();
		}
		
		if(sendID.equals(myID)) {
			String opponentID = reID;
			Frame_Battle F_Battle = new Frame_Battle(myTC,myID, opponentID);
			a.setFrame_battle(F_Battle);
		}else {
			String opponentID = sendID;
			Frame_Battle F_Battle = new Frame_Battle(myTC,myID, opponentID);
			a.setFrame_battle(F_Battle);
		}
		
	}

	private void apply(String msg) {
		int index = 0;
		for(int i = 0 ; i < msg.length() ; i++) {
			if(msg.charAt(i) == ' ') {
				index = i;
				break;
			}
		}
		String sendID = msg.substring(0,index);
		String MyID = msg.substring(index+1);
		Frame_Battle_applyRecive r = new Frame_Battle_applyRecive(myTC,sendID,MyID);
		C_Analysis c = C_Analysis.getInstance();
		c.setFrame_recive(r);
	}

}
