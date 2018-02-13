package model;

public class Veterinar {
	private int idVeterinar;
	private String ime;
	private String prezime;
	private int telefon;
 
	public Veterinar()
	{
		
	}
	public Veterinar(String ime, String prezime, int telefon) {
		 
		this.ime = ime;
		this.prezime = prezime;
		this.telefon = telefon;
	}

	public int getIdVeterinar() {
		return idVeterinar;
	}

	public void setIdVeterinar(int idVeterinar) {
		this.idVeterinar = idVeterinar;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public int getTelefon() {
		return telefon;
	}

	@Override
	public String toString() {
		return "Veterinar [idVeterinar=" + idVeterinar + ", ime=" + ime + ", prezime=" + prezime + ", telefon="
				+ telefon + "]";
	}
	
	public int compareTo(Object otherObject) {
		
		Veterinar vet = (Veterinar) otherObject;
		if(this.prezime.compareTo(vet.prezime) == -1) { return -1;}		
		if(this.prezime.compareTo(vet.prezime) == 0) {return 0;}
		return 1;
	}
	

}
 