package Monster;

public class Monster_1 {
	private String originName = "파이리";
	private int Lv;
	private int attack;
	private int armor;
	private int totalP;
	
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
	
	
	
}
