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

}
