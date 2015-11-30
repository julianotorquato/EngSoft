/**
 * 
 */
package br.com.energia.repository.impl;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import br.com.energia.util.jpa.UtilJPA;


/**
 * @author Juliano Torquato
 *
 */
public abstract class GenericRepositoryImpl<T, I extends Serializable> implements br.com.energia.repository.GenericRepository<T, Long> {
    
    @Override
    public void salvar(T entity){
        EntityManager em = UtilJPA.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {            
            tx.begin();
            em.persist(entity);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            em.close();
        }
    }
    
    @Override
    public void atualizar(T entity){
        EntityManager em = UtilJPA.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(entity);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{            
            em.close();
        }       
    }
    
    @Override
    public void remover(T entity){
        EntityManager em = UtilJPA.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            entity = em.merge(entity);
            em.remove(entity);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{            
            em.close();
        }       
    }
    
    @Override
    public T getPorId(Class<T> classe, Long id){
        T entity = null;
        EntityManager em = UtilJPA.getEntityManager();
        try {
           entity = em.find(classe, id);
        } catch (NoResultException e) {
            return null;
        }
        return entity;
    }
    
    @Override
    public List<T> getTodos(Class<T> classe){
        EntityManager em = UtilJPA.getEntityManager();
         try {
           return em.createQuery("from "+ classe.getSimpleName()).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    
}
