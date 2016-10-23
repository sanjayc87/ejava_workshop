/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejava2016.business;

import ejava2016.model.Registration;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sanja
 */
@Stateless
public class RegistrationManager {
    
    @PersistenceContext private EntityManager em;
    
    public void register(Registration reg){
        em.persist(reg);
    }
    
    public Optional<Registration> find(final String username){
        return (Optional.ofNullable(em.find(Registration.class, username)));
    }
}
