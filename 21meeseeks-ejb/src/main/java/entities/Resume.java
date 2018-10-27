package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.ws.rs.ext.ParamConverter.Lazy;

@Entity
public class Resume implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idResume;
	@OneToOne(mappedBy = "resume")
	private Resource resource;
	private String description;
	@ManyToMany(fetch=FetchType.EAGER)
	private Set<Establishment> etablissement;
	@ManyToMany(fetch=FetchType.EAGER)
	private Set<Society> society;
	@ManyToMany(fetch=FetchType.EAGER)
	private Set<Certificate> certificates;
	@ManyToMany(fetch=FetchType.EAGER)
	private Set<Competence> competence;

	public int getIdResume() {
		return idResume;
	}

	public void setIdResume(int idResume) {
		this.idResume = idResume;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public Set<Establishment> getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(Set<Establishment> etablissement) {
		this.etablissement = etablissement;
	}

	public Set<Society> getSociety() {
		return society;
	}

	public void setSociety(Set<Society> society) {
		this.society = society;
	}

	public Set<Certificate> getCertificates() {
		return certificates;
	}

	public void setCertificates(Set<Certificate> certificates) {
		this.certificates = certificates;
	}

	public Set<Competence> getCompetence() {
		return competence;
	}

	public void setCompetence(Set<Competence> competence) {
		this.competence = competence;
	}

	

	
}
