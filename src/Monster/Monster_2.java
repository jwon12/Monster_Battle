package Monster;

public class Monster_2 {
	private String originName = "꼬부기";
	private int Lv;
	private int attack;
	private int armor;
	private int totalP;
	
	public Monster_2(){
	}

	public void initset(int Lv) {
		this.Lv = Lv;
		attack = (Lv*1);
		armor = (Lv*2);
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
	
}
