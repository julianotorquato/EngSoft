package br.com.energia.repository.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.energia.model.Pessoa;
import br.com.energia.model.TipoPessoa;
import br.com.energia.repository.PessoaRepository;
import br.com.energia.repository.filter.PessoaFilter;
import br.com.energia.util.jpa.UtilJPA;

public class  PessoaRepositoryImpl extends GenericRepositoryImpl<Pessoa, Serializable> implements PessoaRepository,  Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public List<Pessoa> getTodos() {
		return super.getTodos(Pessoa.class);
	}

	@Override
	public List<Pessoa> listarPorCliente() {
		EntityManager em = UtilJPA.getEntityManager();
		return em.createQuery("from Pessoa p where p.tipoPessoa = :tipo", Pessoa.class).setParameter("tipo", TipoPessoa.CLIENTE).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> filtrados(PessoaFilter filtro) {
		EntityManager manager = UtilJPA.getEntityManager();
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Pessoa.class);
		
		if (StringUtils.isNotBlank(filtro.getCpf())) {
			criteria.add(Restrictions.eq("cpf", filtro.getCpf()));
		}
		
		if (StringUtils.isNotBlank(filtro.getNome())) {
			criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
		}
		
		criteria.add(Restrictions.eq("tipoPessoa", TipoPessoa.CLIENTE));
		return criteria.addOrder(Order.asc("nome")).list();
	}
	
	

	@Override
	public Pessoa getPorId(Long id) {
		return super.getPorId(Pessoa.class, id);
	}

	@Override
	public Pessoa buscarPor(String email, String senha) {
		EntityManager manager = UtilJPA.getEntityManager();
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Pessoa.class);
		criteria.add(Restrictions.eq("login", email));
		criteria.add(Restrictions.eq("senha", senha));
		return (Pessoa) criteria.addOrder(Order.asc("nome")).uniqueResult();
	}
}