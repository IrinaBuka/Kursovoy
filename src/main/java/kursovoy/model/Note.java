package kursovoy.model;

import java.util.Date;

public class Note {
private Date date;
private int noteId;
private String noteName;
private String noteBody;
private int userId;

	public Note(Date date, int noteId, String noteName, String noteBody, int userId){
		this.date=date;
		this.noteId = noteId;
		this.noteName = noteName;
		this.noteBody = noteBody;
		 this.userId = userId;
		
	}

	public Note() {
		
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public String getNoteName() {
		return noteName;
	}

	public void setNoteName(String noteName) {
		this.noteName = noteName;
	}

	public String getNoteBody() {
		return noteBody;
	}

	public void setNoteBody(String noteBody) {
		this.noteBody = noteBody;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
