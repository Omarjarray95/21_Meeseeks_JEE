package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Certificate implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCertificate;
	private String descriptionCertificate;
	
	
	
	public Certificate() {
		
	}

	public int getIdCertificate() {
		return idCertificate;
	}

	public void setIdCertificate(int idCertificate) {
		this.idCertificate = idCertificate;
	}

	public String getDescriptionCertificate() {
		return descriptionCertificate;
	}
	

	public void setDescriptionCertificate(String descriptionCertificate) {
		this.descriptionCertificate = descriptionCertificate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCertificate;
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
		Certificate other = (Certificate) obj;
		if (idCertificate != other.idCertificate)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Certificate [idCertificate=" + idCertificate + ", descriptionCertificate=" + descriptionCertificate
				+ "]";
	}
	
	

	
}
