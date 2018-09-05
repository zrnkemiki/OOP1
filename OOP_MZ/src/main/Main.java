package main;


import iostream.CenovnikIO;
import iostream.GostIO;
import iostream.IznajmljivanjeIO;
import iostream.KorisnikIO;
import iostream.SobaIO;
import iostream.TipSobeIO;
import model.DataBase;
import model.Korisnik;


public class Main {
	
	public static boolean stanje = false;
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KorisnikIO.ucitavanjeKorisnika();
		GostIO.ucitajGoste();
		SobaIO.ucitavanjeSoba();
		TipSobeIO.ucitajTipSobe();
		CenovnikIO.ucitajCenovnik();
		IznajmljivanjeIO.ucitajIznajmljivanja();
		//System.out.println(DataBase.iznajmljivanja.size());
		
		
		//Pregledi.pregledKorisnika();
		//Korisnik korisnik = KorisnikIO.vratiKorisnikaUsername("123123123")
		//if(korisnik != null) {
		//	IznajmljivanjeIO.dodajIznajmljivanje(korisnik);
		//}
		
		
		for(String key : DataBase.iznajmljivanja.keySet()) {
			System.out.println(DataBase.iznajmljivanja.get(key).toString());
		}
		
		//korisnik = Meni.logovanje();
		Meni.start();
		for(String key : DataBase.iznajmljivanja.keySet()) {
			System.out.println(DataBase.iznajmljivanja.get(key).toString());
		}
		
		//IznajmljivanjeIO.dodajIznajmljivanje();
		//IznajmljivanjeIO.azurirajIznajmljivanja();
		
	}
}
