package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Level  implements Serializable{
	@EmbeddedId
	private PkLevel pkLevel;
	private int level;
	private int yearsExperience;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idResource",referencedColumnName="idUser",insertable=false,updatable=false)
	@JsonIgnore
	private Resource resources;
	@ManyToOne
	@JoinColumn(name="idCompetence",referencedColumnName="idCompetence",insertable=false,updatable=false)
	@JsonIgnore
	private Competence competences;
	
	
	public Level() {
		
	}
	public Resource getResources() {
		return resources;
	}
	public void setResources(Resource resources) {
		this.resources = resources;
	}
	public Competence getCompetences() {
		return competences;
	}
	public void setCompetences(Competence competences) {
		this.competences = competences;
	}
	public PkLevel getPkLevel() {
		return pkLevel;
	}
	public void setPkLevel(PkLevel pkLevel) {
		this.pkLevel = pkLevel;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getYearsExperience() {
		return yearsExperience;
	}
	public void setYearsExperience(int yearsExperience) {
		this.yearsExperience = yearsExperience;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((competences == null) ? 0 : competences.hashCode());
		result = prime * result + level;
		result = prime * result + ((pkLevel == null) ? 0 : pkLevel.hashCode());
		result = prime * result + ((resources == null) ? 0 : resources.hashCode());
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
		Level other = (Level) obj;
		if (competences == null) {
			if (other.competences != null)
				return false;
		} else if (!competences.equals(other.competences))
			return false;
		if (level != other.level)
			return false;
		if (pkLevel == null) {
			if (other.pkLevel != null)
				return false;
		} else if (!pkLevel.equals(other.pkLevel))
			return false;
		if (resources == null) {
			if (other.resources != null)
				return false;
		} else if (!resources.equals(other.resources))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Level [pkLevel=" + pkLevel + ", level=" + level + ", yearsExperience=" + yearsExperience
				+ ", resources=" + resources + ", competences=" + competences + "]";
	}
	
	
	
	  	

}
