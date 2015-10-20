/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import model.Answers;
import model.Highscore;
import model.Questions;

/**
 *
 * @author Thomas
 */
@ManagedBean
@SessionScoped
public class GameController {
    private String name = "John Appleseed";
    private int roundCount = 0;
    private List<Questions> resultList;
    private Questions question;
    private Answers answerInGame;
    private int answerIndex;
    private EntityManager em;
    private EntityTransaction t;
    private int score = 0;

    /**
     * Creates a new instance of bean
     */
    public GameController() {
        em = Persistence.createEntityManagerFactory("JavaEE_ProjectPU").createEntityManager();
    }

    public String randomQuestions() {
        resultList = em.createNamedQuery("Questions.findAll").getResultList();
        Collections.shuffle(resultList);
        question = resultList.get(0);
        return "game";
        
    }

    public Questions getQuestion() {
        return question;
    }

    public void setQuestion(Questions question) {
        this.question = question;
    }

    public Answers getAnswerInGame() {
        return answerInGame;
    }

    public void setAnswerInGame(Answers answerInGame) {
        this.answerInGame = answerInGame;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAnswerIndex() {
        return answerIndex;
    }

    public void setAnswerIndex(int answerIndex) {
        this.answerIndex = answerIndex;
    }
    
    public String nextRound() {
        this.answerInGame = this.question.getAnswersList().get(this.answerIndex);
        if (this.roundCount < this.resultList.size() && this.roundCount < 10) {
            this.score += answerInGame.getPoints();
            this.roundCount++;
            this.answerInGame=null;
            this.question = resultList.get(this.roundCount);
            return "game";
        }
        this.persistScore();
        clear();
        return "highscore";
    }

    private void clear() {
        this.answerInGame=null;
        this.roundCount=0;
        this.score=0;
        this.logout();
    }
    public void logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
    private void persistScore() {
        Highscore h = new Highscore();
        h.setName(name);
        h.setPoints(score);
        h.setTimestamp(new Date());
        t = em.getTransaction();
        t.begin();
        try {
            em.persist(h);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
    
    }

}
