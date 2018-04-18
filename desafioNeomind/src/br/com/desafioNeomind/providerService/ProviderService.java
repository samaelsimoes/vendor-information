package br.com.desafioNeomind.providerService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.desafioNeomind.core.Managed;
import br.com.desafioNeomind.pojo.ProviderPojo;
import br.com.desafioNeomind.providerRepository.ProviderRepository;

@RequestScoped
@Named
public class ProviderService extends Managed {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProviderRepository providerRepository;

	@Transactional
	public void save(ProviderPojo objProvider) {
		try {   
			 
			this.getEntityManager().persist(objProvider);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}	