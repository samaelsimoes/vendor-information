package br.com.neomind.factory.entity.provider;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import br.com.neomind.entity.Provider;
import br.com.neomind.factory.util.ObjMapper;
import br.com.neomind.exception.GlobalException;

public class ProviderFactory extends ObjMapper {
	
	private List<Provider> provider = new ArrayList<Provider>();

	public ProviderFactory(String providerObj) throws GlobalException {

		try {
			
			Provider obj = getObject().readValue(providerObj, Provider.class);
			
			if(obj != null) {			
				this.provider.add(obj);
			} else {				
				throw new GlobalException("Erro de factory na classe Provicer");
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new GlobalException("Erro de factory na classe Provider");
		}
	}
	
	public List<Provider> getList() {
		return provider;
	}

	public void setProvider(List<Provider> provider) {
		this.provider = provider;
	}

	public Provider getProvider() {
		return provider.get(0);
	}	
}