package model;

public class Area {
	private int id;
	private String name;
	
	public Area() {
		super();
	}
	public Area(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id+" - "+name;
	}
	
	
}
