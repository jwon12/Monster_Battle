package Client;

public class C_Analysis_Join {
	Frame_Join F_Join = null;
	
	public void ckMsg(String msg) {
		int index = 0;
		for(int i = 0 ; i < msg.length() ; i++) {
			if(msg.charAt(i) == ' ') {
				index = i;
				break;
			}
		}
		System.out.println(msg);
		String commend;
		if(index == 0) {
			commend = msg;
		}else {
			commend = msg.substring(0,index);			
		}
		switch(commend) {
		case "ckid":
			String booleanCk = msg.substring(index+1);
			if(booleanCk.equals("true")) {
				System.out.println("트트트트트트");
				F_Join.SuccessPopup();
			}else {
				F_Join.falsePopup();
			}
			break;
		case "joinSuccess":
			System.out.println("저장완료");
			F_Join.end();
			break;
		}
		
		
	}

	public void setF_Join(Frame_Join j) {
		F_Join = j;
		
	}

}
