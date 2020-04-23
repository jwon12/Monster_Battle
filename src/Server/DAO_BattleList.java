package Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO_BattleList implements DAO_Interface{
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	public static DAO_BattleList mySin = null;
	
	private DAO_BattleList(){
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
		DTO_BattleList DTO_b = (DTO_BattleList)o;
		if(connect()) {
			try {
				String sql = "insert into battlelist values( ? , ? , ? )";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setString(1, DTO_b.getMyID());
				pst.setInt(2, DTO_b.getResult());
				pst.setString(3, DTO_b.getOpponent());
				
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
	
	public ArrayList<DTO_BattleList> selectID_list(String id) {
		ArrayList<DTO_BattleList> BattleList = new ArrayList<>();
		String sql="select * from battleList where id = '"+id+"'";
		if(connect()) {
			try {
				stmt=conn.createStatement();
				if(stmt != null) {
					rs = stmt.executeQuery(sql); 
					while(rs.next()) {
						DTO_BattleList b = new DTO_BattleList();
						b.setMyID(rs.getString("id"));
						b.setResult(rs.getInt("result"));
						b.setOpponent(rs.getString("opponent"));
						BattleList.add(b);
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
		return BattleList;
	}
	@Override
	public ArrayList<DTO_BattleList> selAll() {
		ArrayList<DTO_BattleList> BattleList = new ArrayList<>();
		String sql="select * from battleList";
		if(connect()) {
			try {
				stmt=conn.createStatement();
				if(stmt != null) {
					rs = stmt.executeQuery(sql); 
					while(rs.next()) {
						DTO_BattleList b = new DTO_BattleList();
						b.setMyID(rs.getString("id"));
						b.setResult(rs.getInt("result"));
						b.setOpponent(rs.getString("opponent"));
						BattleList.add(b);
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
		return BattleList;
	}
	
	public static DAO_BattleList getInstance() {
		if(mySin == null) {
			mySin = new DAO_BattleList();
		}
		return mySin;
	}
}
