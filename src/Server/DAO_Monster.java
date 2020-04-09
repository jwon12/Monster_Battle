package Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO_Monster implements DAO_Interface{
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	public static DAO_Monster mySin = null;
	
	private DAO_Monster(){
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
	public boolean insert(Object o) {
		boolean result = false;
		DTO_Monster DTO_MS = (DTO_Monster)o;
		if(connect()) {
			try {
				String sql = "insert into monster values( ? , ? , ? , ? )";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setString(1, DTO_MS.getId());
				pst.setString(2, DTO_MS.getNickname());
				pst.setString(3, DTO_MS.getOrigin());
				pst.setString(4, DTO_MS.getLv());
				
				int r = pst.executeUpdate();
				
				if(r > 0) {
					result = true;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return result;
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
	public Object selAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public static DAO_Monster getInstance() {
		if(mySin == null) {
			mySin = new DAO_Monster();
		}
		return mySin;
	}
}
