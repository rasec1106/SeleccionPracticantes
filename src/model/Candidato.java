package model;

public class Candidato {
	
	private String dni;
	private String name;
	private String surname;
	private String email;
	private String birthDate;
	private String curriculum;
	
	public Candidato() {
		super();
	}
	public Candidato(String dni, String name, String surname, String email, String birthDate, String curriculum) {
		super();
		this.dni = dni;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.birthDate = birthDate;
		this.curriculum = curriculum;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getCurriculum() {
		return curriculum;
	}
	public void setCurriculum(String curriculum) {
		this.curriculum = curriculum;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return dni+" "+name+" "+surname+" "+email+" "+birthDate+" "+curriculum;
	}	

}
