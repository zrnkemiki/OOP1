package model;

public class TipSobe {

	private int idTipaSobe;
	private String nazivSobe;
	private int brojKreveta;
	boolean aktivnost;
	
	public TipSobe() {
		
	}
	
	public TipSobe(int idTipaSobe, String nazivSobe, int brojKreveta, boolean aktivnost) {
		super();
		this.idTipaSobe = idTipaSobe;
		this.nazivSobe = nazivSobe;
		this.brojKreveta = brojKreveta;
		this.aktivnost = aktivnost;
	}

	public int getIdTipaSobe() {
		return idTipaSobe;
	}

	public void setIdTipaSobe(int idTipaSobe) {
		this.idTipaSobe = idTipaSobe;
	}

	public String getNazivSobe() {
		return nazivSobe;
	}

	public void setNazivSobe(String nazivSobe) {
		this.nazivSobe = nazivSobe;
	}

	public int getBrojKreveta() {
		return brojKreveta;
	}

	public void setBrojKreveta(int brojKreveta) {
		this.brojKreveta = brojKreveta;
	}

	public boolean isAktivnost() {
		return aktivnost;
	}

	public void setAktivnost(boolean aktivnost) {
		this.aktivnost = aktivnost;
	}
	
	@Override
	public String toString() {
		return idTipaSobe + "|" + nazivSobe + "|" + brojKreveta + "|" + aktivnost;
	}


	
}
