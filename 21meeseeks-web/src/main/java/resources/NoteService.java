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

import entities.Note;
import interfaces.NoteServiceLocal;

@Path("note")
@RequestScoped
public class NoteService {
	@EJB
	NoteServiceLocal ns;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addNote(Note n) {
		if (n != null) {
			int i = ns.addNote(n);
		}

		return Response.status(Status.CREATED).entity("ok").build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllNote() {
		List<Note> list = new ArrayList<>();
		list = ns.getAllNote();
		return Response.status(Status.FOUND).entity(list).build();

	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchNote(@PathParam(value = "id") int id) {
		Note n = ns.findNote(id);
		return Response.status(Status.FOUND).entity(n).build();

	}

	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteNote(@PathParam(value = "id") int id) {
		Boolean b = ns.deleteNote(id);
		return Response.status(Status.ACCEPTED).entity(b).build();

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateNote(Note n) {
		ns.updateNote(n);
		return Response.status(Status.OK).entity("update successful").build();

	}

}
