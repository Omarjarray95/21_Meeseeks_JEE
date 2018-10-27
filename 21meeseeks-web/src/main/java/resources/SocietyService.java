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

import entities.Society;
import interfaces.SocietyServiceLocal;

@Path("society")
@RequestScoped
public class SocietyService {
	@EJB
	SocietyServiceLocal ss;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addSociety(Society s) {
		if (s != null) {
			int i = ss.addSociety(s);
		}

		return Response.status(Status.CREATED).entity("ok").build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllSociety() {
		List<Society> list = new ArrayList<>();
		list = ss.getAllSociety();
		return Response.status(Status.FOUND).entity(list).build();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchSociety(@PathParam(value = "id") int id) {
		Society s = ss.findSociety(id);
		return Response.status(Status.FOUND).entity(s).build();

	}

	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteSociety(@PathParam(value = "id") int id) {
		Boolean b = ss.deleteSociety(id);
		return Response.status(Status.OK).entity(b).build();

	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateSociety(Society s){
		ss.updateSociety(s);
		return Response.status(Status.OK).entity("update successful").build();
	}

}
