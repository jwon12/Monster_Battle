package Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO_Member implements DAO_Interface{
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	public static DAO_Member mySin = null;
	
	private DAO_Member(){
		init();
	}
	
	private void init() { 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 로드 실패:" + e.getMessage());
		}
	}

	private boolean connect() {
		boolean result = false;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "11111111");
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("연결 실패:" + e.getMessage());
		}
		return result;
	}
	
	@Override
	public void insert(Object o) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(Object o) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ArrayList<DTO_Member> selAll() {
		ArrayList<DTO_Member> MList = new ArrayList<>();
		String sql="select * from member";
		if(connect()) {
			try {
				stmt=conn.createStatement();
				if(stmt != null) {
					rs = stmt.executeQuery(sql); 
					while(rs.next()) {
						DTO_Member m = new DTO_Member();
						m.setId(rs.getString("id"));
						m.setPs(rs.getString("ps"));
						m.setNickname(rs.getString("nickname"));
						MList.add(m);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			System.out.println("DB연결 실패");
			System.exit(0);
		}
		return MList;
	}
	
	public static DAO_Member getInstance() {
		if(mySin == null) {
			mySin = new DAO_Member();
		}
		return mySin;
	}
	
	
}
