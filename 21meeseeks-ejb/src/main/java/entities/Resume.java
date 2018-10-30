package entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Resume implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idResume;

	private String description;

	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Establishment> etablissement = new HashSet<Establishment>();

	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Society> society = new HashSet<Society>();

	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Certificate> certificates = new HashSet<Certificate>();

	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Competence> competence = new HashSet<Competence>();

	public Resume() {

	}

	public int getIdResume() {
		return idResume;
	}

	public void setIdResume(int idResume) {
		this.idResume = idResume;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idResume;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Resume other = (Resume) obj;
		if (idResume != other.idResume)
			return false;
		return true;
	}

}
