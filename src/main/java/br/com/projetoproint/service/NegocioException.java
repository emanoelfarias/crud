package br.com.projetoproint.service;

import java.io.Serializable;

public class NegocioException extends Exception implements Serializable {
	
	public NegocioException (String msg) {
			super(msg);
	}
}
