package model;

public class Gost {
	private String ime;
	private String prezime;
	private String brojLK;
	private boolean aktivnost;

	public Gost() {

	}

	public Gost(String ime, String prezime, String brojLK, boolean aktivnost) {
		this.ime = ime;
		this.prezime = prezime;
		this.brojLK = brojLK;
		this.aktivnost = aktivnost;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getBrojLK() {
		return brojLK;
	}

	public void setBrojLK(String brojLK) {
		this.brojLK = brojLK;
	}

	public boolean isAktivnost() {
		return aktivnost;
	}

	public void setAktivnost(boolean aktivnost) {
		this.aktivnost = aktivnost;
	}

	@Override
	public String toString() {
		return ime + "|" + prezime + "|" + brojLK + "|" + aktivnost;
	}
	

}	
