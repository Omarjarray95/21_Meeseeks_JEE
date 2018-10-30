package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Resource;
import enums.Availability;
import enums.ContractType;

@Local
public interface ResourceServiceLocal {

	//public int ajoutRessource(Resource r);
	public Resource findResource(int id);
	public Boolean deleteResource(int id);
	public void updateResource(Resource r);
	public List<Resource> getAllResource();
	//int ajoutRessource(Resource r, int idResume);
	int ajoutRessource(Resource r);
	public int lastIndex();
	//public List<Resource> getResourceByType(String type);
	List<Resource> getResourceByType(ContractType type);
	List<Resource> getResourceByAvaibility(Availability avaib);
}
