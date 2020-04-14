package Monster;

public class Monster_2 {
	String originName = "꼬부기";
	String nickName;
	int Lv;
	int attack;
	int armor;
	int totalP = 20;
	
	Monster_2(String nickName,int Lv){
		this.nickName = nickName;
		this.Lv = Lv;
		initset();
	}

	private void initset() {
		attack = (Lv*1);
		armor = (Lv*2);
		totalP = 20 + (Lv*1);
		
	}
}
