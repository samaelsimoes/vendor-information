package br.com.neomind.rest;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
			
			System.out.println(providerObj);
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
}
