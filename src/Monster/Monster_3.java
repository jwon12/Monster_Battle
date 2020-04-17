package Monster;

public class Monster_3 {
	private String originName = "이상해씨";
	private int Lv;
	private int attack;
	private int armor;
	private int totalP;

	public Monster_3() {

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
	
}
