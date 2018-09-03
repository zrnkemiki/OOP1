package main;

import java.util.Scanner;

import iostream.CenovnikIO;
import iostream.GostIO;
import iostream.KorisnikIO;
import iostream.SobaIO;
import iostream.TipSobeIO;
import model.Cenovnik;
import model.DataBase;
import model.Korisnik;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KorisnikIO.ucitavanjeKorisnika();
		GostIO.ucitajGoste();
		SobaIO.ucitavanjeSoba();
		TipSobeIO.ucitajTipSobe();
		CenovnikIO.ucitajCenovnik();
		
//		System.out.println("Dobro dosli u dodavanje novog korisnika.");
//		KorisnikIO.dodavanjeKorisnika();
//		KorisnikIO.azurirajKorisnike();
		
//		System.out.println("Dobro dosli u dodavanje novog gosta.");
//		GostIO.dodavanjeGost();
//		GostIO.azurirajGoste();
		
//		System.out.println("Dobro dosli u dodavanje nove sobe");
//		SobaIO.dodavanjeSoba();
//		SobaIO.azurirajSobe();
//		
//		System.out.println("Dobro dosli u dodavanje novog tipa sobe");
//		TipSobeIO.ucitajTipSobe();
//		TipSobeIO.dodavanjeTipaSobe();
//		TipSobeIO.azurirajTipSobe();	
		
		Korisnik miso = Meni.logovanje();
		System.out.println("________________________________________________");
		System.out.println(miso.toString());
		
//		System.out.println("Cenovnik");
//		CenovnikIO.dodavanjeCenovnik();
//		CenovnikIO.brisanjeCenovnika();
//		CenovnikIO.azurirajCenovnik();
		
//		System.out.println("Izmena korisnika: ");
//		KorisnikIO.izmenaKorisnika();
//		KorisnikIO.azurirajKorisnike();
		
//		System.out.println("brisanje korisnika: ");
//		KorisnikIO.brisanjeKorisnika();
//		KorisnikIO.azurirajKorisnike();
		
//		System.out.println("Izmena sobe: ");
//		SobaIO.izmenaSobe();
//		SobaIO.azurirajSobe();		
		
//		System.out.println("=====================TEST==================");
//
//		for (String key : DataBase.gosti.keySet()) {
//			
//			Gost temp = DataBase.gosti.get(key);
//			System.out.println(temp.toString());
//
//		}		
		
//		System.out.println("Izmena gosta: ");
//		GostIO.izmenaGost();
//		GostIO.azurirajGoste();
		
//		System.out.println("Izmena tipaSobe: ");
//		TipSobeIO.izmenaTipaSobe();
//		TipSobeIO.azurirajTipSobe();
		
		

//		System.out.println("=====================TEST==================");
//
//		for (String key : DataBase.korisnici.keySet()) {
//			
//			Korisnik temp = DataBase.korisnici.get(key);
//			System.out.println(temp.toString());
//
//		}

		// System.out.println(DataBase.korisnici.keySet());
		// System.out.println(DataBase.gosti.keySet());
		// System.out.println(DataBase.sobe.keySet());
	}
	
	

}
