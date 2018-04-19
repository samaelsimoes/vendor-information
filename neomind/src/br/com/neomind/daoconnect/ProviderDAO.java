package br.com.neomind.daoconnect;

import br.com.neomind.entity.Provider;

public class ProviderDAO extends OperationsDAO<Provider>{

	public ProviderDAO() {
		super();
	}
	
	public ProviderDAO(int num) {
		this.num = num;
	}
	
	public ProviderDAO(Provider provider){
		this.entity = provider;
	}
}