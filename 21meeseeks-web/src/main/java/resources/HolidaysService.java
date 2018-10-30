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

import entities.Holidays;
import interfaces.HolidaysServiceLocal;

@Path("holidays")
@RequestScoped
public class HolidaysService {
	@EJB
	HolidaysServiceLocal hs;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addHolidays(Holidays h) {
		if (h != null) {
			int i = hs.addHolidays(h);
		}

		return Response.status(Status.CREATED).entity("ok").build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllHolidays() {
		List<Holidays> list = new ArrayList<>();
		list = hs.getAllHolidays();
		return Response.status(Status.CREATED).entity(list).build();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchHolidays(@PathParam(value = "id") int id) {
		Holidays h = hs.findHolidays(id);
		return Response.status(Status.FOUND).entity(h).build();

	}

	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteHolidays(@PathParam(value = "id") int id) {
		Boolean b = hs.deleteHolidays(id);
		return Response.status(Status.OK).entity(b).build();

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateHolidays(Holidays h) {
		hs.updateHolidays(h);
		return Response.status(Status.OK).entity("update successful").build();
	}

}
