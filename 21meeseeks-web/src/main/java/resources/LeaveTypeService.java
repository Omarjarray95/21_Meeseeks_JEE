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

import entities.LeaveType;
import interfaces.LeaveTypeServiceLocal;

@Path("leaveType")
@RequestScoped
public class LeaveTypeService {
	@EJB
	LeaveTypeServiceLocal lt;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addLeaveType(LeaveType l){
		if(l!=null){
			int i=lt.addLeaveType(l);
		}
		return Response.status(Status.CREATED).entity("ok").build();
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllLeaveType(){
		List<LeaveType> list=new ArrayList<>();
		list=lt.getAllLeaveType();
		return Response.status(Status.FOUND).entity(list).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchLeaveType(@PathParam(value = "id") int id){
		LeaveType l =lt.findLeaveType(id);
		return Response.status(Status.FOUND).entity(l).build();
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteLeaveType(@PathParam(value = "id") int id){
		Boolean b=lt.deleteLeaveType(id);
		return Response.status(Status.OK).entity(b).build();
		
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateLeaveType(LeaveType l){
		lt.updateLeaveType(l);
		return Response.status(Status.OK).entity("update successful").build();
		
	}

}
