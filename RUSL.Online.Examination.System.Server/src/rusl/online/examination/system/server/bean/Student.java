
package rusl.online.examination.system.server.bean;

import java.io.Serializable;

public class Student implements Serializable{
    private int studentId;
    private String studentName;
    private float marks;
    private int attempts;
    private String userName;
    private String password;
    private boolean logged;

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAttempts() {
        return attempts;
    }

    public float getMarks() {
        return marks;
    }

    public String getPassword() {
        return password;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getUserName() {
        return userName;
    }
    
}
