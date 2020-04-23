package Server;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class S_Analysis_Login {

	DAO_Member DAO_M = null;
	ArrayList<DTO_Member> mList = null;

	public S_Analysis_Login() {
		DAO_M = DAO_Member.getInstance();
	}

	public String Ck_IDPS(String idPs) {
		String idNickname = null;
		mList = DAO_M.selAll();
		StringTokenizer ST = new StringTokenizer(idPs, " ");
		String id = ST.nextToken();
		String pw = ST.nextToken();
		
		for(DTO_Member m : mList) {
			if(m.getId().equals(id) && m.getPs().equals(pw)) {
				String nickName = m.getNickname();
				idNickname = id+" "+nickName;
				return idNickname;
			}
		}
		return null;
	}

	public boolean ck_comeIn(String second, ArrayList<String> idList) {
		int index = 0;
		for(int i = 0 ; i < second.length() ; i++) {
			if(second.charAt(i) == ' ') {
				index = i;
			}
		}
		String id = second.substring(0,index);
		for(String comeIn_id : idList) {
			if(comeIn_id.equals(id)){
				return false;
			}
		}
		
		return true;
	}

}
