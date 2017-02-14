package quizdroid.yangf6.washington.edu.quizdroid;

import java.io.Serializable;

/**
 * Created by apple on 2/12/17.
 */

public class Question implements Serializable{
    private String question;
    private String anwser1;
    private String anwser2;
    private String anwser3;
    private String anwser4;
    private int correct;

    public Question(String q, String a1, String a2, String a3, String a4, int c){
        this.question = q;
        this.anwser1 = a1;
        this.anwser2 = a2;
        this.anwser3 = a3;
        this.anwser4 = a4;
        this.correct = c;
    }

    public Question(Question Question){
        this.question = Question.getQuestion();
        this.correct = Question.getCorrect();
        this.anwser1 = Question.getAnswer1();
        this.anwser2 = Question.getAnswer2();
        this.anwser3 = Question.getAnswer3();
        this.anwser4 = Question.getAnswer4();
    }

    public String getQuestion(){
        return question;
    }

    public int getCorrect(){
        return correct;
    }

    public String getAnswer1(){
        return anwser1;
    }

    public String getAnswer2(){
        return anwser2;
    }

    public String getAnswer3() {
        return anwser3;
    }

    public String getAnswer4() {
        return anwser4;
    }

}
