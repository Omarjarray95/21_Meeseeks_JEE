package resources;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import entities.Term;
import interfaces.ArchiveServiceLocal;

@Stateless
@Path("archives")
public class ArchiveResource {
	@EJB
	private ArchiveServiceLocal archiveServiceLocal;
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response AddArchiveMondat(Term term){
		
		archiveServiceLocal.AddArchiveTerm(term);
	 return Response.status(Status.CREATED).entity("ok").build();
		
	}
	
	

}
