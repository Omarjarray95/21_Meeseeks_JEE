package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Competence;
import entities.Resource;
import entities.Term;
import entities.TermArchive;
import enums.Availability;

@Local
public interface ArchiveServiceLocal {
  public void AddArchiveTerm(Term term);

}
