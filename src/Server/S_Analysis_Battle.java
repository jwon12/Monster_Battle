package Server;

import java.util.ArrayList;
import java.util.Random;

public class S_Analysis_Battle {
	S_Analysis s = null;
	ArrayList<S_Battle> battleList = new ArrayList<>();
	DAO_Monster DAO_sin = null;
	Random r = new Random();
	
	public void ckMsg(String msg){
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
		case "In_battle":
			in_battle(tail);
			break;
		}
	}
	private void in_battle(String tail) {
		int index = 0;
		for (int i = 0; i < tail.length(); i++) {
			if (tail.charAt(i) == ' ') {
					index = i;
				break;
			}
		}
		String commend = tail.substring(0,index);
		tail = tail.substring(index+1);
		switch(commend) {
		case "attack":
			attack(tail);
			break;
		}
		
	}
	private void attack(String tail) {
		int index = 0;
		for (int i = 0; i < tail.length(); i++) {
			if (tail.charAt(i) == ' ') {
				index = i;
				break;
			}
		}
		String attackID = tail.substring(0,index);
		String reID = tail.substring(index+1);
		S_Battle nowBattle = null;
		for(S_Battle b :battleList) {
			if((b.player1_id.equals(attackID) && b.player2_id.equals(reID))
					|| (b.player1_id.equals(reID) && b.player2_id.equals(attackID))) {
				nowBattle = b;
				break;
			}
		}
		int j = r.nextInt(10);
		if(j != 0) {
			if(nowBattle.player1_id.equals(attackID)) {
				int player1_M_number = 0;
				int player2_M_number = 0;
				for(int i = 0; i < nowBattle.now_player1_Monster_OriginName.length(); i++) {
					if(nowBattle.player1_Monster_OriginName[i].equals(nowBattle.now_player1_Monster_OriginName)) {
						player1_M_number = i;
						break;
					}
				}
				for(int i = 0; i < nowBattle.now_player2_Monster_OriginName.length(); i++) {
					if(nowBattle.player2_Monster_OriginName[i].equals(nowBattle.now_player2_Monster_OriginName)) {
						player2_M_number = i;
						break;
					}
				}
				int player1_M_attack = nowBattle.player1_Monster_attack[player1_M_number];
				int player2_M_armor = nowBattle.player2_Monster_armor[player2_M_number];
				int count = player1_M_attack - player2_M_armor;
				if(count > 0) {
					nowBattle.player2_Monster_nowP[player2_M_number] = nowBattle.player2_Monster_nowP[player2_M_number] - count;
					nowBattle.player2_msg = nowBattle.now_player1_Monster_NickName+" 에게 \n"+"공격 "+String.valueOf(count)+" 만큼의 데미지를 받았습니다.";
					nowBattle.player1_msg = nowBattle.now_player2_Monster_NickName+" 에게 \n"+"공격 "+String.valueOf(count)+" 만큼의 데미지를 줬습니다.";
					nowBattle.order = reID;
				}else {
					nowBattle.player2_Monster_nowP[player2_M_number] = nowBattle.player2_Monster_nowP[player2_M_number] - 1;
					nowBattle.player2_msg = nowBattle.now_player1_Monster_NickName+" 에게 \n"+"공격 "+String.valueOf(1)+" 만큼의 데미지를 받았습니다.";
					nowBattle.player1_msg = nowBattle.now_player2_Monster_NickName+" 에게 \n"+"공격 "+String.valueOf(1)+" 만큼의 데미지를 줬습니다.";
					nowBattle.order = reID;
				}
			}else {
				//플레이어2가 공격 한경우
				
				int player1_M_number = 0;
				int player2_M_number = 0;
				for(int i = 0; i < nowBattle.now_player1_Monster_OriginName.length(); i++) {
					if(nowBattle.player1_Monster_OriginName[i].equals(nowBattle.now_player1_Monster_OriginName)) {
						player1_M_number = i;
						break;
					}
				}
				for(int i = 0; i < nowBattle.now_player2_Monster_OriginName.length(); i++) {
					if(nowBattle.player2_Monster_OriginName[i].equals(nowBattle.now_player2_Monster_OriginName)) {
						player2_M_number = i;
						break;
					}
				}
				int player2_M_attack = nowBattle.player2_Monster_attack[player2_M_number];
				int player1_M_armor = nowBattle.player1_Monster_armor[player1_M_number];
				int count = player2_M_attack - player1_M_armor;
				if(count > 0) {
					nowBattle.player1_Monster_nowP[player1_M_number] = nowBattle.player1_Monster_nowP[player1_M_number] - count;
					nowBattle.player1_msg = nowBattle.now_player2_Monster_NickName+" 에게 \n"+"공격 "+String.valueOf(count)+" 만큼의 데미지를 받았습니다.";
					nowBattle.player2_msg = nowBattle.now_player1_Monster_NickName+" 에게 \n"+"공격 "+String.valueOf(count)+" 만큼의 데미지를 줬습니다.";
					nowBattle.order = reID;
				}else {
					nowBattle.player1_Monster_nowP[player2_M_number] = nowBattle.player1_Monster_nowP[player2_M_number] - 1;
					nowBattle.player1_msg = nowBattle.now_player2_Monster_NickName+" 에게 \n"+"공격 "+String.valueOf(1)+" 만큼의 데미지를 받았습니다.";
					nowBattle.player2_msg = nowBattle.now_player1_Monster_NickName+" 에게 \n"+"공격 "+String.valueOf(1)+" 만큼의 데미지를 줬습니다.";
					nowBattle.order = reID;
				}
			}
		}else {
			if(nowBattle.player1_id.equals(attackID)) {
				nowBattle.order = reID;
				nowBattle.player1_msg = nowBattle.now_player1_Monster_NickName+" 가 \n공격에 실패하였습니다.";
				nowBattle.player2_msg = nowBattle.now_player1_Monster_NickName+" 가 \n공격에 실패하였습니다.";
			}else {
				nowBattle.order = reID;
				nowBattle.player1_msg = nowBattle.now_player2_Monster_NickName+" 가 \n공격에 실패하였습니다.";
				nowBattle.player2_msg = nowBattle.now_player2_Monster_NickName+" 가 \n공격에 실패하였습니다.";
			}
			
		}
		TC_Object object = TC_ObjectSet(nowBattle);
		ArrayList<S_TC> TCList = s.getTCList();
		for(S_TC s :TCList) {
			if(s.getID().equals(attackID) || s.getID().equals(reID)) {
				s.O_send(object);
			}
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
				tc.O_send(object);
			}
		}
		
	}
	private TC_Object TC_ObjectSet(S_Battle battle) {
		TC_Object object = new TC_Object();
		
		object.setPlayer1_id(battle.player1_id);
		object.setPlayer1_Monster_OriginName(battle.now_player1_Monster_OriginName);
		object.setPlayer1_Monster_NiceName(battle.now_player1_Monster_NickName);
		
		for(int i = 0 ; i < battle.player1_Monster_OriginName.length ; i++) {
			if(battle.now_player1_Monster_OriginName.equals(battle.player1_Monster_OriginName[i])){
				object.setPlayer1_Monster_Lv(battle.player1_Monster_Lv[i]);
				object.setPlayer1_Monster_totalP(battle.player1_Monster_totalP[i]);
				object.setPlayer1_Monster_nowP(battle.player1_Monster_nowP[i]);
				object.setPlayer1_Monster_img(battle.player1_Monster_img[i]);
				break;
			}
		}
		
		object.setPlayer2_id(battle.player2_id);
		object.setPlayer2_Monster_OriginName(battle.now_player2_Monster_OriginName);
		object.setPlayer2_Monster_NiceName(battle.now_player2_Monster_NickName);
		
		for(int i = 0 ; i < battle.player2_Monster_OriginName.length ; i++) {
			if(battle.now_player2_Monster_OriginName.equals(battle.player2_Monster_OriginName[i])){
				object.setPlayer2_Monster_Lv(battle.player2_Monster_Lv[i]);
				object.setPlayer2_Monster_totalP(battle.player2_Monster_totalP[i]);
				object.setPlayer2_Monster_nowP(battle.player2_Monster_nowP[i]);
				object.setPlayer2_Monster_img(battle.player2_Monster_img[i]);
				break;
			}
		}
		
		object.setBattle_order(battle.order);
		object.setPlayer1_msg(battle.player1_msg);
		object.setPlayer2_msg(battle.player2_msg);
		
		return object;
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
