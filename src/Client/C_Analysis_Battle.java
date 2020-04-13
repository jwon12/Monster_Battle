package Client;

public class C_Analysis_Battle {

	public void ckMsg(String msg) {
		int index = 0;
		for(int i = 0 ; i < msg.length() ; i++) {
			if(msg.charAt(i) == ' ') {
				index = i;
				break;
			}
		}
		
		
	}

}
