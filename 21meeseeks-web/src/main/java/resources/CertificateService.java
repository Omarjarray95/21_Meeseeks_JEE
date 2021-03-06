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

import entities.Certificate;
import interfaces.CertificateServiceLocal;

@Path("certificate")
@RequestScoped
public class CertificateService {
	@EJB
	CertificateServiceLocal cs;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCertificate(Certificate c) {
		if (c != null) {
			int i = cs.addCertificate(c);
		}
		return Response.status(Status.CREATED).entity("ok").build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCertificate() {
		List<Certificate> list = new ArrayList<>();
		list = cs.getAllCertificate();
		return Response.status(Status.FOUND).entity(list).build();

	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchCertificate(@PathParam(value = "id") int id) {
		Certificate c = cs.findCertificate(id);
		return Response.status(Status.FOUND).entity(c).build();
	}

	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCertificate(@PathParam(value = "id") int id) {
		Boolean b = cs.deleteCertificate(id);
		return Response.status(Status.FOUND).entity(b).build();

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCertificate(Certificate c) {
		cs.updateCertificate(c);
		return Response.status(Status.OK).entity("update successful").build();
	}

}
