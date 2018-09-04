package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Iznajmljivanje {
	
	private Date danIzdavanja;
	private Date danIsteka;
	private TipBoravka tipBoravka;
	private double cenaUkupna;
	private Soba iznajmljenaSoba;
	private ArrayList<String> gosti = new ArrayList<String>();
	private boolean aktivnost;
	private String korisnickoIme;
	
	
	public Iznajmljivanje(){
		
	}
	public Iznajmljivanje(Date danIzdavanja, Date danIsteka, TipBoravka tipBoravka,	double cenaUkupna, Soba iznajmljenaSoba, ArrayList<String> gosti, boolean aktivnost,String korisnickoIme) {
		super();
		this.danIzdavanja = danIzdavanja;
		this.danIsteka = danIsteka;
		this.tipBoravka = tipBoravka;
		this.cenaUkupna = cenaUkupna;
		this.iznajmljenaSoba = iznajmljenaSoba;
		this.gosti = gosti;
		this.aktivnost = aktivnost;
		this.korisnickoIme = korisnickoIme;
	}

	public Date getDanIzdavanja() {
		return danIzdavanja;
	}

	public void setDanIzdavanja(Date danIzdavanja) {
		this.danIzdavanja = danIzdavanja;
	}

	public Date getDanIsteka() {
		return danIsteka;
	}

	
	public void setDanIsteka(Date danIsteka) {
		this.danIsteka = danIsteka;
	}

	public TipBoravka getTipBoravka() {
		return tipBoravka;
	}

	public void setTipBoravka(TipBoravka tipBoravka) {
		this.tipBoravka = tipBoravka;
	}

	public double getCenaUkupna() {
		return cenaUkupna;
	}

	public void setCenaUkupna(double cenaUkupna) {
		this.cenaUkupna = cenaUkupna;
	}

	public Soba getIznajmljenaSoba() {
		return iznajmljenaSoba;
	}

	public void setIznajmljenaSoba(Soba iznajmljenaSoba) {
		this.iznajmljenaSoba = iznajmljenaSoba;
	}

	public ArrayList<String> getGosti() {
		return gosti;
	}

	public void setGosti(ArrayList<String> gosti) {
		this.gosti = gosti;
	}

	public boolean isAktivnost() {
		return aktivnost;
	}

	public void setAktivnost(boolean aktivnost) {
		this.aktivnost = aktivnost;
	}
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	public String toFile() {

		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy. HH.mm");
		String datumP = sdf.format(danIzdavanja);
		String datumK = sdf.format(danIsteka);
		String sadrzaj = "";
		sadrzaj += datumP + "|" + datumK + "|" + getTipBoravka().toString().toLowerCase() + "|"
				 + "|" + cenaUkupna + "|" + iznajmljenaSoba.getBrSobe() + "|"
				+ gostiToFile(this.gosti) + "|" + aktivnost +"|" + korisnickoIme;
		return sadrzaj;
	}
	

	
	public String gostiToFile(ArrayList<String> gosti) {
		String sadrzaj = "";
		for (int i = 0; i < gosti.size(); i++) {
			
			sadrzaj += DataBase.gosti.get(gosti.get(i)).getBrojLK() + ";";
		}
		return sadrzaj;

	}
	
	@Override
	public String toString() {
		return danIzdavanja + "|" + danIsteka + "|" + tipBoravka  + "|" + cenaUkupna  + "|" +  iznajmljenaSoba  + "|" +  gosti + "|" +  aktivnost  + "|" +  korisnickoIme;
	}



	
}

	