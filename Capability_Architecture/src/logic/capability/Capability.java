package logic.capability;

public class Capability {
	String name;
	
	public enum Catagorisation {HYGENE ,COMPETE, DIFFERENTIATOR};
	
	Catagorisation Catagory;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Catagorisation getCatagory() {
		return Catagory;
	}

	public void setCatagory(Catagorisation catagory) {
		Catagory = catagory;
	}

}
