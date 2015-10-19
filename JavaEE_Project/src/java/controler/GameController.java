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
    List<Questions> resultList;
    Questions questionOne;
    Questions questionTwo;
    private EntityManager em;
    private EntityTransaction t;
    /**
     * Creates a new instance of bean
     */
    public GameController() {
        em = Persistence.createEntityManagerFactory("JavaEE_ProjectPU").createEntityManager();
    }
    public Questions randomQuestions(){
        resultList = em.createNamedQuery("Questions.findAll").getResultList();
        Collections.shuffle(resultList);
        questionOne = resultList.get(0);
        return questionOne;
    }
    public Questions getQuestionOne() {
        randomQuestions();
        return questionOne;
    }

    public void setQuestionOne(Questions questionOne) {
        this.questionOne = questionOne;
    }

    public Questions getQuestionTwo() {
        return questionTwo;
    }

    public void setQuestionTwo(Questions questionTwo) {
        this.questionTwo = questionTwo;
    }
    
}
