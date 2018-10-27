package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Level  implements Serializable{
	@EmbeddedId
	private PkLevel pkLevel;
	private int level;
	private int yearsExperience;
	@ManyToOne
	@JoinColumn(name="idResource",referencedColumnName="idUser",insertable=false,updatable=false)
	private Resource resources;
	@ManyToOne
	@JoinColumn(name="idCompetence",referencedColumnName="idCompetence",insertable=false,updatable=false)
	private Competence competences;
	
	
	
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
	
	  	

}
