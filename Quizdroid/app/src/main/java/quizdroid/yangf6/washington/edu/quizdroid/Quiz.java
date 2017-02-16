package quizdroid.yangf6.washington.edu.quizdroid;

import java.io.Serializable;

/**
 * Created by apple on 2/15/17.
 */

class Quiz implements Serializable {
    private String text;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private int correctAnswer;

    public Quiz(String text, String answer1, String answer2, String answer3, String answer4,
                int correctAnswer) {
        this.text = text;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correctAnswer = correctAnswer;
    }

    public String getText() {
        return text;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}

