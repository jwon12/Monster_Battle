package Monster;

public class Monster_1 {
	String originName = "파이리";
	String nickName;
	int Lv;
	int attack;
	int armor;
	int totalP = 20;
	
	Monster_1(String nickName,int Lv){
		this.nickName = nickName;
		this.Lv = Lv;
		initset();
	}

	private void initset() {
		attack = (Lv*2);
		armor = (Lv*1);
		totalP = 20 + (Lv*1);
		
	}
	
	
	
}
