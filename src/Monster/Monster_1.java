package Monster;

public class Monster_1 extends Monster{
	private String originName = "이상해씨";
	private int Lv;
	private int attack;
	private int armor;
	private int totalP;
	private String img = "D:\\java_src\\Monster_Battle_ver0.0\\monster_img\\monster1.JPG";
	public Monster_1(){
		
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
	
	
	
}
