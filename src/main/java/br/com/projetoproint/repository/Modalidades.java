package br.com.projetoproint.repository;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.projetoproint.dao.HibernateUtil;
import br.com.projetoproint.modelo.Modalidade;



public class Modalidades implements Serializable {

	
	
	public Modalidades(Session secaoHibernate) {
		
		this.secaoHibernate = secaoHibernate;
	}
	
	/**
	 -------------- autor : Emanoel Farias -------------------
	 */
	private static final long serialVersionUID = 1L;
	private Session secaoHibernate;

	// adicionar (implementado)
	// remover
	// buscar (implementado)
	// atualizar (implementado)
	// listar (implementado)

	public List<Modalidade> listar() {

		secaoHibernate.beginTransaction();
		Query query = secaoHibernate.createQuery("from Modalidade");
		secaoHibernate.getTransaction().commit();
		return query.list();

	}

	public void guardar(Modalidade modalidade) {

		secaoHibernate.beginTransaction();
		secaoHibernate.merge(modalidade);
		secaoHibernate.getTransaction().commit();

	}
	
	public Modalidade porId (int id){
		
			
			secaoHibernate.beginTransaction();
			Query query = secaoHibernate.createQuery("from Modalidade where codModalidade="+id);
			secaoHibernate.getTransaction().commit();		
			return (Modalidade) query.list().get(0);
			
		
	}
	
	public void excluir (int id) {
		
		// implementar exclusao por id
		
		
	}
	
	public void adicionar (Modalidade modalidade) {
		
		secaoHibernate.beginTransaction();
		secaoHibernate.persist(modalidade);
		secaoHibernate.getTransaction().commit();
		
	}
	
	

}
