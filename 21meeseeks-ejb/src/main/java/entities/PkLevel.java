package entities;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class PkLevel implements Serializable {
	private int idResource;
	private int idCompetence;
	

	
	
	public int getIdResource() {
		return idResource;
	}
	public void setIdResource(int idResource) {
		this.idResource = idResource;
	}
	public int getIdCompetence() {
		return idCompetence;
	}
	public void setIdCompetence(int idCompetence) {
		this.idCompetence = idCompetence;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCompetence;
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
		PkLevel other = (PkLevel) obj;
		if (idCompetence != other.idCompetence)
			return false;
		if (idResource != other.idResource)
			return false;
		return true;
	}

	
	

}
