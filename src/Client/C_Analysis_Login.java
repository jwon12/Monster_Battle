package Client;

import java.util.StringTokenizer;

public class C_Analysis_Login {
	
	Frame_Login F_Login_Sin = null;
	
	public void setF_Login(Frame_Login f) {
		F_Login_Sin = f;
	}
	public void ckMsg(String msg) {
		StringTokenizer ST = new StringTokenizer(msg," ");
		String booleanCK = ST.nextToken();
		if(booleanCK.equals("true")) {
			C_Analysis a = C_Analysis.getInstance();			
			String id = ST.nextToken();
			String nickName = ST.nextToken();
			a.setId(id);
			F_Login_Sin.showPopup("로그인 되었습니다.");
			F_Login_Sin.createRoom(id,nickName);
		}else if(booleanCK.equals("false")){
			F_Login_Sin.showPopup("아이디,패스워드가 맞지않습니다.");
		}else if(booleanCK.equals("falseID")) {
			F_Login_Sin.showPopup("해당 아이디는 이미 접속해 있습니다.");
		}
			
	}

}
