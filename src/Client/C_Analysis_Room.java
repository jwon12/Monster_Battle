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
		
		String fist = msg.substring(0, index);
		String second= msg.substring(index+1);
		
		switch(fist) {
		case "addmember":
			F_Room.setaddId(second);
			break;
		}
	}

}
