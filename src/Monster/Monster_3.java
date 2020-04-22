package Monster;

public class Monster_3 extends Monster{
	private String originName = "파이리";
	private int Lv;
	private int attack;
	private int armor;
	private int totalP;
	private String property = "fire";
	private String img = "D:\\java_src\\Monster_Battle_ver0.0\\monster_img\\monster3.JPG";
	private String[][] skill = new String[4][3];
	

	public Monster_3() {
		skillsetting();
	}
	private void skillsetting() {
		skill[0][0] = "베어가르기"; // 스킬이름
		skill[0][1] = "70";   // 적중확률
		skill[0][2] = "2";    // 공격력 +2
		
		skill[1][0] = "열풍"; 
		skill[1][1] = "60";   
		skill[1][2] = "3";
		
		skill[2][0] = "화염방사"; 
		skill[2][1] = "50";   
		skill[2][2] = "4";
		
		skill[3][0] = "드래곤 크루"; 
		skill[3][1] = "40";   
		skill[3][2] = "5";
	}

	public void initset(int Lv) {
		this.Lv = Lv;
		attack = (Lv * 1);
		armor = (Lv * 1);
		totalP = 20 + (Lv * 2);
	}
	
	public int getTotalP() {
		return totalP;
	}
	
	public String getOriginName() {
		return originName;
	}

	public int getAttack() {
		return attack;
	}

	public int getArmor() {
		return armor;
	}
	public String getImg() {
		return img;
	}
	public String[][] getSkill() {
		return skill;
	}
	public String getProperty() {
		return property;
	}
}
