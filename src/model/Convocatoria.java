package model;

public class Convocatoria {
	
	private String id;
	private String name;
	private String description;
	private String startDate;
	private String endDate;
	private String position;
	private Area area;
	private Candidato[] candidates;
	private Prueba test;
	private Resultado[] results;
	
	public Convocatoria() {
		super();
	}
	public Convocatoria(String id, String name, String description, String startDate, String endDate, String position,
			Area area) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.position = position;
		this.area = area;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public Candidato[] getCandidates() {
		return candidates;
	}
	public void setCandidates(Candidato[] candidates) {
		this.candidates = candidates;
	}
	public Prueba getTest() {
		return test;
	}
	public void setTest(Prueba test) {
		this.test = test;
	}
	public Resultado[] getResults() {
		return results;
	}
	public void setResults(Resultado[] results) {
		this.results = results;
	}

}
