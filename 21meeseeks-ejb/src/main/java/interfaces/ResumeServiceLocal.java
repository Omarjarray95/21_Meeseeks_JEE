package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Resume;

@Local
public interface ResumeServiceLocal {
	public int addResume(Resume r);
	public Resume findResume(int id);
	public Boolean deleteResume(int id);
	public void updateResume(Resume r);
	public List<Resume> getAllResume();
	public int lastIndex();

}
