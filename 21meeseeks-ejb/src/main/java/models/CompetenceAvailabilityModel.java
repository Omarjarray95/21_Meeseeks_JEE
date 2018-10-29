package models;

import java.util.EnumSet;

import entities.Competence;
import enums.Availability;

public class CompetenceAvailabilityModel {
	
	
	private Competence competence ;
	private EnumSet<Availability>availables ;
	
	
	
	
	public CompetenceAvailabilityModel() {
		
	}
	public Competence getCompetence() {
		return competence;
	}
	public void setCompetence(Competence competence) {
		this.competence = competence;
	}
	public EnumSet<Availability> getAvailables() {
		return availables;
	}
	public void setAvailables(EnumSet<Availability> availables) {
		this.availables = availables;
	}
	
	
	

}
