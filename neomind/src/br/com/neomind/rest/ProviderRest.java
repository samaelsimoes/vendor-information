package br.com.neomind.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import br.com.neomind.daoconnect.ProviderDAO;
import br.com.neomind.entity.Provider;
import br.com.neomind.exception.GlobalException;
import br.com.neomind.factory.entity.provider.ProviderFactory;
import br.com.neomind.factory.util.ObjMapper;
import br.com.neomind.service.ProviderService;

@Path("/provider")
public class ProviderRest extends ObjMapper{
	
	public ProviderRest() {}
	
	@POST
	@Consumes("application/*")
	public Response add(String providerObj) throws GlobalException {
		try {
			
			Provider provider = new ProviderFactory(providerObj).getProvider();
			
			if ( provider != null ) {
				new ProviderService(provider).add();
			} else {
				throw new GlobalException("Valor nulo enviado ao servidor");
			}			
			
			return this.buildResponse("Cadastrado com sucesso.");
		} catch (Throwable e) {
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}
	}
	
	@GET
	@Produces("application/json; charset=UTF-8")
	public List<Provider> getAll() throws GlobalException {
		Provider provider = new Provider();

		return new ProviderService(provider).getProvider();
	} 
	
	@DELETE
	@Produces("application/json")
	public Response delete(@QueryParam("ids") List<String> ids) throws GlobalException {
		
		try{
			int value = 0;
			for ( int i = 0; i < ids.size(); i++) {
				
				value = Integer.parseInt(ids.get(i));
				new ProviderService(value).excluir();

			};	
			
		} catch (Exception e) {
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}
		return this.buildResponse("Excluido com sucesso.");
	}
	
	@PUT
	@Produces("application/json")
	public Response editar(String providerObj) {
		try{
			Provider provider = new ProviderFactory(providerObj).getProvider();
			
			if ( provider != null ) {
				new ProviderService(provider).edit();
			} else {
				throw new GlobalException("Valor nulo enviado ao servidor");
			}			
			
			return this.buildResponse("Editado com sucesso.");			
			
		}catch(Exception e){
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}
	}
	
}

/*
 * { "id": 1, "name": "fornec lorimospm", "email": "fornec@loripsom", "comment": "loreipsum", "cnpj": "00.000/0000-00" }
 */