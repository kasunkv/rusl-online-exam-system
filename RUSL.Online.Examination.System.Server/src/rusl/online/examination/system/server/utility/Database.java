
package rusl.online.examination.system.server.utility;

import java.sql.*;
import rusl.online.examination.system.client.utility.Answer;

public class Database {
    private static final String USER = "root";
    private static final String PASS = "";
    private static final String DB_STRING = "jdbc:mysql://localhost/ruslexamsystem";
    
    // Create the database connection  
    public static Connection getConnection() throws SQLException {       
        return DriverManager.getConnection(DB_STRING, USER, PASS);
    }
    
    // close any resource connection
    public static void closeResourceConnection(ResourceType type, Object obj) {
        try {
             switch(type) {
                case DATABASE_CONNECTION:
                    Connection con = (Connection)obj;
                    if (con != null ) {
                        con.close();
                    }
                    break;
                case RESULT_SET:
                    ResultSet rs = (ResultSet)obj;
                    if (rs != null) {
                        rs.close();
                    }
                    break;
                case STATEMENT:
                    Statement stmt = (Statement)obj;
                    if (stmt != null) {
                        stmt.close();
                    }
                    break;
            }   
        } catch (SQLException e) {
            Database.displayError(e);
        }
        
    }
    
    // Display Meaningfull Error Message
    public static void displayError(SQLException e) {
        System.out.println("Error Message: " + e.getMessage());
        System.out.println("Error Code: " + e.getErrorCode());
        System.out.println("SQL Error: " + e.getSQLState());        
    }
    
    // use sql query as a parameter and return the result set (Statement)
    public static ResultSet runStatementQuery(String sql) throws SQLException {
        Statement stmt = (Database.getConnection()).createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);        
        return stmt.executeQuery(sql);
    } 
    
    // use sql query as a parameter and return the result set (PreparedStatement)
    public static ResultSet runPreparedStatementQuery(String sql) throws SQLException {
        PreparedStatement stmt = (Database.getConnection()).prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);        
        return stmt.executeQuery();     
    }
    
    public static boolean isAnswerCorrect(Answer ans) {
        
        
        return true;
    }
}
