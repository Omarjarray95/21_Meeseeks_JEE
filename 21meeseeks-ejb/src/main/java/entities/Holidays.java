package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Holidays implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idHolidays;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date endDate;
	private String description;
	
	

	public Holidays() {
		
	}

	public int getIdHolidays() {
		return idHolidays;
	}

	public void setIdHolidays(int idHolidays) {
		this.idHolidays = idHolidays;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idHolidays;
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
		Holidays other = (Holidays) obj;
		if (idHolidays != other.idHolidays)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Holidays [idHolidays=" + idHolidays + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", description=" + description + "]";
	}
	

}
