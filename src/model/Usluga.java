package model;

public class Usluga {
	private int id;
	private double cena;
	private String naziv;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	@Override
	public String toString() {
		return "Usluga [id=" + id + ", cena=" + cena + ", naziv=" + naziv + "]";
	}
	
	 
	

}
