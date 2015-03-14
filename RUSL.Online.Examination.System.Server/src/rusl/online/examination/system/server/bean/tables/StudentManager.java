
package rusl.online.examination.system.server.bean.tables;

import java.sql.*;
import rusl.online.examination.system.server.bean.Admin;
import rusl.online.examination.system.server.bean.Student;
import rusl.online.examination.system.server.utility.ConnectionManager;
import rusl.online.examination.system.server.utility.Database;
import rusl.online.examination.system.server.utility.ResourceType;

public class StudentManager {
    public static boolean insertStudent(Student bean) {

        ResultSet keys = null;
        Connection con = null;
        PreparedStatement stmt = null;
        String sql  = "INSERT INTO students (stdname, marks, attempts, userName, password) VALUES (?, ?, ?, ?, ?);";
        try {
            con = ConnectionManager.getInstance().getConnection();
            stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, bean.getStudentName());
            stmt.setFloat(2, bean.getMarks());
            stmt.setInt(3, bean.getAttempts());
            stmt.setString(4, bean.getUserName());
            stmt.setString(5, bean.getPassword());

            int affected = stmt.executeUpdate();

            if (affected == 1){
                keys = stmt.getGeneratedKeys();
                keys.next();
                int key = keys.getInt(1);
                bean.setStudentId(key);
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

    public static Student getStudent(String username, String password) {

        ResultSet rs = null;
        Connection con = null;
        PreparedStatement stmt = null;
        //String sql  = "SELECT * FROM admins WHERE userName = ? AND password = ? LIMIT 1";
        String sql  = "SELECT * FROM students WHERE userName = ? AND password = ? LIMIT 1";

        try {
            con = ConnectionManager.getInstance().getConnection();
            stmt = con.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            rs = stmt.executeQuery();

            if(rs.next()) {
                Student bean = new Student();
                bean.setStudentId(rs.getInt("stdId"));
                bean.setStudentName(rs.getString("stdName"));
                bean.setMarks(rs.getFloat("marks"));
                bean.setAttempts(rs.getInt("attempts"));
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

    public static boolean updateMarks(float marks, int stdId) {
        ResultSet keys = null;
        Connection con = null;
        PreparedStatement stmt = null;
        String sql  = "UPDATE students SET marks = ? WHERE stdId = ?;";
        try {
            con = ConnectionManager.getInstance().getConnection();
            stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setFloat(1, marks);
            stmt.setInt(2, stdId);

            int affected = stmt.executeUpdate();

            if (affected == 1){
               return true;
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
    }

    public static Student getStudentById(int stdId) {
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement stmt = null;
        String sql  = "SELECT * FROM students WHERE stdId = ? LIMIT 1;";
        try {
            con = ConnectionManager.getInstance().getConnection();
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, stdId);

            rs = stmt.executeQuery();

            Student student = null;
            if( rs != null) {
                rs.next();
                student = new Student();
                student.setStudentId(rs.getInt("stdId"));
                student.setStudentName(rs.getString("stdName"));
                student.setMarks(rs.getFloat("marks"));
                student.setAttempts(rs.getInt("attempts"));
                student.setUserName(rs.getString("userName"));
                student.setPassword(rs.getString("password"));
            }
            return student;

        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.toString());
            System.err.println("Error: " + e.getMessage());
            System.err.println("SQL Err No: " + e.getErrorCode());
            System.err.println("SQL State: " + e.getSQLState());
            return null;
        } finally {
            Database.closeResourceConnection(ResourceType.RESULT_SET, rs);
            Database.closeResourceConnection(ResourceType.STATEMENT, stmt);
           // Database.closeResourceConnection(ResourceType.DATABASE_CONNECTION, con);
        }

    }
}
