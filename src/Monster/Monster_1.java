package Monster;

public class Monster_1 extends Monster{
	private String originName = "이상해씨";
	private int Lv;
	private int attack;
	private int armor;
	private int totalP;
	private String property = "graff";
	private String img = "D:\\java_src\\Monster_Battle_ver0.0\\monster_img\\monster1.JPG";
	private String[][] skill = new String[4][3];
	
	public Monster_1(){
		skillsetting();
	}

	private void skillsetting() {
		skill[0][0] = "할퀴기"; // 스킬이름
		skill[0][1] = "70";   // 적중확률
		skill[0][2] = "2";    // 공격력 +2
		
		skill[1][0] = "덩쿨채찍"; 
		skill[1][1] = "60";   
		skill[1][2] = "3";
		
		skill[2][0] = "잎날가르기"; 
		skill[2][1] = "50";   
		skill[2][2] = "4";
		
		skill[3][0] = "솔라빔"; 
		skill[3][1] = "40";   
		skill[3][2] = "5";
	}

	public void initset(int Lv) {
		this.Lv = Lv;
		attack = (Lv*2);
		armor = (Lv*1);
		totalP = 20 + (Lv*1);
		
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
