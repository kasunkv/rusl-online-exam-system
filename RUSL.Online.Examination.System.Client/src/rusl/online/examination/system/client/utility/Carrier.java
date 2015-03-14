
package rusl.online.examination.system.client.utility;

import java.io.Serializable;
import java.util.LinkedList;
import rusl.online.examination.system.server.bean.Question;
import rusl.online.examination.system.server.bean.Question;
import rusl.online.examination.system.server.bean.Student;
import rusl.online.examination.system.server.bean.Student;

public class Carrier implements Serializable {
    private CarrierType type;
    private Question question;
    private LinkedList<Question> questionList;
    private Student loginReq;
    private LinkedList<Answer> answers;
    private Result results;
    private int studentId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    
    public void setResults(Result results) {
        this.results = results;
    }

    public Result getResults() {
        return results;
    }

    public void setAnswers(LinkedList<Answer> answers) {
        this.answers = answers;
    }

    public LinkedList<Answer> getAnswers() {
        return answers;
    }

    public void setLoginReq(Student loginReq) {
        this.loginReq = loginReq;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setQuestionList(LinkedList<Question> questionList) {
        this.questionList = questionList;
    }

    public void setType(CarrierType type) {
        this.type = type;
    }

    public Student getLoginReq() {
        return loginReq;
    }

    public Question getQuestion() {
        return question;
    }

    public LinkedList<Question> getQuestionList() {
        return questionList;
    }

    public CarrierType getType() {
        return type;
    }
}
