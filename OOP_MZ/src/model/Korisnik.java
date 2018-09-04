package model;

public class Korisnik {
	
	private String ime;
	private String prezime;
	private String brojLK; //jedinstveno
	private String korisnickoIme; //jedinstveno
	private String lozinka; //jedinstveno
	private String tipKorisnika;
	private boolean aktivnost;
	
	public Korisnik() {
	}
	//git test
	
	public Korisnik(String ime, String prezime, String brojLK, String korisnickoIme, String lozinka,
			String tipKorisnika, boolean aktivnost) {
		super();
		this.ime = ime;
		this.prezime = prezime; 
		this.brojLK = brojLK;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.tipKorisnika = tipKorisnika;
		this.aktivnost = aktivnost;
	}
	
	public void setNull() {
		this.ime = null;
		this.prezime = null; 
		this.brojLK = null;
		this.korisnickoIme = null;
		this.lozinka = null;
		this.tipKorisnika = null;
		this.aktivnost = (Boolean) null;
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

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getTipKorisnika() {
		return tipKorisnika;
	}

	public void setTipKorisnika(String tipKorisnika) {
		this.tipKorisnika = tipKorisnika;
	}

	public boolean isAktivnost() {
		return aktivnost;
	}

	public void setAktivnost(boolean aktivnost) {
		this.aktivnost = aktivnost;
	}

@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return ime  + "|" + prezime + "|" + brojLK + "|" + korisnickoIme + "|" + lozinka + "|" + this.getTipKorisnika() + "|" + aktivnost;
	}
}
