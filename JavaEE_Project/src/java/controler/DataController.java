/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Questions;

/**
 *
 * @author Thomas
 */
@ManagedBean
@RequestScoped
public class DataController {
    Questions question;

    /**
     * Creates a new instance of DataControler
     */
    public DataController() {
        
    }
    
}
