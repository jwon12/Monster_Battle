package Server;

import java.util.ArrayList;

public class S_Analysis_Battle {
	S_Analysis s = null;
	ArrayList<S_Battle> battleList = new ArrayList<>();
	DAO_Monster DAO_sin = null;
	
	public void ckMsg(String msg) {
		s = S_Analysis.getInstance();
		int index = 0;
		for (int i = 0; i < msg.length(); i++) {
			if (msg.charAt(i) == ' ') {
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
		case "applytrue":
			applytrue(tail);
			break;
		case "applyfalse":
			applyfalse(tail);
			break;
			
		}
	}
	private void applyfalse(String tail) {
		int index = 0;
		for (int i = 0; i < tail.length(); i++) {
			if (tail.charAt(i) == ' ') {
					index = i;
				break;
			}
		}
		String sendID = tail.substring(0,index);
		String reID = tail.substring(index+1);
		ArrayList<S_TC> TCList = s.getTCList();
		for(S_TC tc :TCList) {
			if(tc.getID().equals(sendID)) {
				tc.send("/battle reject "+reID);
			}
		}
		
	}
	private void applytrue(String tail) {
		DAO_sin = DAO_Monster.getInstance();
		int index = 0;
		for (int i = 0; i < tail.length(); i++) {
			if (tail.charAt(i) == ' ') {
					index = i;
				break;
			}
		}
		String sendID = tail.substring(0,index);
		String reID = tail.substring(index+1);
		S_Battle battle = new S_Battle(sendID,reID);
		battleList.add(battle);
		
		battleSet(battle); // 배틀 클래스 세팅
		
		TC_Object object = TC_ObjectSet(battle); // 직력화 개체 세팅
		
		ArrayList<S_TC> TCList = s.getTCList();
		for(S_TC tc :TCList) {
			if(tc.getID().equals(reID)||tc.getID().equals(sendID)) {
				tc.send("/battle start "+sendID+" "+reID);
			}
		}
		
	}
	private TC_Object TC_ObjectSet(S_Battle battle) {
		TC_Object object = new TC_Object();
		
		
		
		return null;
	}
	
	
	private void battleSet(S_Battle battle) {
		int i = 0;
		int j = 0;
		ArrayList<DTO_Monster> mList = DAO_sin.selAll();
		for(DTO_Monster m : mList) {
			if(m.getId().equals(battle.player1_id)) {
				battle.player1_Monster_OriginName[i] = m.getOrigin();
				battle.player1_Monster_NickName[i] = m.getNickname();
				battle.player1_Monster_Lv[i] = m.getLv();
				i++;
			}else if(m.getId().equals(battle.player2_id)){
				battle.player2_Monster_OriginName[j] = m.getOrigin();
				battle.player2_Monster_NickName[j] = m.getNickname();
				battle.player2_Monster_Lv[j] = m.getLv();
				j++;
			}
		}
		battle.init();
		
	}
	private void apply(String tail) {
		int index = 0;
		for (int i = 0; i < tail.length(); i++) {
			if (tail.charAt(i) == ' ') {
					index = i;
				break;
			}
		}
		String sendID = tail.substring(0,index);
		String reID = tail.substring(index+1);
		ArrayList<S_TC> TCList = s.getTCList();
		for(S_TC tc :TCList) {
			if(tc.getID().equals(reID)) {
				tc.send("/battle apply "+sendID+" "+reID);
				break;
			}
		}
	}
}
