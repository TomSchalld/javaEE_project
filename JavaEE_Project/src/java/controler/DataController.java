/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
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
@RequestScoped
public class DataController {
    private String question;
    private String[] answers;
    private EntityManager em;
    private EntityTransaction t;
    
    
    /**
     * Creates a new instance of DataControler
     */
    public DataController() {
        em = Persistence.createEntityManagerFactory("JavaEE_ProjectPU").createEntityManager();
        answers = new String[4];
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
    public void addQuestion(){
        
    }
    
}
