package Server;

import java.io.Serializable;

import javax.crypto.SecretKey;

public class TC_Object implements Serializable {
	// palyer1 몬스터
	private String player1_id;
	
	private String player1_Monster_OriginName;
	private String player1_Monster_NiceName;
	private int player1_Monster_Lv;
	private int player1_Monster_totalP;
	private int player1_Monster_nowP;
	private String player1_Monster_img;
	private String[] player1_Monster_Skill;
	
	// palyer2 몬스터
	private String player2_id;

	private String player2_Monster_OriginName;
	private String player2_Monster_NiceName;
	private int player2_Monster_Lv;
	private int player2_Monster_totalP;
	private int player2_Monster_nowP;
	private String player2_Monster_img;
	private String[] player2_Monster_Skill;

	
	private String player1_msg;
	private String player2_msg;
	
	private String Battle_order;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	public String getPlayer1_id() {
		return player1_id;
	}
	public void setPlayer1_id(String player1_id) {
		this.player1_id = player1_id;
	}
	public String getPlayer1_Monster_OriginName() {
		return player1_Monster_OriginName;
	}
	public void setPlayer1_Monster_OriginName(String player1_Monster_OriginName) {
		this.player1_Monster_OriginName = player1_Monster_OriginName;
	}
	public String getPlayer1_Monster_NiceName() {
		return player1_Monster_NiceName;
	}
	public void setPlayer1_Monster_NiceName(String player1_Monster_NiceName) {
		this.player1_Monster_NiceName = player1_Monster_NiceName;
	}
	public int getPlayer1_Monster_Lv() {
		return player1_Monster_Lv;
	}
	public void setPlayer1_Monster_Lv(int player1_Monster_Lv) {
		this.player1_Monster_Lv = player1_Monster_Lv;
	}
	public int getPlayer1_Monster_totalP() {
		return player1_Monster_totalP;
	}
	public void setPlayer1_Monster_totalP(int player1_Monster_totalP) {
		this.player1_Monster_totalP = player1_Monster_totalP;
	}
	public int getPlayer1_Monster_nowP() {
		return player1_Monster_nowP;
	}
	public void setPlayer1_Monster_nowP(int player1_Monster_nowP) {
		this.player1_Monster_nowP = player1_Monster_nowP;
	}
	public String getPlayer2_id() {
		return player2_id;
	}
	public void setPlayer2_id(String player2_id) {
		this.player2_id = player2_id;
	}
	public String getPlayer2_Monster_OriginName() {
		return player2_Monster_OriginName;
	}
	public void setPlayer2_Monster_OriginName(String player2_Monster_OriginName) {
		this.player2_Monster_OriginName = player2_Monster_OriginName;
	}
	public String getPlayer2_Monster_NiceName() {
		return player2_Monster_NiceName;
	}
	public void setPlayer2_Monster_NiceName(String player2_Monster_NiceName) {
		this.player2_Monster_NiceName = player2_Monster_NiceName;
	}
	public int getPlayer2_Monster_Lv() {
		return player2_Monster_Lv;
	}
	public void setPlayer2_Monster_Lv(int player2_Monster_Lv) {
		this.player2_Monster_Lv = player2_Monster_Lv;
	}
	public int getPlayer2_Monster_totalP() {
		return player2_Monster_totalP;
	}
	public void setPlayer2_Monster_totalP(int player2_Monster_totalP) {
		this.player2_Monster_totalP = player2_Monster_totalP;
	}
	public int getPlayer2_Monster_nowP() {
		return player2_Monster_nowP;
	}
	public void setPlayer2_Monster_nowP(int player2_Monster_nowP) {
		this.player2_Monster_nowP = player2_Monster_nowP;
	}
	public String getBattle_order() {
		return Battle_order;
	}
	public void setBattle_order(String battle_order) {
		Battle_order = battle_order;
	}
	public String getPlayer1_Monster_img() {
		return player1_Monster_img;
	}
	public void setPlayer1_Monster_img(String player1_Monster_img) {
		this.player1_Monster_img = player1_Monster_img;
	}
	public String[] getPlayer1_Monster_Skill() {
		return player1_Monster_Skill;
	}
	public void setPlayer1_Monster_Skill(String[] player1_Monster_Skill) {
		this.player1_Monster_Skill = player1_Monster_Skill;
	}
	public String getPlayer2_Monster_img() {
		return player2_Monster_img;
	}
	public void setPlayer2_Monster_img(String player2_Monster_img) {
		this.player2_Monster_img = player2_Monster_img;
	}
	public String[] getPlayer2_Monster_Skill() {
		return player2_Monster_Skill;
	}
	public void setPlayer2_Monster_Skill(String[] player2_Monster_Skill) {
		this.player2_Monster_Skill = player2_Monster_Skill;
	}
	public String getPlayer1_msg() {
		return player1_msg;
	}
	public void setPlayer1_msg(String player1_msg) {
		this.player1_msg = player1_msg;
	}
	public String getPlayer2_msg() {
		return player2_msg;
	}
	public void setPlayer2_msg(String player2_msg) {
		this.player2_msg = player2_msg;
	}
	
	
}
