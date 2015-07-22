package br.com.projetoproint.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.hibernate.Session;

import br.com.projetoproint.dao.HibernateUtil;
import br.com.projetoproint.modelo.Modalidade;
import br.com.projetoproint.repository.Modalidades;
import br.com.projetoproint.service.CadastroModalidades;

@ManagedBean
@ViewScoped
public class CadastroModalidadeBean implements Serializable {
	
	private Modalidade modalidade = new Modalidade();
	private List<Modalidade> todasModalidades;

	public CadastroModalidadeBean() {
		// TODO Auto-generated constructor stub
	}
	
	public void prepararCadastro () {
		
		Session secaoHibernate = HibernateUtil.createSessionFactory().openSession();
		try {
		
			Modalidades modalidades = new Modalidades(secaoHibernate);
			this.todasModalidades = modalidades.listar();
			
		} finally {
			secaoHibernate.close();
		}
		
	}
	
	public void salvar (){
		
		Session secaoHibernate = HibernateUtil.createSessionFactory().openSession();
		FacesContext context = FacesContext. getCurrentInstance();
		
		
		CadastroModalidades cadastro = new CadastroModalidades(new Modalidades(secaoHibernate));		
		cadastro.adicionar(this.modalidade);
		context.addMessage(null, new FacesMessage("Lancamento salvo!"));
		
		
		
	}

}
