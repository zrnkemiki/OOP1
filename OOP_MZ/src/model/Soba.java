package model;

public class Soba {

	private int brSobe;
	private int tipSobeID;
	private boolean tv;
	private boolean miniBar;
	private boolean aktivnost;
	
	
	public Soba() {
	}
	
	public Soba(int brSobe,int tipSobeID, boolean tv, boolean miniBar, boolean aktivnost) {
		this.brSobe = brSobe;
		this.tipSobeID = tipSobeID;
		this.tv = tv;
		this.miniBar = miniBar;
		this.aktivnost = aktivnost;
	}

	public int getBrSobe() {
		return brSobe;
	}

	public void setBrSobe(int brSobe) {
		this.brSobe = brSobe;
	}

	public int getTipSobeID() {
		return tipSobeID;
	}

	public void setTipSobeID(int tipSobeID) {
		this.tipSobeID = tipSobeID;
	}

	public boolean isTv() {
		return tv;
	}

	public void setTv(boolean tv) {
		this.tv = tv;
	}

	public boolean isMiniBar() {
		return miniBar;
	}

	public void setMiniBar(boolean miniBar) {
		this.miniBar = miniBar;
	}

	public boolean isAktivnost() {
		return aktivnost;
	}

	public void setAktivnost(boolean aktivnost) {
		this.aktivnost = aktivnost;
	}

	@Override
	public String toString() {
		return brSobe + "|" + tipSobeID + "|" + tv + "" + miniBar + "|"  + aktivnost;
	}
}
