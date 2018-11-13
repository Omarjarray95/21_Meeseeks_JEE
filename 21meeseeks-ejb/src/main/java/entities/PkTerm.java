package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PkTerm implements Serializable{

	private int idResource;
	private int idProject;

	public int getIdResource() {
		return idResource;
	}
	public void setIdResource(int idResource) {
		this.idResource = idResource;
	}
	public int getIdProject() {
		return idProject;
	}
	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idProject;
		result = prime * result + idResource;
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
		PkTerm other = (PkTerm) obj;
		if (idProject != other.idProject)
			return false;
		if (idResource != other.idResource)
			return false;
		
		return true;
	}
	
	
}
