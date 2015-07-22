package br.com.projetoproint.bean;


import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import br.com.projetoproint.dao.AlunoDAO;
import br.com.projetoproint.modelo.Aluno;
import br.com.projetoproint.modelo.Curso;
import br.com.projetoproint.modelo.Equipe;
import br.com.projetoproint.modelo.Modalidade;


@ManagedBean
@RequestScoped
public class AlunoBean {
	
	
	private Aluno aluno = new Aluno();
	private Equipe equipe;
	private Modalidade modalidade;
	private Curso curso;
	
	
	private List<Aluno> lista=null;
	private AlunoDAO dao = new AlunoDAO();
	private Aluno alunoSelecionado;
	
	public AlunoBean() {
		
	}
	
	@PostConstruct	
	public void inicia () {
		this.lista = new AlunoDAO().listar();
	}
	
	
	// prepara lista
	public void prepara(){
		
		this.lista = new AlunoDAO().listar();
		
		
	}
	

	public List<Aluno> getLista () {
		
		return lista;
	}
	
	// insere
	
	
	
	// exclui
	public void excluir () {
		
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.dao.excluir(this.alunoSelecionado);
			this.prepara();
			context.addMessage(null, new FacesMessage("Aluno excluído com sucesso!"));
			
			} catch (Exception e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		
			}
		
	}
	
	public void guardar () {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		try{
		
		aluno.setCodEquipe(equipe);		
		aluno.setCodcurso(curso);
		aluno.setCodModalidade(modalidade);
		this.dao.guardar(aluno);
		context.addMessage(null, new FacesMessage("Operação Realizada"));
		}catch(Exception e){
		
		System.out.println(e.getMessage());
		FacesMessage mensagem = new FacesMessage(e.getMessage());
		mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
		context.addMessage(null, mensagem);
			
		}
	}
		

	public void teste () {
	
		
	System.out.println(aluno.getNome());
		
	}

	public Aluno getAluno() {
		return aluno;
	}



	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}



	public Equipe getEquipe() {
		return equipe;
	}



	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}



	public Modalidade getModalidade() {
		return modalidade;
	}



	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}



	public Curso getCurso() {
		return curso;
	}



	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Aluno getAlunoSelecionado() {
		return alunoSelecionado;
	}

	public void setAlunoSelecionado(Aluno alunoSelecionado) {
		this.alunoSelecionado = alunoSelecionado;
	}



}
