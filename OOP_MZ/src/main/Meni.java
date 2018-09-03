package main;

import java.util.Scanner;

import model.DataBase;
import model.Korisnik;

public class Meni {
	static String tipKorisnika = "";
	
	
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
				tipKorisnika = "admin";  //setovanje privilegija
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
						tipKorisnika = DataBase.korisnici.get(key).getTipKorisnika();
						System.out.println(tipKorisnika);
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
