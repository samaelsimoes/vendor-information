package br.com.neomind.service;

import java.util.List;

import br.com.neomind.daoconnect.ProviderDAO;
import br.com.neomind.datatype.HOperator;
import br.com.neomind.entity.Provider;
import br.com.neomind.exception.GlobalException;

public class ProviderService {
	
	protected Provider provider;
	protected String valueObj;
	protected int num;

	public ProviderService(Provider provider) {
		this.provider = provider;
	}
	public ProviderService(String valueObj) {
		this.valueObj = valueObj;
	}
	public ProviderService(int num) {
		this.num = num;
	}
	public ProviderService() {}
	
	public void add() throws GlobalException {
		if( this.provider.getCnpj() != null && this.provider.getComment() != null && this.provider.getEmail() != null && this.provider.getName() != null ){
			new ProviderDAO(this.provider).persist();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Provider> getProvider() throws GlobalException {
		return new ProviderDAO(this.provider).findGeneric("cnpj", HOperator.DIFFERENT, "0");
	}
	
	public void edit() {		
		Provider provider = new ProviderDAO(this.provider.getId()).findId();
		new ProviderDAO(provider).update();
	}
	
	public void excluir() {
		new ProviderDAO(this.num).delete();		
	}	
}
