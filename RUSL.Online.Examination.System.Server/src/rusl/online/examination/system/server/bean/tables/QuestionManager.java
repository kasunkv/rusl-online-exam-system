
package rusl.online.examination.system.server.bean.tables;

import java.sql.*;
import java.util.LinkedList;
import rusl.online.examination.system.server.bean.Question;
import rusl.online.examination.system.server.utility.ConnectionManager;
import rusl.online.examination.system.server.utility.Database;
import rusl.online.examination.system.server.utility.ResourceType;

public class QuestionManager {
    
    public static boolean insertQuestion(Question bean) {
        
        ResultSet keys = null;
        Connection con = null;
        PreparedStatement stmt = null;
        String sql  = "INSERT INTO questions (question, answer1, answer2, answer3, answer4, correctAns) VALUES (?, ?, ?, ?, ?, ?);";
        try {
            con = ConnectionManager.getInstance().getConnection();
            stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, bean.getQuestion());
            stmt.setString(2, bean.getAnswer1());
            stmt.setString(3, bean.getAnswer2());
            stmt.setString(4, bean.getAnswer3());
            stmt.setString(5, bean.getAnswer4());
            stmt.setInt(6, bean.getCorrectAns());
            
            int affected = stmt.executeUpdate();
            
            if (affected == 1){
                keys = stmt.getGeneratedKeys();
                keys.next();
                int key = keys.getInt(1);
                bean.setQuestionId(key);
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
    
    public static Question getQuestionById(int questionId) {
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement stmt = null;
        String sql  = "SELECT * FROM questions WHERE questionId = ? LIMIT 1;";
        try {
            con = ConnectionManager.getInstance().getConnection();
            stmt = con.prepareStatement(sql);            
            stmt.setInt(1, questionId);
            rs = stmt.executeQuery();
            
            // Create the linked list to insert questions
            Question question = new Question();
            
            if (rs != null) {
                rs.next();
                question.setQuestionId(rs.getInt("questionId"));
                question.setQuestion(rs.getString("question"));
                question.setAnswer1(rs.getString("answer1"));
                question.setAnswer2(rs.getString("answer2"));
                question.setAnswer3(rs.getString("answer3"));
                question.setAnswer4(rs.getString("answer4"));
                question.setCorrectAns(rs.getInt("correctAns")); 
                return question;
            } else {
                return null;
            }
            
            
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
    
    
    public static LinkedList<Question> getRandomQuestions() {
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement stmt = null;
        String sql  = "SELECT * FROM questions ORDER BY RAND() LIMIT 5;";
        try {
            con = ConnectionManager.getInstance().getConnection();
            stmt = con.prepareStatement(sql);            
            rs = stmt.executeQuery();
            
            // Create the linked list to insert questions
            LinkedList<Question> qList = new LinkedList<>();
            
            while(rs.next()) {
                Question temp = new Question();
                temp.setQuestionId(rs.getInt("questionId"));
                temp.setQuestion(rs.getString("question"));
                temp.setAnswer1(rs.getString("answer1"));
                temp.setAnswer2(rs.getString("answer2"));
                temp.setAnswer3(rs.getString("answer3"));
                temp.setAnswer4(rs.getString("answer4"));
                temp.setCorrectAns(rs.getInt("correctAns"));
                qList.push(temp);                
            }
            
            return qList;
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
