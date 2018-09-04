package main;


import java.util.ArrayList;
import java.util.Collections;

import iostream.CenovnikIO;
import iostream.GostIO;
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
		
		
		//Pregledi.pregledKorisnika();
		Korisnik korisnik = new Korisnik();
		
		//korisnik = Meni.logovanje();
		Meni.start();
	
	}
}
