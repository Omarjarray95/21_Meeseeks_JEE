package interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Note;

@Local
public interface NoteServiceLocal {
	public int addNote(Note n);
	public Note findNote(int id);
	public Boolean deleteNote(int id);
	public void updateNote(Note n);
	public List<Note> getAllNote();

}
