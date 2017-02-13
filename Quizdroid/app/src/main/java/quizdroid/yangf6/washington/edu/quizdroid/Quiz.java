package quizdroid.yangf6.washington.edu.quizdroid;
package domainLayer;

/**
 * Created by apple on 2/12/17.
 */

public class Quiz {
    private String question;
    private String anwser1;
    private String anwser2;
    private String anwser3;
    private String anwser4;
    private int correct;

    public Quiz(String q, String a1, String a2, String a3, String a4, int c){
        this.question = q;
        this.anwser1 = a1;
        this.anwser2 = a2;
        this.anwser3 = a3;
        this.anwser4 = a4;
        this.correct = c;
    }

    public Quiz(Quiz Quiz){
        this.question = Quiz.getQuestion();
        this.correct = Quiz.getCorrect();
        this.anwser1 = Quiz.getAnswer1();
        this.anwser2 = Quiz.getAnswer2();
        this.anwser3 = Quiz.getAnswer3();
        this.anwser4 = Quiz.getAnswer4();
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
