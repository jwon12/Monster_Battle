package Server;

public class S_Analysis {
	
	public static S_Analysis mySin = null;
	
	S_Analysis_Login A_Login = null;
	S_Analysis_Room  A_Room = null;
	S_Analysis_Battle A_Battle = null;
	
	
	
	S_Analysis(){
		A_Login = new S_Analysis_Login();
		A_Room = new S_Analysis_Room();
		A_Battle = new S_Analysis_Battle();
	}
	
	
	public static S_Analysis getInstance() {
		if(mySin == null) {
			mySin = new S_Analysis();
		}
		return mySin;
	}

	public void ckMsg(S_TC mySin2, String msg) {
		
		
	}
}
