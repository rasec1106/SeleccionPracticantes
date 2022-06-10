package model;

public class Prueba {
	private int id;
	private String name;
	private Pregunta[] questions;
	
	public Prueba() {
		super();
	}
	public Prueba(int id, String name, Pregunta[] questions) {
		super();
		this.id = id;
		this.name = name;
		this.questions = questions;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Pregunta[] getQuestions() {
		return questions;
	}
	public void setQuestions(Pregunta[] questions) {
		this.questions = questions;
	}

}
