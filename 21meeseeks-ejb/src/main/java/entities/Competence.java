package entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
public class Competence  implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCompetence;
	private String label;
	@OneToMany(fetch=FetchType.EAGER)
	private Set<Level> levels;
	@ManyToMany(mappedBy="competences")
	private List<ProjectRequest> projectRequests;
	
	
	
	public List<ProjectRequest> getProjectRequests() {
		return projectRequests;
	}
	public void setProjectRequests(List<ProjectRequest> projectRequests) {
		this.projectRequests = projectRequests;
	}
	
	public Set<Level> getLevels() {
		return levels;
	}
	public void setLevels(Set<Level> levels) {
		this.levels = levels;
	}
	public int getIdCompetence() {
		return idCompetence;
	}
	public void setIdCompetence(int idCompetence) {
		this.idCompetence = idCompetence;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	
	
	
	

}
