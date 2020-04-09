package Client;

public class C_Analysis_Room {
	Frame_Room F_Room = null;
	
	public void setF_Room(Frame_Room r) {
		F_Room = r;
	}

	public void ckMsg(String msg) {
		int index = 0;

		for (int i = 0; i < msg.length(); i++) {
			if (msg.charAt(i) == ' ') {
				index = i;
				break;
			}
		}
		System.out.println("접속자"+msg);
		
		String commend = msg.substring(0, index);
		
		switch(commend) {
		case "addmember":
			String nowid= msg.substring(index+1);
			if(!nowid.equals(F_Room.getMyID())) {
				F_Room.setaddId(nowid);				
			}
			break;
		case "chat":
			String idmsg = msg.substring(index+1);
			idmsg = idmsg+"\n";
			F_Room.setChat(idmsg);
			break;
			
		}
	}

}
