package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Establishment implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEstablishment;
	private String nameEstablishment;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	private String diplome;
	private String description;

	public int getIdEstablishment() {
		return idEstablishment;
	}

	public void setIdEstablishment(int idEstablishment) {
		this.idEstablishment = idEstablishment;
	}

	public String getNameEstablishment() {
		return nameEstablishment;
	}

	public void setNameEstablishment(String nameEstablishment) {
		this.nameEstablishment = nameEstablishment;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
