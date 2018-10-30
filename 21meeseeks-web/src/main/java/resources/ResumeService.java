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

import entities.Resume;
import interfaces.ResumeServiceLocal;

@Path("resume")
@RequestScoped
public class ResumeService {
	@EJB
	ResumeServiceLocal rs;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addResume(Resume r) {
		if (r != null) {
			int i = rs.addResume(r);
		}
		return Response.status(Status.CREATED).entity("ok").build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllResume() {
		List<Resume> resume = new ArrayList<>();
		resume = rs.getAllResume();
		return Response.status(Status.FOUND).entity(resume).build();

	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchResume(@PathParam(value = "id") int id) {
		Resume resume = rs.findResume(id);
		return Response.status(Status.FOUND).entity(resume).build();

	}

	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteResume(@PathParam(value = "id") int id) {
		Boolean b = rs.deleteResume(id);
		return Response.status(Status.OK).entity(b).build();

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateResume(Resume r) {
		rs.updateResume(r);
		return Response.status(Status.OK).entity("update successful").build();

	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("index")
	public Response getLastIndex(){
		return Response.ok(rs.lastIndex()).build();
	}

}
