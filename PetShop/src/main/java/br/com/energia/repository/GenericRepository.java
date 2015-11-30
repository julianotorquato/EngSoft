/**
 * 
 */
package br.com.energia.repository;

import java.io.Serializable;
import java.util.List;


/**
 * @author Juliano Torquato
 * 
 */
public interface GenericRepository<T, id extends Serializable> {

    public void salvar(T entity);

    public void atualizar(T entity);
    
    public void remover(T entity);
       
    public T getPorId(Class<T> classe, Long id);
    
    public List<T> getTodos(Class<T> classe);
}
