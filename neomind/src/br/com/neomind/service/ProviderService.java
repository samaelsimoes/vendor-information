package br.com.neomind.service;

import br.com.neomind.daoconnect.ProviderDAO;
import br.com.neomind.entity.Provider;
import br.com.neomind.exception.GlobalException;

public class ProviderService {
	protected Provider provider;

	public ProviderService() {
	}
	
	public ProviderService(Provider provider) {
		this.provider = provider;
	}

	public void add() throws GlobalException {
		if( this.provider.getCnpj() != null && this.provider.getComment() != null && this.provider.getEmail() != null && this.provider.getName() != null ){
			new ProviderDAO(this.provider).persist();
		}
	}
}
