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
import model.Questions;

/**
 *
 * @author Thomas
 */
@ManagedBean
@SessionScoped
public class GameController {
    private int roundCount;
    private List<Questions> resultList;
    private Questions question;
    private Answers answerInGame;
    private EntityManager em;
    private EntityTransaction t;
    private int score;
    /**
     * Creates a new instance of bean
     */
    public GameController() {
        em = Persistence.createEntityManagerFactory("JavaEE_ProjectPU").createEntityManager();
        randomQuestions();
        this.roundCount =0;
        this.score=0;
    }
    private void randomQuestions(){
        resultList = em.createNamedQuery("Questions.findAll").getResultList();
        Collections.shuffle(resultList);
        question = resultList.get(0);
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
    public String nextRound(){
        if(this.roundCount<10){
            this.score+=answerInGame.getPoints();
                    return "next";

        }
        this.persistScore(this.score);
        return "highscore";
    }

    private void persistScore(int score) {
        
    }
    
    
}
