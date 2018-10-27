package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Certificate;

@Local
public interface CertificateServiceLocal {
	public int addCertificate(Certificate c);
	public Certificate findCertificate(int id);
	public Boolean deleteCertificate(int id);
	public void updateCertificate(Certificate c);
	public List<Certificate> getAllCertificate();

}
