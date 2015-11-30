/**
 * 
 */
package br.com.energia.util.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



/**
 * @author Juliano Torquato
 *
 */
public class UtilJPA {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("Fean");
    
    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }
}
