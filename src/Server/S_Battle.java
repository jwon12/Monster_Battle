package Server;

import java.util.Random;

import Monster.Monster_1;
import Monster.Monster_2;
import Monster.Monster_3;

public class S_Battle {
	Random r = new Random();
	// palyer1 몬스터
	String player1_id;

	String[] player1_Monster_OriginName = new String[3];
	String[] player1_Monster_NickName = new String[3];
	int[] player1_Monster_Lv = new int[3];
	int[] player1_Monster_totalP = new int[3];
	int[] player1_Monster_nowP = new int[3];
	int[] player1_Monster_attack = new int[3];
	int[] player1_Monster_armor = new int[3];
	String[] player1_Monster_img = new String[3];

	// palyer2 몬스터
	String player2_id;

	String[] player2_Monster_OriginName = new String[3];
	String[] player2_Monster_NickName = new String[3];
	int[] player2_Monster_Lv = new int[3];
	int[] player2_Monster_totalP = new int[3];
	int[] player2_Monster_nowP = new int[3];
	int[] player2_Monster_attack = new int[3];
	int[] player2_Monster_armor = new int[3];
	String[] player2_Monster_img = new String[3];
	
	String player1_msg;
	String player2_msg;
	
	String order;
	
	String now_player1_Monster_OriginName;
	String now_player1_Monster_NickName;
	
	String now_player2_Monster_OriginName;
	String now_player2_Monster_NickName;

	S_Battle(String sendID, String reID) {
		
		this.player1_id = sendID;
		this.player2_id = reID;
		
		int s = r.nextInt(2);
		if (s == 0) {
			order = this.player1_id;
			player1_msg = "배틀 START \n"+this.player1_id+" 님이 공격할 차례입니다.";
			player2_msg = "배틀 START \n"+this.player1_id+" 님이 공격할 차례입니다.";
			
		}else {
			order = this.player2_id;
			player1_msg = "배틀 START \n"+this.player2_id+" 님이 공격할 차례입니다.";
			player2_msg = "배틀 START \n"+this.player2_id+" 님이 공격할 차레입니다.";
			
		}
	}
	
	public void init() {  // 몬스터 레벨에 따른 몬스터 어택,방어,체력 세팅...
		Monster_1 m1 = new Monster_1();
		Monster_2 m2 = new Monster_2();
		Monster_3 m3 = new Monster_3();
		for(int i = 0 ; i < 3 ; i++) {
			String m1_originName = m1.getOriginName();
			String m2_originName = m2.getOriginName();
			String m3_originName = m3.getOriginName();
			
			if(player1_Monster_OriginName[i].equals(m1_originName)) {
				m1.initset(player1_Monster_Lv[i]);
				player1_Monster_attack[i] = m1.getAttack();
				player1_Monster_armor[i] = m1.getArmor();
				player1_Monster_totalP[i] = m1.getTotalP();
				player1_Monster_nowP[i] = m1.getTotalP();
				player1_Monster_img[i] = m1.getImg();
			}else if(player1_Monster_OriginName[i].equals(m2_originName)) {
				m2.initset(player1_Monster_Lv[i]);
				player1_Monster_attack[i] = m2.getAttack();
				player1_Monster_armor[i] = m2.getArmor();
				player1_Monster_totalP[i] = m2.getTotalP();
				player1_Monster_nowP[i] = m2.getTotalP();
				player1_Monster_img[i] = m2.getImg();
			}else if(player1_Monster_OriginName[i].equals(m3_originName)) {
				m3.initset(player1_Monster_Lv[i]);
				player1_Monster_attack[i] = m3.getAttack();
				player1_Monster_armor[i] = m3.getArmor();
				player1_Monster_totalP[i] = m3.getTotalP();
				player1_Monster_nowP[i] = m3.getTotalP();
				player1_Monster_img[i] = m3.getImg();
			}
			
			
			if(player2_Monster_OriginName[i].equals(m1_originName)) {
				m1.initset(player2_Monster_Lv[i]);
				player2_Monster_attack[i] = m1.getAttack();
				player2_Monster_armor[i] = m1.getArmor();
				player2_Monster_totalP[i] = m1.getTotalP();
				player2_Monster_nowP[i] = m1.getTotalP();
				player2_Monster_img[i] = m1.getImg();
			}else if(player2_Monster_OriginName[i].equals(m2_originName)) {
				m2.initset(player2_Monster_Lv[i]);
				player2_Monster_attack[i] = m2.getAttack();
				player2_Monster_armor[i] = m2.getArmor();
				player2_Monster_totalP[i] = m2.getTotalP();
				player2_Monster_nowP[i] = m2.getTotalP();
				player2_Monster_img[i] = m2.getImg();
			}else if(player2_Monster_OriginName[i].equals(m3_originName)) {
				m3.initset(player2_Monster_Lv[i]);
				player2_Monster_attack[i] = m3.getAttack();
				player2_Monster_armor[i] = m3.getArmor();
				player2_Monster_totalP[i] = m3.getTotalP();
				player2_Monster_nowP[i] = m3.getTotalP();
				player2_Monster_img[i] = m3.getImg();
			}
			
			now_player1_Monster_OriginName = player1_Monster_OriginName[0];
			now_player1_Monster_NickName = player1_Monster_NickName[0];
			
			now_player2_Monster_OriginName = player2_Monster_OriginName[0];
			now_player2_Monster_NickName = player2_Monster_NickName[0];
		}
	}

}
