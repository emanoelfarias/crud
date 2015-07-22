package br.com.projetoproint.dao;

import br.com.projetoproint.modelo.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.projetoproint.modelo.Administrador;

public class AdministradorDAO {
	
	// inserir um administrador
	
	void inserir (Administrador adm){
		
			
	}
	
	// lista
	
	List<Administrador> listar (){
		
		return null;
	}
	
	// procura um adm
	
	public boolean procura (String nome, String senha){
		
		System.out.println("nome na dao:"+ nome);
		System.out.println("senha na dao:"+senha);


			
		String hql = "from Administrador where senhaAdm="+"'"+senha+"'"+" and "+"nomeAdm="+"'"+nome+"'";
		Session secaoHibernate = HibernateUtil.createSessionFactory().openSession();
		//inicia transacao
		secaoHibernate.beginTransaction();
		
		
		Query query = secaoHibernate.createQuery(hql);
		List<Administrador> lista = query.list();
		
		if(lista.size()!=0){  // se a lista diferente de zero
			
		
		System.out.println(lista.size());		
		// comita transacao		
		secaoHibernate.getTransaction().commit();
		// fecha a sessao
		secaoHibernate.close();
		return true;
		}
		
		else{
		
			
		System.out.println("Ninguem foi encontrado");
		return false;
		}
			
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
