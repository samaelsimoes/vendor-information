package br.com.desafioNeomind.providerRepository;

import java.util.List;

import br.com.desafioNeomind.core.Managed;
import br.com.desafioNeomind.providerEntity.ProviderEntity;

public class ProviderRepository extends Managed {

	private static final long serialVersionUID = 1L;

	public ProviderEntity persist(ProviderEntity  provider) {
		this.getEntityManager().persist(provider);
		return provider;
	}

	@SuppressWarnings("unchecked")
	public List<ProviderEntity> findAll() {
		
		return this.getEntityManager().createQuery("SELECT u FROM desafioNeomind u ORDER BY u.oid").getResultList();
	}
}