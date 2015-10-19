/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.util.Collections;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
    
    public String nextRound() {
        if (this.roundCount < 10) {
            this.score += answerInGame.getPoints();
            this.roundCount++;
            answerInGame=null;
            return randomQuestions();
        }
        this.persistScore();
        return "highscore";
    }
    
    private void persistScore() {
        Highscore h = new Highscore();
        h.setName(name);
        h.setPoints(score);
        t = em.getTransaction();
        t.begin();
        em.persist(h);
        try {
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }
    
    }

}
