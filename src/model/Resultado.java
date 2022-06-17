 package model;

public class Resultado {
	
	private Candidato candidate;
	private Prueba test;
	private int score;
	
	public Resultado() {
		super();
	}
	public Resultado(Candidato candidate, Prueba test, int score) {
		super();
		this.candidate = candidate;
		this.test = test;
		this.score = score;
	}
	public Candidato getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidato candidate) {
		this.candidate = candidate;
	}
	public Prueba getTest() {
		return test;
	}
	public void setTest(Prueba test) {
		this.test = test;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}
