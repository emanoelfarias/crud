package br.com.projetoproint.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import br.com.projetoproint.modelo.Grupo;

public class GrupoDAO {

	Session secaoHibernate;
	List<Grupo> lista=null;
	
	
	public GrupoDAO() {}
	
	
	public Grupo porID (int id) {
		
		secaoHibernate=HibernateUtil.createSessionFactory().openSession();
		secaoHibernate.beginTransaction();
		return (Grupo) secaoHibernate.load(Grupo.class, id);
		
	}
	
	public List<Grupo> listar (){
		
		
		secaoHibernate=HibernateUtil.createSessionFactory().openSession();
		secaoHibernate.beginTransaction();
		Query query = secaoHibernate.createQuery("from Grupo");		
		this.lista = query.list();
		secaoHibernate.getTransaction().commit();
		return lista;
}
	

}
