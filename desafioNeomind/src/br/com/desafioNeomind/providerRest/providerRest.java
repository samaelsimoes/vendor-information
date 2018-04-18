package br.com.desafioNeomind.providerRest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.desafioNeomind.pojo.ProviderPojo;
import br.com.desafioNeomind.providerService.ProviderService;
import br.com.desafioNeomind.providerUtil.UtilRest;

@Path("/provider")
public class providerRest extends UtilRest {

	@Inject
	private ProviderService providerService;
	private Gson gson = new Gson();
	
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	public Response get(String provider) {
		try {
			
			ProviderPojo objProbider = this.gson.fromJson(provider, ProviderPojo.class);				
			providerService.save(objProbider);
			
			return Response.ok(provider).build();
		}catch (Exception e) {
			e.printStackTrace();
			return getResponseError(e);
		}
	};
}