package Client;


import java.net.Socket;


public class C_Main {
	//띠영
	
	Socket withServer = null;
	Socket withObjectServer = null;
	Socket withlistObjectServer = null;
	
	C_Main() throws Exception{
		withServer = new Socket("10.0.0.109",9999);
		Thread.sleep(1000);
		withObjectServer = new Socket("10.0.0.109",9998);
		Thread.sleep(1000);
		withlistObjectServer = new Socket("10.0.0.109",9997);
		new C_TC(withServer,withObjectServer,withlistObjectServer);
	}
	
	
	
	
	public static void main(String[] args) throws Exception {
		new C_Main();

	}

}
