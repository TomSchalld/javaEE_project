/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import model.Answers;
import model.Highscore;
import model.Questions;

/**
 *
 * @author Thomas
 */
@ManagedBean
@RequestScoped
public class DataController {

    @NotNull(message = "Question must be filled")
    @Pattern(regexp = "^[a-zA-Z0-9?.,_ ]*$", message = "Question contains non-alphabetic things")
    @Size(min = 5, max = 255, message = "Question to short or to long ")
    private String question;
    @Pattern(regexp = "^[a-zA-Z0-9_ ]*$", message = "Answer contains forbidden things")
    @Size(min = 5, max = 255, message = "Answer to short or to long ")
    @NotNull(message = "Answers must be filled")
    private String[] answers;
    private EntityManager em;
    private EntityTransaction t;
    private List<Highscore> scoreboard;

    /**
     * Creates a new instance of DataControler
     */
    public DataController() {
        em = Persistence.createEntityManagerFactory("JavaEE_ProjectPU").createEntityManager();
        answers = new String[4];
    }

    public List<Highscore> getScores() {
        this.scoreboard = em.createNamedQuery("Highscore.orderedByPoints").getResultList();
        return scoreboard;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }
    public void clear(){
        question = null;
        answers = new String[4];
    }
    
    public void addQuestion() {
        List<Answers> answerList = new LinkedList<>();
        Questions q = new Questions();
        q.setQuestion(question);
        doAnswers(q, answerList);
        t = em.getTransaction();
        t.begin();
        try {
            em.persist(q);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
        clear();
    }

    private void doAnswers(Questions q, List<Answers> answerList) {
        Answers a = new Answers();
        a.setAnswer(answers[0]);
        a.setPoints(0);
        a.setQuestionID(q);
        answerList.add(a);
        a = new Answers();
        a.setAnswer(answers[1]);
        a.setPoints(3);
        a.setQuestionID(q);
        answerList.add(a);
        a = new Answers();
        a.setAnswer(answers[2]);
        a.setPoints(7);
        a.setQuestionID(q);
        answerList.add(a);
        a = new Answers();
        a.setAnswer(answers[3]);
        a.setPoints(15);
        a.setQuestionID(q);
        answerList.add(a);
        Collections.shuffle(answerList);
        q.setAnswersList(answerList);
    }

}
