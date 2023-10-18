package br.com.fiap.seriesapi;

import java.util.List;

import br.com.fiap.seriesapi.model.Serie;
import br.com.fiap.seriesapi.service.SerieService;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("serie")
public class SerieResource {
	
	SerieService service = new SerieService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Serie> index() {
		return service.findAll();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response get(@PathParam("id") Long id) {
		System.out.println("ID = "+id);
		
		var serie = service.findById(id);
		
		if (serie==null) {
			System.out.println("não encontrado...");
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok(serie).build();
	}
	
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") Long id) {
		System.out.println("apaga = "+ id);
		var serie = service.findById(id);
		
		if(serie == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		service.delete(serie);
		
		return Response.noContent().build();
	}
	
}
