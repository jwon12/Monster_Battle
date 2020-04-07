package Client;


import java.net.Socket;


public class C_Main {
	
	Socket withServer = null;
	
	C_Main() throws Exception{
		withServer = new Socket("10.0.0.109",8888);
		new C_TC(withServer);
	}
	
	
	
	
	public static void main(String[] args) throws Exception {
		new C_Main();

	}

}
