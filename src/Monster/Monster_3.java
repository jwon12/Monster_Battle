package Monster;

public class Monster_3 {
	String originName = "이상해씨";
	String nickName;
	int Lv;
	int attack;
	int armor;
	int totalP = 20;
	
	Monster_3(String nickName,int Lv){
		this.nickName = nickName;
		this.Lv = Lv;
		initset();
	}

	private void initset() {
		attack = (Lv*1);
		armor = (Lv*1);
		totalP = 20 + (Lv*2);
	}
}
