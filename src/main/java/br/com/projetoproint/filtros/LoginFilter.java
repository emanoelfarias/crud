package br.com.projetoproint.filtros;

import java.io.IOException;

import javassist.bytecode.stackmap.BasicBlock.Catch;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetoproint.bean.AdmBean;


public class LoginFilter implements Filter  {

	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		AdmBean admBean = (AdmBean)((HttpServletRequest)req).getSession().getAttribute("admBean"); 
		 
		 
		 if (admBean == null || !admBean.isLog()) {
	            String contextPath = ((HttpServletRequest)req).getContextPath();
	            ((HttpServletResponse)res).sendRedirect(contextPath + "/autentica.xhtml");
	            System.out.println("filtrando");
	        }
		 
		 else { chain.doFilter(req, res); } 
		 
		 
		
		 
	} 	

	
	
	@Override
	public void init(FilterConfig config) throws ServletException {
	}
	@Override
	public void destroy() {
	}




	
}
