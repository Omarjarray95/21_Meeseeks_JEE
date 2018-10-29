package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class TermArchive implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTermArchive;
	@OneToOne
	private Term term;
	
	public int getIdTermArchive() {
		return idTermArchive;
	}
	public void setIdTermArchive(int idTermArchive) {
		this.idTermArchive = idTermArchive;
	}
	public Term getTerm() {
		return term;
	}
	public void setTerm(Term term) {
		this.term = term;
	}
	
	
}
