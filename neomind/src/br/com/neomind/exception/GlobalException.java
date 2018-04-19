package br.com.neomind.exception;

import br.com.neomind.configuration.HConnect;

public class GlobalException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public GlobalException(String msg){
		super(msg);
	}
	
	public GlobalException (String msg, Throwable cause){
		super("Ocorreu um erro ao realizar a operação "+msg, cause);
		new HConnect().setEntityManager(null);
	}
}