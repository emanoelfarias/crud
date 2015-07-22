package br.com.projetoproint.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.projetoproint.modelo.EquipePartida;
import br.com.projetoproint.modelo.Partida;

public class EquipePartidaDAO {
	
	private Session secaoHibernate;
	private List<EquipePartida> lista=null;
	
	
	public List<EquipePartida> listar (){
		
		secaoHibernate=HibernateUtil.createSessionFactory().openSession();
		secaoHibernate.beginTransaction();
		Query query = secaoHibernate.createQuery("from EquipePartida");		
		this.lista = query.list();
		return lista;
		
	}
	
	public void guardar (EquipePartida equipepartida){
		
		
		secaoHibernate=HibernateUtil.createSessionFactory().openSession();
		secaoHibernate.getTransaction().begin();
		secaoHibernate.merge(equipepartida);
		secaoHibernate.getTransaction().commit();
		secaoHibernate.close();
	
				
		
	}
	

	public void inserir (EquipePartida equipepartida) {
		
		secaoHibernate=HibernateUtil.createSessionFactory().openSession();
		secaoHibernate.getTransaction().begin();
		secaoHibernate.merge(equipepartida);
		secaoHibernate.getTransaction().commit();
		secaoHibernate.close();
		
		
	}
	
	public List<EquipePartida> listaPORID (int id) {
		
		secaoHibernate=HibernateUtil.createSessionFactory().openSession();
		secaoHibernate.beginTransaction();
		Query query = secaoHibernate.createQuery("from EquipePartida where codPartida ="+id);		
		this.lista = query.list();
		return lista;
		
	}

	
	
	
	
	public EquipePartidaDAO() {
		
	}

}
