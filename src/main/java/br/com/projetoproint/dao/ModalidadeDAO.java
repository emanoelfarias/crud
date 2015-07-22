package br.com.projetoproint.dao;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.projetoproint.modelo.*;

public class ModalidadeDAO {
	
	
	Session secaoHibernate ;
	private List<Modalidade> lista=null;
	private Modalidade modalidade;
	
	
	public List<Modalidade> Lista () {
		
	
		secaoHibernate = HibernateUtil.createSessionFactory().openSession();
		secaoHibernate.beginTransaction();
		Query query = secaoHibernate.createQuery("from Modalidade");		
		this.lista = query.list();
		secaoHibernate.getTransaction().commit();
		secaoHibernate.close();
		return lista;
		
		
		
	}
	
	
	public void guardar (Modalidade modalidade) {
		
		Session secaoHibernate = HibernateUtil.createSessionFactory().openSession();
		secaoHibernate.beginTransaction();
		secaoHibernate.merge(modalidade);
		secaoHibernate.getTransaction().commit();
		secaoHibernate.close();
	}
	
	public Modalidade porID (int id){
		
		secaoHibernate=HibernateUtil.createSessionFactory().openSession();
		secaoHibernate.beginTransaction();
		this.modalidade =  (Modalidade) secaoHibernate.load(Modalidade.class, id);
		secaoHibernate.getTransaction().commit();
		return modalidade;
	}
	
	
	
	
	public void excluir (Modalidade modalidade){
		
		
		secaoHibernate=HibernateUtil.createSessionFactory().openSession();
		secaoHibernate.beginTransaction();
		secaoHibernate.delete(modalidade);	
		secaoHibernate.getTransaction().commit();
		secaoHibernate.close();
	}
	
	
	

}
