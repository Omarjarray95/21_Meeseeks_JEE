package resources;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
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
import javax.ws.rs.core.Response.Status;

import entities.Establishment;
import interfaces.EstablishmentServiceLocal;

@Path("establishment")
@RequestScoped
public class EstablishmentService {
	@EJB
	EstablishmentServiceLocal es;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addEstablishment(Establishment e){
		if(e!=null){
			int id=es.addEstablishment(e);
			
		}
		return Response.status(Status.CREATED).entity("ok").build();
	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllEstablishment(){
		List<Establishment> list=new ArrayList<>();
		list=es.getAllEstablishment();
		return Response.status(Status.FOUND).entity(list).build();
		
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchEstablishment(@PathParam(value = "id") int id) {
		Establishment e=es.findEstablishment(id);
		return Response.status(Status.FOUND).entity(e).build();

	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteEstablishment(@PathParam(value="id")int id){
		Boolean b=es.deleteEstablishment(id);
		return Response.status(Status.OK).entity(b).build();
		
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateEstablishment(Establishment e){
		es.updateEstablishment(e);
		return Response.status(Status.OK).entity("update successful").build();
		
	}

}
