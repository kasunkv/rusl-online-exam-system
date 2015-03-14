/* ----------------------------------------------------------------------------------------
 *      Singleton Class (ConnectionManager) - Design Pattern for Java - Only One Instance
 * ----------------------------------------------------------------------------------------
 * 
 * To use the ConnectionManager class first in the Main method of the application
 * at the begining set the DBType as the appropriate database type.
 *  Eg:- ConnectionManager.getInstance.setDbType(DBType.MYSQL);
 * 
 * Then after the last code line in main(End of the program) call the static method 
 * close() to close the connections.
 *  Eg:- ConnectionManager.getInstance.close();
 * 
 * To use the connection returned form the ConnectionManager, where ever the code create
 * a new database connection (actually to avoid is the useage of the class)
 *  Eg:- ConnectionManager.getInstance.getConnection();
 */

package rusl.online.examination.system.server.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    // private instance of itself..
    private static ConnectionManager instance = null;
    
    // database credentials and path
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String DB_PATH_MYSQL = "jdbc:mysql://localhost/ruslexamsystem";
    
    // database connection to be returned
    private static Connection conn = null;
    
    // select the database type
    private static DBType dbType = DBType.MSSQL;
    
    // private constructor to prevent out side instansiations
    private ConnectionManager() {        
    }
    
    // create an isntance of the connectionManager if not created
    public static ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();            
        }
        return instance;
    }
    
    // set the database type
    public void setDbType(DBType dbType) {
        this.dbType = dbType;
    }
    
    // select db type and open the connection(Only used within the class)
    private boolean openConnection() {
        try {
                switch (dbType) {
                    case MYSQL:
                        conn = DriverManager.getConnection(DB_PATH_MYSQL, USER, PASSWORD);
                        return true;
                    case HSQLDB:
                        conn = DriverManager.getConnection(DB_PATH_MYSQL, USER, PASSWORD);
                        return true;
                    case MSSQL:
                        conn = DriverManager.getConnection(DB_PATH_MYSQL, USER, PASSWORD);
                        return true;
                    default:
                        return false;                
                }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }
    
    // get the connection to the out
    public Connection getConnection() {
        if (conn == null) {
            if (openConnection()) {
                System.out.println("Connection Opened!");
                return conn;
            } else {
                return null;
            }
        }
        return conn;
    }
    
    // close the connection
    public void closeConnection() {
        System.out.println("Connection Closing!");
        try {
                conn.close();
                conn = null;
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    
}
