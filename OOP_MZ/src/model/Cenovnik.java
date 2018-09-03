package model;

public class Cenovnik {
	
	private int idTipaSobe;
	private int cenaDnevniBoravak;
	private int cenaNocenje;
	private int vikendPoskupljenje;
	
	
	public Cenovnik(){}
	
	public Cenovnik(int idTipaSobe, int cenaDnevniBoravak, int cenaNocenje, int vikendPoskupljenje) {
		super();
		this.idTipaSobe = idTipaSobe;
		this.cenaDnevniBoravak = cenaDnevniBoravak;
		this.cenaNocenje = cenaNocenje;
		this.vikendPoskupljenje = vikendPoskupljenje;
	}
	
	public int getIdTipaSobe() {
		return idTipaSobe;
	}
	public void setIdTipaSobe(int idTipaSobe) {
		this.idTipaSobe = idTipaSobe;
	}
	public int getCenaDnevniBoravak() {
		return cenaDnevniBoravak;
	}
	public void setCenaDnevniBoravak(int cenaDnevniBoravak) {
		this.cenaDnevniBoravak = cenaDnevniBoravak;
	}
	public int getCenaNocenje() {
		return cenaNocenje;
	}
	public void setCenaNocenje(int cenaNocenje) {
		this.cenaNocenje = cenaNocenje;
	}
	public int getVikendPoskupljenje() {
		return vikendPoskupljenje;
	}
	public void setVikendPoskupljenje(int vikendPoskupljenje) {
		this.vikendPoskupljenje = vikendPoskupljenje;
	}
	
	public String toString() {
		return idTipaSobe + "|" + cenaDnevniBoravak + "|" + cenaNocenje + "|" + vikendPoskupljenje;
	}
}
