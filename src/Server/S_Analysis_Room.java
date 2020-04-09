package Server;

import java.util.ArrayList;

public class S_Analysis_Room {
	
	S_Analysis Analysis = null;
	
	S_Analysis_Room(S_Analysis A_Sin){
		Analysis = A_Sin;
	}
	
	public void ckMsg(S_TC sin, String msg) {
		int index = 0;
		for (int i = 0; i < msg.length(); i++) {
			if (msg.charAt(i) == ' ') {
					index = i;
				break;
			}
		}
		String commend = msg.substring(0,index);
		System.out.println("room : "+commend);
		switch(commend) {
		case "chat":
			int nextIndex = 0;
			for(int i = index+1 ; i < msg.length() ; i++) {
				if(msg.charAt(i) == ' ') {
					nextIndex = i;
					break;
				}
			}
			String Sid = msg.substring(index+1,nextIndex);
			String Smsg = msg.substring(nextIndex+1);
			ArrayList<S_TC> TCList = Analysis.getTCList();
			for(S_TC s : TCList) {
				s.send("/room chat "+Sid+">> "+Smsg);
			}
			
			break;
		}
		
	}

}
