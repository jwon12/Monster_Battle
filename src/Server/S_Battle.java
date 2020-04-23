package Server;

import java.util.Random;

import Monster.Monster_1;
import Monster.Monster_2;
import Monster.Monster_3;
import Monster.Monster_4;

public class S_Battle {
	Random r = new Random();
	Monster_1 m1 = null;
	Monster_2 m2 = null;
	Monster_3 m3 = null;
	Monster_4 m4 = null;
	// palyer1 몬스터
	String player1_id;

	String[] player1_Monster_OriginName = new String[3];
	String[] player1_Monster_NickName = new String[3];
	int[] player1_Monster_Lv = new int[3];
	int[] player1_Monster_totalP = new int[3];
	int[] player1_Monster_nowP = new int[3];
	int[] player1_Monster_attack = new int[3];
	int[] player1_Monster_armor = new int[3];
	String[] player1_Monster_property = new String[3];
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
	String[] player2_Monster_property = new String[3];
	String[] player2_Monster_img = new String[3];

	String player1_msg;
	String player2_msg;

	String order;

	String now_player1_Monster_OriginName;
	String now_player1_Monster_NickName;
	String[][] now_player1_Monster_Skill;

	String now_player2_Monster_OriginName;
	String now_player2_Monster_NickName;
	String[][] now_player2_Monster_Skill;
	
	String victory;

	S_Battle(String sendID, String reID) {

		this.player1_id = sendID;
		this.player2_id = reID;

		int s = r.nextInt(2);
		if (s == 0) {
			order = this.player1_id;
			player1_msg = "배틀 START \n" + this.player1_id + " 님이 공격할 차례입니다.";
			player2_msg = "배틀 START \n" + this.player1_id + " 님이 공격할 차례입니다.";

		} else {
			order = this.player2_id;
			player1_msg = "배틀 START \n" + this.player2_id + " 님이 공격할 차례입니다.";
			player2_msg = "배틀 START \n" + this.player2_id + " 님이 공격할 차레입니다.";

		}
	}

	public void init() { // 몬스터 레벨에 따른 몬스터 어택,방어,체력 세팅...
		m1 = new Monster_1();
		m2 = new Monster_2();
		m3 = new Monster_3();
		m4 = new Monster_4();
		for (int i = 0; i < 3; i++) {
			String m1_originName = m1.getOriginName();
			String m2_originName = m2.getOriginName();
			String m3_originName = m3.getOriginName();
			String m4_originName = m4.getOriginName();

			if (player1_Monster_OriginName[i].equals(m1_originName)) {
				m1.initset(player1_Monster_Lv[i]);
				player1_Monster_attack[i] = m1.getAttack();
				player1_Monster_armor[i] = m1.getArmor();
				player1_Monster_totalP[i] = m1.getTotalP();
				player1_Monster_nowP[i] = m1.getTotalP();
				player1_Monster_img[i] = m1.getImg();
				player1_Monster_property[i] = m1.getProperty();
			} else if (player1_Monster_OriginName[i].equals(m2_originName)) {
				m2.initset(player1_Monster_Lv[i]);
				player1_Monster_attack[i] = m2.getAttack();
				player1_Monster_armor[i] = m2.getArmor();
				player1_Monster_totalP[i] = m2.getTotalP();
				player1_Monster_nowP[i] = m2.getTotalP();
				player1_Monster_img[i] = m2.getImg();
				player1_Monster_property[i] = m2.getProperty();
			} else if (player1_Monster_OriginName[i].equals(m3_originName)) {
				m3.initset(player1_Monster_Lv[i]);
				player1_Monster_attack[i] = m3.getAttack();
				player1_Monster_armor[i] = m3.getArmor();
				player1_Monster_totalP[i] = m3.getTotalP();
				player1_Monster_nowP[i] = m3.getTotalP();
				player1_Monster_img[i] = m3.getImg();
				player1_Monster_property[i] = m3.getProperty();
			} else if (player1_Monster_OriginName[i].equals(m4_originName)) {
				m4.initset(player1_Monster_Lv[i]);
				player1_Monster_attack[i] = m4.getAttack();
				player1_Monster_armor[i] = m4.getArmor();
				player1_Monster_totalP[i] = m4.getTotalP();
				player1_Monster_nowP[i] = m4.getTotalP();
				player1_Monster_img[i] = m4.getImg();
				player1_Monster_property[i] = m4.getProperty();
			}

			if (player2_Monster_OriginName[i].equals(m1_originName)) {
				m1.initset(player2_Monster_Lv[i]);
				player2_Monster_attack[i] = m1.getAttack();
				player2_Monster_armor[i] = m1.getArmor();
				player2_Monster_totalP[i] = m1.getTotalP();
				player2_Monster_nowP[i] = m1.getTotalP();
				player2_Monster_img[i] = m1.getImg();
				player2_Monster_property[i] = m1.getProperty();
			} else if (player2_Monster_OriginName[i].equals(m2_originName)) {
				m2.initset(player2_Monster_Lv[i]);
				player2_Monster_attack[i] = m2.getAttack();
				player2_Monster_armor[i] = m2.getArmor();
				player2_Monster_totalP[i] = m2.getTotalP();
				player2_Monster_nowP[i] = m2.getTotalP();
				player2_Monster_img[i] = m2.getImg();
				player2_Monster_property[i] = m2.getProperty();
			} else if (player2_Monster_OriginName[i].equals(m3_originName)) {
				m3.initset(player2_Monster_Lv[i]);
				player2_Monster_attack[i] = m3.getAttack();
				player2_Monster_armor[i] = m3.getArmor();
				player2_Monster_totalP[i] = m3.getTotalP();
				player2_Monster_nowP[i] = m3.getTotalP();
				player2_Monster_img[i] = m3.getImg();
				player2_Monster_property[i] = m3.getProperty();
			} else if (player2_Monster_OriginName[i].equals(m4_originName)) {
				m4.initset(player2_Monster_Lv[i]);
				player2_Monster_attack[i] = m4.getAttack();
				player2_Monster_armor[i] = m4.getArmor();
				player2_Monster_totalP[i] = m4.getTotalP();
				player2_Monster_nowP[i] = m4.getTotalP();
				player2_Monster_img[i] = m4.getImg();
				player2_Monster_property[i] = m4.getProperty();
			}

			now_player1_Monster_OriginName = player1_Monster_OriginName[0];
			now_player1_Monster_NickName = player1_Monster_NickName[0];
			
			now_player2_Monster_OriginName = player2_Monster_OriginName[0];
			now_player2_Monster_NickName = player2_Monster_NickName[0];
			settingSkill();
		}
	}
	public void settingSkill() {
		if(now_player1_Monster_OriginName.equals(m1.getOriginName())) {
			now_player1_Monster_Skill = m1.getSkill();
		}else if(now_player1_Monster_OriginName.equals(m2.getOriginName())) {
			now_player1_Monster_Skill = m2.getSkill();
		}else if(now_player1_Monster_OriginName.equals(m3.getOriginName())) {
			now_player1_Monster_Skill = m3.getSkill();
		}else if(now_player1_Monster_OriginName.equals(m4.getOriginName())) {
			now_player1_Monster_Skill = m4.getSkill();
		}
		
		if(now_player2_Monster_OriginName.equals(m1.getOriginName())) {
			now_player2_Monster_Skill = m1.getSkill();
		}else if(now_player2_Monster_OriginName.equals(m2.getOriginName())) {
			now_player2_Monster_Skill = m2.getSkill();
		}else if(now_player2_Monster_OriginName.equals(m3.getOriginName())) {
			now_player2_Monster_Skill = m3.getSkill();
		}else if(now_player2_Monster_OriginName.equals(m4.getOriginName())) {
			now_player2_Monster_Skill = m4.getSkill();
		}

	}

}
