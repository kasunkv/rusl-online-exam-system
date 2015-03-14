
package rusl.online.examination.system.server.utility;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import rusl.online.examination.system.client.utility.*;
import rusl.online.examination.system.server.bean.Question;
import rusl.online.examination.system.server.bean.Student;
import rusl.online.examination.system.server.bean.tables.QuestionManager;
import rusl.online.examination.system.server.bean.tables.StudentManager;


public class Server extends Thread{
    
    private static final int NUM_OF_QUESTIONS = 5;
    private static int PORT = 6789;
    ServerSocket welcomeSocket = null;
    Socket clientSocket = null;
    
    @Override
    public void run() {
        Server server = new Server();
        server.startServer();
    }
    
    public void startServer() {
        
        try {
            welcomeSocket = new ServerSocket(PORT);
            
            while (true) {    
                // Create the Client Socket
                clientSocket = welcomeSocket.accept();
                System.out.println("Socket Extablished...");
                // Create input and output streams to client
                ObjectOutputStream outToClient = new ObjectOutputStream(clientSocket.getOutputStream());
                ObjectInputStream inFromClient = new ObjectInputStream(clientSocket.getInputStream());
                
                // Read modify
                // TODO here
                
                /* Read the Carrier Object from the client */
                Carrier fromClient = new Carrier();
                fromClient = (Carrier)inFromClient.readObject();
                System.out.println("Carrier received...");
                
                
                /* According to the carrier type perform action */ 
                Carrier toClient = new Carrier();
               switch (fromClient.getType()) {
                   case LOGIN_REQ: 
                       // student from client
                       Student std = fromClient.getLoginReq();
                       // student row from Db
                       Student stdFromDB = StudentManager.getStudent(std.getUserName(), std.getPassword());
                       
                       // Create new Carrier to sent to client                       
                       toClient.setType(CarrierType.LOGIN_REQ);                       
                       
                       if(stdFromDB != null){
                           stdFromDB.setLogged(true);                           
                           toClient.setLoginReq(stdFromDB);
                           outToClient.writeObject(toClient);
                       } else {
                           stdFromDB = new Student();
                           stdFromDB.setLogged(false);                           
                           toClient.setLoginReq(stdFromDB);
                           outToClient.writeObject(toClient);
                       }
                       System.out.println("Reply(LOGIN) casrrier sent...");
                       break;
                       
                   case QUESTION_LIST:
                       // Get the questions from the database
                       LinkedList<Question> list = QuestionManager.getRandomQuestions();
                       // Create new Carrier to sent to client                       
                       toClient.setType(CarrierType.QUESTION_LIST);
                       toClient.setQuestionList(list);
                       outToClient.writeObject(toClient); 
                       System.out.println("Reply(QUESTION LIST) casrrier sent...");                      
                       break;
                       
                   case ANSWERS:
                       // Get the client objetc
                       LinkedList<Answer> ansFromClient = fromClient.getAnswers();
                       
                       // performe calculations 
                       float marks = Helper.calculateMarks(ansFromClient, NUM_OF_QUESTIONS);
                       String grade = Helper.calculateGrade(marks);
                       
                       // Create the Result object
                       Result results = new Result();
                       results.setGrade(grade);
                       results.setMarks(marks);
                       results.setNoOfQuestions(NUM_OF_QUESTIONS);
                       
                       // Send to the client
                       toClient.setType(CarrierType.RESULT);
                       toClient.setResults(results);
                       // Update database
                       StudentManager.updateMarks(marks, ansFromClient.get(2).getStdId());
                       outToClient.writeObject(toClient);                       
                       System.out.println("Reply(RESULTS) casrrier sent...");
                       break;
                       
                   case RESULT:
                       // get Student info
                       int studentId = fromClient.getStudentId();
                       Student student = StudentManager.getStudentById(studentId);
                       
                       // Create the result object
                       Result resultToClient = new Result();
                       resultToClient.setMarks(student.getMarks());
                       resultToClient.setGrade(Helper.calculateGrade(student.getMarks()));
                       resultToClient.setNoOfQuestions(NUM_OF_QUESTIONS);
                       
                       // create and send the carrier
                       toClient.setType(CarrierType.RESULT);
                       toClient.setResults(resultToClient);
                       outToClient.writeObject(toClient);                       
                       System.out.println("Reply(RESULTS_REQUESt) casrrier sent...");
                       break;
               }
            }
            
        } catch (Exception e) {
            System.err.println("Server Error: " + e.getMessage());
            System.err.println("Localized: " + e.getLocalizedMessage());
            System.err.println("Stack Trace: " + e.getStackTrace());
            System.err.println("To String: " + e.toString());
        }
    }
    
    public void stopServer() {
        try {
            clientSocket.close();
            welcomeSocket.close();
        } catch (Exception e) {
        }
        
    }
    
}
