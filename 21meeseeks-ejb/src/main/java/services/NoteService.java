package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Note;
import interfaces.NoteServiceLocal;
import interfaces.NoteServiceRemote;

/**
 * Session Bean implementation class NoteService
 */
@Stateless
@LocalBean
public class NoteService implements NoteServiceRemote, NoteServiceLocal {

	@PersistenceContext(unitName = "21meeseeks-ejb")
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public NoteService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addNote(Note n) {
		em.persist(n);
		return n.getIdNote();
	}

	@Override
	public Note findNote(int id) {
		Note n = em.find(Note.class, id);
		return n;
	}

	@Override
	public Boolean deleteNote(int id) {
		Note n = em.find(Note.class, id);
		em.remove(n);
		return true;
	}

	@Override
	public void updateNote(Note n) {
		Note note = em.find(Note.class, n.getIdNote());
		note = n;
		em.merge(note);

	}

	@Override
	public List<Note> getAllNote() {
		TypedQuery<Note> q = em.createQuery("SELECT n FROM Note n", Note.class);
		List<Note> listNote = q.getResultList();
		return listNote;
	}

}
