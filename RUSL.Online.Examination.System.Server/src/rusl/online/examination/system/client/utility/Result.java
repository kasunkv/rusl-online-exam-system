
package rusl.online.examination.system.client.utility;

import java.io.Serializable;

public class Result implements Serializable{
    private float marks;
    private int correctQuestions;
    private int noOfQuestions;
    private String grade;

    public int getCorrectQuestions() {
        return correctQuestions;
    }

    public void setCorrectQuestions(int correctQuestions) {
        this.correctQuestions = correctQuestions;
    }
    public String getGrade() {
        return grade;
    }

    public float getMarks() {
        return marks;
    }

    public int getNoOfQuestions() {
        return noOfQuestions;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }

    public void setNoOfQuestions(int noOfQuestions) {
        this.noOfQuestions = noOfQuestions;
    }
    
}
