/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejava2016.view;

import ejava2016.business.RegistrationManager;
import ejava2016.model.Registration;
import java.util.Optional;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author sanja
 */
@RequestScoped
@Named
public class RegistrationView {
    
    @EJB private RegistrationManager mgr;
    
    private String name;
    private String email;
    
    private String findName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFindName() {
        return findName;
    }

    public void setFindName(String findName) {
        this.findName = findName;
    }
    
    public String registerUser(){
        Registration registration = new Registration();
        
        registration.setName(name);
        registration.setEmail(email);
        
        mgr.register(registration);
        
        return("thankyou");
    }
    
    public void findUser(){
        Optional<Registration> optional = mgr.find(findName);
        
        if(optional.isPresent()){
            Registration reg = optional.get();
            name = reg.getName();
            email = reg.getEmail();
        }
        else{
            FacesMessage msg = new FacesMessage(String.format("User %s not found", findName));
            FacesContext.getCurrentInstance().addMessage(null, msg);
            
        }
    }
}
