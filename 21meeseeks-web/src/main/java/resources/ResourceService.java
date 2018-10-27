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

import entities.Resource;
import interfaces.ResourceServiceLocal;

@Path("resource")
@RequestScoped
public class ResourceService {
	@EJB
	ResourceServiceLocal rs;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addResource(Resource r){
		if(r!=null){
			int i=rs.ajoutRessource(r);	
		}
		
		return Response.status(Status.CREATED).entity("ok").build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllResource(){
		List<Resource> list=new ArrayList<>();
		list=rs.getAllResource();
		return Response.status(Status.FOUND).entity(list).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchResource(@PathParam(value = "id") int id){
		Resource r=rs.findResource(id);
		return Response.status(Status.FOUND).entity(r).build();
		
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteResource(@PathParam(value = "id") int id){
		Boolean b =rs.deleteResource(id);
		return Response.status(Status.OK).entity(b).build();
		
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateResource(Resource r){
		rs.updateResource(r);
		return Response.status(Status.OK).entity("update successful").build();
	}

}
