package Server;

import java.util.ArrayList;

public class S_Analysis_Battle {
	S_Analysis s = S_Analysis.getInstance();
	public void ckMsg(String msg) {
		int index = 0;
		for (int i = 0; i < msg.length(); i++) {
			if (msg.charAt(i) == ' ') {
					index = i;
				break;
			}
		}
		String commend = msg.substring(0,index);
		String tail = msg.substring(index+1);
		switch(commend) {
		case "apply":
			apply(tail);
			break;
		}
	}
	private void apply(String tail) {
		int index = 0;
		for (int i = 0; i < tail.length(); i++) {
			if (tail.charAt(i) == ' ') {
					index = i;
				break;
			}
		}
		String sendID = tail.substring(0,index);
		String reID = tail.substring(index+1);
		ArrayList<S_TC> TCList = s.getTCList();
		for(S_TC tc :TCList) {
			if(tc.getID().equals(reID)) {
				tc.send("/battle apply "+sendID+" "+reID);
				break;
			}
		}
	}

}
