package resources;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import entities.Resource;
import entities.Term;
import interfaces.ArchiveServiceLocal;
import interfaces.MandatServiceLocal;
import models.CompetenceAvailabilityModel;
@Stateless
@Path(value = "mandats")
public class MandatResource {

	@EJB
	private MandatServiceLocal mondatServiceLocal;
	@EJB
	private ArchiveServiceLocal archiveServiceLocal;

	@POST
	@Path("list")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response listResource(CompetenceAvailabilityModel model) {

  
				List<Resource> list = mondatServiceLocal.findResourceByCompetenceAndAvailability(model.getCompetence()
						, model.getAvailables());
		return Response.status(Status.ACCEPTED).entity(list).build();
	}
	
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response AddArchiveMondat(Term term){
		
		archiveServiceLocal.AddArchiveTerm(term);
	 return Response.status(Status.CREATED).entity("ok").build();
		
	}


	
}
	
	
	

