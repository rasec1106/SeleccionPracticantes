package model;

public class Prueba {
	private int id;
	private String name;
	private Candidato[] candidates;
	
	public Prueba() {
		super();
	}
	public Prueba(int id, String name, Candidato[] candidates) {
		super();
		this.id = id;
		this.name = name;
		this.candidates = candidates;
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
	public Candidato[] getCandidates() {
		return candidates;
	}
	public void setCandidates(Candidato[] candidates) {
		this.candidates = candidates;
	}

}
