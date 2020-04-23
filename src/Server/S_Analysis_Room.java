package Server;

import java.util.ArrayList;

public class S_Analysis_Room {
	
	S_Analysis Analysis = null;
	
	S_Analysis_Room(S_Analysis A_Sin){
		Analysis = A_Sin;
	}
	
	public void ckMsg(S_TC sin, String msg) {
		int index = 0;
		for (int i = 0; i < msg.length(); i++) {
			if (msg.charAt(i) == ' ') {
					index = i;
				break;
			}
		}
		String commend = msg.substring(0,index);
		System.out.println("room : "+commend);
		switch(commend) {
		case "chat":
			int nextIndex = 0;
			for(int i = index+1 ; i < msg.length() ; i++) {
				if(msg.charAt(i) == ' ') {
					nextIndex = i;
					break;
				}
			}
			String Sid = msg.substring(index+1,nextIndex);
			String Smsg = msg.substring(nextIndex+1);
			ArrayList<S_TC> TCList = Analysis.getTCList();
			for(S_TC s : TCList) {
				s.send("/room chat "+Sid+">> "+Smsg);
			}
			
			break;
		case "battleList":
			nextIndex = 0;
			for(int i = index+1 ; i < msg.length() ; i++) {
				if(msg.charAt(i) == ' ') {
					nextIndex = i;
					break;
				}
			}
			String send_id = msg.substring(index+1,nextIndex);
			String select_id = msg.substring(nextIndex+1);
			DAO_BattleList DAO_b = DAO_BattleList.getInstance();
			ArrayList<DTO_BattleList> select_battleList = DAO_b.selectID_list(select_id);
			TC_listObject object = new TC_listObject();
			object.setPlayerID(select_id);
			for(DTO_BattleList b : select_battleList) {
				String[] battle = new String[3];
				if(b.getResult() == 1) {
					battle[0] = b.getMyID();
					battle[1] = "승";
					battle[2] = b.getOpponent();
					object.setWin();
				}else {
					battle[0] = b.getMyID();
					battle[1] = "패";
					battle[2] = b.getOpponent();
					object.setDefeat();
				}
				object.setAdd_battleLis(battle);
			}
			object.setServerMsg("/room");
			ArrayList<S_TC> TCList1 = Analysis.getTCList();
			for(S_TC s : TCList1) {
				if(s.getID().equals(send_id)) {
					s.list_O_send(object);
					break;
				}
			}
			break;
		}
		
	}

}
