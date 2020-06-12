package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SampleDAO {	
	Connection conn=null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rs=null;
	public static SampleDAO getLink=null;
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String uid = "system";
	String pass = "11111111";
	
	private SampleDAO(){
		
	}
	public static SampleDAO getInstance() {
		if(getLink ==null) {
			getLink = new SampleDAO();
		}
		return getLink;
	}
	private Connection getConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, uid, pass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}
	
	public SampleDTO getOne(String id) {
		SampleDTO newUser= new SampleDTO();
		try {
			String sql = "select * from sample where name=?"; // 여기추가
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); // pstmt 에서 stmt로 수정

			if (rs.next()) {
				newUser.setName(rs.getString("name"));
				newUser.setAge(rs.getInt("age"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} //finally의 끝
		
		return newUser;
	}

}
