package rusl.online.examination.system.client.utility;

import java.io.Serializable;

public class Answer implements Serializable{
    private int stdId;
    private int questionId;
    private int answer;

    public int getStdId() {
        return stdId;
    }

    public void setStdId(int stdId) {
        this.stdId = stdId;
    }
   
    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getAnswer() {
        return answer;
    }

    public int getQuestionId() {
        return questionId;
    }
}
