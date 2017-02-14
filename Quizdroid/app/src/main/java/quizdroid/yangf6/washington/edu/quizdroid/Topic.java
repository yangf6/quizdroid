package quizdroid.yangf6.washington.edu.quizdroid;
import java.util.List;

/**
 * Created by apple on 2/12/17.
 */

public class Topic {
    private String title;
    private String shortDescr;
    private String longDescr;
    private List<Question> question;

    public Topic(String t, String s, String l, List<Question> q){
        this.title = t;
        this.shortDescr = s;
        this.longDescr = l;
        this.question = q;
    }

    public Topic(Topic topic){
        this.title = topic.getTitle();
        this.shortDescr = topic.getShort();
        this.longDescr = topic.getLong();
        this.question = topic.getQ();
    }

    public String getTitle(){
        return title;
    }

    public String getShort(){
        return shortDescr;
    }

    public String getLong(){
        return longDescr;
    }

    public List<Question> getQ(){
        return question;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setShort(String shortDescr){
        this.shortDescr = shortDescr;
    }

    public void setLongDescr(String longDescr){
        this.longDescr = longDescr;
    }

    public void setQuestion(List<Question> question){
        this.question = question;
    }
}
