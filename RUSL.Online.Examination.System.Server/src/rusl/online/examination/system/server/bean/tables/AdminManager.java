
package rusl.online.examination.system.server.bean.tables;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import rusl.online.examination.system.server.bean.Admin;
import rusl.online.examination.system.server.utility.ConnectionManager;
import rusl.online.examination.system.server.utility.Database;
import rusl.online.examination.system.server.utility.ResourceType;

public class AdminManager {
    
    public static boolean insertAdmin(Admin bean) {
        
        ResultSet keys = null;
        Connection con = null;
        PreparedStatement stmt = null;
        String sql  = "INSERT INTO admins (adminName, userName, password) VALUES (?, ?, ?);";
        try {
            con = ConnectionManager.getInstance().getConnection();
            stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, bean.getAdminName());
            stmt.setString(2, bean.getUserName());
            stmt.setString(3, bean.getPassword());
            
            int affected = stmt.executeUpdate();
            
            if (affected == 1){
                keys = stmt.getGeneratedKeys();
                keys.next();
                int key = keys.getInt(1);
                bean.setAdminId(key);
            } else {
                System.err.println("No fields affected!.");
                return false;
            }    
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.toString());
            System.err.println("Error: " + e.getMessage());
            System.err.println("SQL Err No: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            return false;    
        } finally {
            Database.closeResourceConnection(ResourceType.RESULT_SET, keys);
            Database.closeResourceConnection(ResourceType.STATEMENT, stmt);
           // Database.closeResourceConnection(ResourceType.DATABASE_CONNECTION, con);
        }
        return true;
    }
    
    public static Admin getAdmin(String username, String password) {
        
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement stmt = null;
        //String sql  = "SELECT * FROM admins WHERE userName = ? AND password = ? LIMIT 1";
        String sql  = "SELECT * FROM admins WHERE userName = ?" +
                " AND password = ? LIMIT 1";
        
        try {
            con = ConnectionManager.getInstance().getConnection();
            stmt = con.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            
            if(rs.next()) {
                Admin bean = new Admin();
                bean.setAdminId(rs.getInt("adminId"));
                bean.setAdminName(rs.getString("adminName"));
                bean.setUserName(rs.getString("userName"));
                bean.setPassword(rs.getString("password"));
                System.out.println("Admin Returned");
                return bean;
            } else {
                return null;
            }
                
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.toString());
            System.err.println("Error: " + e.getMessage());
            System.err.println("SQL Err No: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
        } finally {
            Database.closeResourceConnection(ResourceType.RESULT_SET, rs);
            Database.closeResourceConnection(ResourceType.STATEMENT, stmt);
        }
        
        return null;
    }
}
