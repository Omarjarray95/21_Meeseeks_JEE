package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Establishment;


@Local
public interface EstablishmentServiceLocal {
	public int addEstablishment(Establishment e);
	public Establishment findEstablishment(int id);
	public Boolean deleteEstablishment(int id);
	public void updateEstablishment(Establishment e);
	public List<Establishment> getAllEstablishment();

}
