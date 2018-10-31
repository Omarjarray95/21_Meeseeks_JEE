package resources;

import java.util.Date;
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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

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
	@Produces(MediaType.APPLICATION_JSON)
	public Response calculFinMandat(Term term){
		
		 Term t= mondatServiceLocal.calculateEndDateTerm(term);
	
		return Response.status(Status.ACCEPTED).entity(t).build();
	}
	
	@POST
	@Path(value="/frais")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response frasiMondat(Term term){
		
		 float t= mondatServiceLocal.fraisMandat(term);
	
		return Response.status(Status.ACCEPTED).entity(t).build();
	}
	
	@POST
	@Path(value="/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMandat(Term term){
		
		 mondatServiceLocal.addTerm(term);
	
		return Response.status(Status.ACCEPTED).entity("ok").build();
	}

	
}
	
	
	

