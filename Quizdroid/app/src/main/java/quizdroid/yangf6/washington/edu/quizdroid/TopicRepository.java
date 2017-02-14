package quizdroid.yangf6.washington.edu.quizdroid;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by apple on 2/12/17.
 */

public class TopicRepository {
    private static TopicRepository instance = new TopicRepository();

    public static TopicRepository getInstance(){
        return instance;
    }

    private List<Question> question = new ArrayList<Question>();
    private Question Mathqu1 = new Question("2+1=?","1","2","3","4",3);
    private Question Mathqu2 = new Question("2+2=?","1","2","3","4",4);
    private Question Mathqu3 = new Question("2+3=?","1","5","3","4",2);
    private Question Mathqu4 = new Question("2+4=?","1","6","3","4",2);
    private Question Phyhqu1 = new Question("light is wave?","maybe","not sure","no","yes",4);
    private Question Phyhqu2 = new Question("gravity is 9.8m/s?","maybe","not sure","no","yes",4);
    private Question Phyhqu3 = new Question("phy3?","1","2","3","4",4);
    private Question Phyhqu4 = new Question("phy4?","1","2","3","4",3);
    private Question Csehqu1 = new Question("cse1?","1","2","3","4",2);
    private Question Csehqu2 = new Question("cse2?","1","2","3","4",4);
    private Question Csehqu3 = new Question("cse3?","1","2","3","4",1);
    private Question Csehqu4 = new Question("cse4?","1","2","3","4",2);


    public List<Question> getAllQuestions(){
        return question;
    }
}
