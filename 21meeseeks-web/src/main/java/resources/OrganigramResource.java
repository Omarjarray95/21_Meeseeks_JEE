package resources;

import interfaces.ClientServiceLocal;
import interfaces.OrganigramServiceLocal;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import entities.Organigram;
@Path("organigram")
public class OrganigramResource {
	@EJB(beanName="OrganigramService")
	OrganigramServiceLocal OSL;
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addOrganigram(Organigram o)
	{
		
		return Response.status(Status.CREATED).entity(OSL.addOrganigram(o)).build();

	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response showAllOrganigrams()
	{
		return Response.status(Status.CREATED).entity(OSL.showAllOrganigrams()).build();

	}
}
