package Server;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

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
	public boolean insert(Object o) {
		boolean result = false;
		DTO_Member DTO_m = (DTO_Member)o;
		if(connect()) {
			try {
				String sql = "insert into member values( ? , ? , ? )";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setString(1, DTO_m.getId());
				pst.setString(2, DTO_m.getPs());
				pst.setString(3, DTO_m.getNickname());
				
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
