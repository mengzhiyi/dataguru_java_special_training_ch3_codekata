package agiledon.codekata.refactoring.templatemethod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractDao {
	private static final String DRIVER_CLASS = "";
	private static final String DB_URL = "";
	private static final String USER = "";
	private static final String PASSWORD = "";
	
	private static Connection conn = null;
	
	static {
		try {
			 Class.forName(DRIVER_CLASS);
			 conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/** 
     * 释放连接 
     * @param rs 
     * @param psmt 
     * @param conn 
     * @throws SQLException 
     */  
    public static void closeAll(ResultSet rs, PreparedStatement psmt, Connection conn) throws SQLException {  
          
        if(rs != null) {  
            rs.close();  
        }   
          
        if(psmt != null) {  
            psmt.close();  
        }  
          
        if(conn != null) {  
            conn.close();  
        }  
          
    }  
      
    /** 
     * 获取连接 
     * @return 
     */  
    public static Connection getConnection() {  
        return conn;  
    }  
    
}
