package model;

public class Sala {
	
	public int numSala;

	public Sala(int numSala) {
		super();
		this.numSala = numSala;
	}

	public Sala(Sala s) {
		super();
		this.numSala = s.numSala;
	}

	public Sala() {
		super();
	}

	public int getNumSala() {
		return numSala;
	}

	public void setNumSala(int numSala) {
		this.numSala = numSala;
	}

	@Override
	public String toString() {
		return "Sala [numSala=" + numSala + "]";
	}
	
	

}
