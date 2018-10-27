package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Resource;

@Local
public interface ResourceServiceLocal {

	public int ajoutRessource(Resource r);
	public Resource findResource(int id);
	public Boolean deleteResource(int id);
	public void updateResource(Resource r);
	public List<Resource> getAllResource();
	
}
