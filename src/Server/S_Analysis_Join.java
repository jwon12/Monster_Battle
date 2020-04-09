package Server;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class S_Analysis_Join {
	
	DAO_Member DAO_M = null;
	DAO_Monster DAO_MS = null;
	StringTokenizer ST;
	
	S_Analysis_Join(){
		DAO_M = DAO_Member.getInstance();
		DAO_MS = DAO_Monster.getInstance();
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
		msg = msg.substring(index+1);
		switch(commend) {
		case "ckid":
			ckid(msg,sin);
			break;
		case "saveId":
			saveId(msg,sin);
			break;
		case "saveMon":
			saveMon(msg,sin);
			break;
			
		}
		
	}
	
	private void saveMon(String msg, S_TC sin) {
		boolean ck = false;
		String save = msg;
		ST = new StringTokenizer(save," ");
		String id = ST.nextToken();
		
		String m1 = ST.nextToken();
		String m2 = ST.nextToken();
		String m3 = ST.nextToken();
		
		ST = new StringTokenizer(m1,"/");
		DTO_Monster d = new DTO_Monster();
		d.setId(id); d.setOrigin(ST.nextToken()); d.setNickname(ST.nextToken()); d.setLv("1");
		if(DAO_MS.insert(d)) {
			ck = true;
		}else {
			System.out.println("m1 저장 실패");
			return;
		}
		ST = new StringTokenizer(m2,"/");
		d = new DTO_Monster();
		d.setId(id); d.setOrigin(ST.nextToken()); d.setNickname(ST.nextToken()); d.setLv("1");
		if(DAO_MS.insert(d)) {
			ck = true;
		}else {
			ck = false;
			System.out.println("m2 저장 실패");
			return;
		}
		
		ST = new StringTokenizer(m3,"/");
		d = new DTO_Monster();
		d.setId(id); d.setOrigin(ST.nextToken()); d.setNickname(ST.nextToken()); d.setLv("1");
		if(DAO_MS.insert(d)) {
			ck = true;
		}else {
			ck = false;
			System.out.println("m3 저장 실패");
			return;
		}
		sin.send("/join joinSuccess");
	}
	private void saveId(String msg, S_TC sin) {
		String save = msg;
		ST = new StringTokenizer(save," ");
		String id = ST.nextToken();
		String pw = ST.nextToken();
		String nick = ST.nextToken();
		DTO_Member nowM = new DTO_Member();
		nowM.setId(id); nowM.setPs(pw); nowM.setNickname(nick);
		if(DAO_M.insert(nowM)) {
			sin.send("/server success");
		}else {
			sin.send("/server fail");
		}
		
	}
	private void ckid(String msg, S_TC sin) {
		
		String ckid = msg;
		ArrayList<DTO_Member> mList = DAO_M.selAll();
		for(DTO_Member m : mList) {
			if(m.getId().equals(ckid)) {
				sin.send("/join ckid false");
				return;
			}
		}
		sin.send("/join ckid true");
		
	}

}
