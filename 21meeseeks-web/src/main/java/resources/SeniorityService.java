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

import entities.Seniority;
import interfaces.SeniorityServiceLocal;

@Path("seniority")
@RequestScoped
public class SeniorityService {
	@EJB
	SeniorityServiceLocal ss;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addSeniority(Seniority s) {
		if (s != null) {
			int id = ss.addSeniority(s);
			String S = JsonConverter.convertSeniority(s);
		}
		return Response.status(Status.CREATED).entity("ok").build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllSeniority(){
		List<Seniority> list=new ArrayList<>();
		list =ss.getAllSenority();
		return Response.status(Status.FOUND).entity(list).build();
		
		
		
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchSeniority(@PathParam(value = "id") int id) {
		Seniority s = ss.findSeniority(id);
		String S = JsonConverter.convertSeniority(s);
		return Response.status(Status.FOUND).entity(S).build();

	}

	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteSeniority(@PathParam(value = "id") int id) {
		Boolean b = ss.deleteSeniority(id);
		return Response.status(Status.ACCEPTED).entity(b).build();

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateSeniority(Seniority s) {
	    ss.updateSeniority(s);
		return Response.status(Status.OK).entity("update successful").build();

	}

}
