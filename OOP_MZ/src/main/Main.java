package main;

import java.util.Scanner;

import iostream.GostIO;
import iostream.KorisnikIO;
import iostream.SobaIO;
import iostream.TipSobeIO;
import model.DataBase;
import model.Korisnik;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KorisnikIO.ucitavanjeKorisnika();
		GostIO.ucitajGoste();
		SobaIO.ucitavanjeSoba();
		TipSobeIO.ucitajTipSobe();
		
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
		
		Korisnik miso = logovanje();
		System.out.println("________________________________________________");
		System.out.println(miso.toString());
		
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
	
	public static Korisnik logovanje() {
		Korisnik temp = new Korisnik();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		String korisnickoIme;
		String lozinka;
		boolean aktivan;
		
		while(true) {
			aktivan = true;
			System.out.println("Unesite korisnicko ime");
			korisnickoIme = input.nextLine();
			if (korisnickoIme == "") {
				System.out.println("Korisnicko ime ne moze biti prazno polje.");
				continue;
			}
			System.out.println("unesite lozinku");
			lozinka = input.nextLine();
			
			if (lozinka == "") {
				System.out.println("Lozinka ne moze biti prazno polje.");
				continue;
			}
			
			
			//__________________ADMIN LOGIN____________
			if(korisnickoIme.equals("admin") && lozinka.equals("admin")) {
				System.out.println("adminske privilegije");
				aktivan = false;
			}
			//______________USERS LoGIN___________________
			for(String key : DataBase.korisnici.keySet()) {
				if(DataBase.korisnici.get(key).getKorisnickoIme().equals(korisnickoIme) && DataBase.korisnici.get(key).getLozinka().equals(lozinka)) {
					if(!DataBase.korisnici.get(key).isAktivnost()) {
						System.out.println("Podaci koje ste uneli su ispravni ali korisnik nije aktivan u sistemu.");
						aktivan = false;
					}
					else {
						System.out.println("Uspesno ste se logovali kao" + DataBase.korisnici.get(key).getIme());
						temp = DataBase.korisnici.get(key);
						aktivan = false;
						return temp;
					}				
				}
			}	
			
			if(aktivan) {
				System.out.println("Korisnicko ime/Lozinka nisu dobri.");
			}
			else
				continue;				
		}
				
	}

}
