package model;

public class ListaPruebas {
	
	private int id;
	private String name;
	private String nameProposal;
	
	public ListaPruebas() {
	}
	
	public ListaPruebas(int id, String name, String nameProposal) {
		this.id = id;
		this.name = name;
		this.nameProposal = nameProposal;
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

	public String getNameProposal() {
		return nameProposal;
	}

	public void setNameProposal(String nameProposal) {
		this.nameProposal = nameProposal;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+" - "+nameProposal;
	}

}
