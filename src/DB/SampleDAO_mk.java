package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SampleDAO_mk {	
	Connection conn=null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rs=null;
	public static SampleDAO_mk DAOobj=null;
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String uid = "system";
	String pass = "11111111";
	
	private SampleDAO_mk(){
		
	}
	public static SampleDAO_mk getInstance() {
		if( DAOobj ==null) {
			 DAOobj = new SampleDAO_mk();
		}
		return  DAOobj;
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
	
	public SampleDTO_mk getOne(String id) {
		SampleDTO_mk newUser= new SampleDTO_mk();
		try {
			String sql = "select * from sample where name=?"; // 여기추가
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); // pstmt 에서 stmt로 수정

			if (rs.next()) {
				newUser.setName(rs.getString("name"));
				newUser.setId(rs.getString("id"));
				newUser.setPwd(rs.getString("pwd"));
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
