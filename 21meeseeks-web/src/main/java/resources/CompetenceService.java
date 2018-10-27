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

import entities.Competence;
import interfaces.CompetenceServiceLocal;

@Path("competence")
@RequestScoped
public class CompetenceService {
	@EJB
	CompetenceServiceLocal cs;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCompetence(Competence c) {
		if (c != null) {
			int i = cs.addCompetence(c);
		}

		return Response.status(Status.CREATED).entity("ok").build();

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllComptence() {
		List<Competence> list = new ArrayList<>();
		list = cs.getAllCompetence();
		return Response.status(Status.FOUND).entity(list).build();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchCompetence(@PathParam(value = "id") int id) {
		Competence c = cs.findCompetence(id);
		return Response.status(Status.FOUND).entity(c).build();

	}

	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCompetence(@PathParam(value = "id") int id) {
		Boolean b = cs.deleteCompetence(id);
		return Response.status(Status.FOUND).entity(b).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCompetence(Competence c) {
		cs.updateCompetence(c);
		return Response.status(Status.OK).entity("update successful").build();

	}

}
