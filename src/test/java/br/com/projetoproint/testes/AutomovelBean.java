package br.com.projetoproint.testes;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.view.ViewScoped;

import org.hibernate.Session;

import br.com.projetoproint.dao.HibernateUtil;


@ManagedBean
@ViewScoped
public class AutomovelBean implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Automovel automovel = new Automovel();
	Session secaoHibernate=null;
	
	public AutomovelBean() {
	}
	
	public void inserir () {
		
	if(secaoHibernate==null){
	secaoHibernate = HibernateUtil.createSessionFactory().openSession();	
	}
	
	secaoHibernate.beginTransaction();
	secaoHibernate.persist(automovel);
	secaoHibernate.getTransaction().commit();
		
	}
	
	public Automovel getAutomovel () {
		
		return this.automovel;
		
	}
	
	public void setAutomovel (Automovel automovel)
	{
		this.automovel = automovel;
	}

}
