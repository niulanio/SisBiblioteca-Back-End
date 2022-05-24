package br.edu.fafic.ppi.exepction;

public class ObjectNaoEncontradoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public ObjectNaoEncontradoException(String msg) {
		super(msg);
	}
}
