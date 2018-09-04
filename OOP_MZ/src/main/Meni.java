package main;

import java.util.Scanner;

import iostream.CenovnikIO;
import iostream.IOHandler;
import iostream.KorisnikIO;
import iostream.Pregledi;
import iostream.SobaIO;
import iostream.TipSobeIO;
import model.DataBase;
import model.Korisnik;

public class Meni {
	static String tipKorisnika = "";
	static Korisnik korisnik = new Korisnik();
	
	public static void start() {
		korisnik = logovanje();
		while(true)
			korisnickiMeni(korisnik);

		
	}
	
	
	public static void korisnickiMeni(Korisnik korisnik) {
		int input;
		if (korisnik.getTipKorisnika().equals("admin")) {
			System.out.println("-------------------------------------\n");
			System.out.println("1) Pregled korisnika.");
			System.out.println("2) Kreiranje menadzera");
			System.out.println("3) Izmena menadzera");
			System.out.println("4) Brisanje menadzera");
			System.out.println("0) Odjavljivanje.");
			input = izaberiMeniOpciju(5, true);
			switch (input) {
			case 1:
				System.out.println("-------------------------------------\n");
				System.out.println("1) Sortiranje korisnika po imenu");
				System.out.println("2) Sortiranje korisnika po prezimenu");
				System.out.println("3) Sortiranje korisnika po korisnickom imenu");
				System.out.println("0) Izlazak iz programa");
				input = izaberiMeniOpciju(4, true);
				if(input == 1) Pregledi.sortiranjeKorisnikaIme();
				else if(input == 2) Pregledi.sortiranjeKorisnikaPrezime();
				else if (input == 3) Pregledi.sortiranjeKorisnikaKorisnickoIme();
				else if(input == 0) {System.out.println("Dovidjenja!\n");
				System.exit(1);}
				break;
			case 2:
				KorisnikIO.dodavanjeMenadzera();
				KorisnikIO.azurirajKorisnike();
				break;
			case 3:
				KorisnikIO.izmenaKorisnika();
				KorisnikIO.azurirajKorisnike();
				break;
			case 4:
				KorisnikIO.brisanjeKorisnika();
				KorisnikIO.azurirajKorisnike();
				break;
			case 0:
				System.out.println("Uspesno ste se izlogovali. \n");
				korisnickiMeni(korisnik);
				break;
			}

		}
		else if (korisnik.getTipKorisnika().equals("menadzer")) {
			System.out.println("-------------------------------------\n");
			System.out.println("1) Rad sa korisnicima.");
			System.out.println("2) Rad sa sobama.");
			System.out.println("3) Rad sa cenovnikom.");
			System.out.println("0) Odjavljivanje.");
			
			input = izaberiMeniOpciju(4, true);
			if(input == 1) {
				System.out.println("-------------------------------------\n");
				System.out.println("1) Pregled korisnika.");
				System.out.println("2) Kreiranje menadzera");
				System.out.println("3) Kreiranje prodavca");
				System.out.println("4) Brisanje korisnika");
				System.out.println("5) Izmena korisnika");
				System.out.println("0) Odjavljivanje.");
				input = izaberiMeniOpciju(6, true);
				switch (input) {
				case 1:
					System.out.println("-------------------------------------\n");
					System.out.println("1) Sortiranje korisnika po imenu");
					System.out.println("2) Sortiranje korisnika po prezimenu");
					System.out.println("3) Sortiranje korisnika po korisnickom imenu");
					System.out.println("0) Odjavljivanje.");
					input = izaberiMeniOpciju(4, true);
					if(input == 1) Pregledi.sortiranjeKorisnikaIme();
					else if(input == 2) Pregledi.sortiranjeKorisnikaPrezime();
					else if (input == 3) Pregledi.sortiranjeKorisnikaKorisnickoIme();
					else if(input == 0) {System.out.println("Uspesno ste se izlogovali. \n");
					korisnickiMeni(korisnik);}
					break;
				case 2:
					KorisnikIO.dodavanjeMenadzera();
					KorisnikIO.azurirajKorisnike();
					break;
				case 3:
					KorisnikIO.dodavanjeProdavca();
					KorisnikIO.azurirajKorisnike();
					break;
				case 4:
					KorisnikIO.brisanjeKorisnika();
					KorisnikIO.azurirajKorisnike();
					break;
				case 5:
					KorisnikIO.izmenaKorisnika();
					KorisnikIO.azurirajKorisnike();
					break;
				case 0:
					System.out.println("Uspesno ste se izlogovali. \n");
					korisnickiMeni(korisnik);
					break;
				}
			}
			else if(input == 2) {
				System.out.println("-------------------------------------\n");
				System.out.println("1) Pregled soba.");
				System.out.println("2) Kreiranje sobe");
				System.out.println("3) Brisanje sobe");
				System.out.println("4) Izmena sobe");
				System.out.println("5) Pregled tipova soba.");
				System.out.println("6) Kreiranje tipa sobe");
				System.out.println("7) Brisanje tipa sobe");
				System.out.println("8) Izmena tipa sobe");
				System.out.println("0) Odjavljivanje.");
				input = izaberiMeniOpciju(9, true);
				switch (input) {
				case 1:
					System.out.println("-------------------------------------\n");
					System.out.println("1) Sortiranje soba po imenu");
					System.out.println("2) Sortiranje po broju krevetau");
					System.out.println("0) Izlazak iz programa");
					input = izaberiMeniOpciju(3, true);
					if(input == 1) Pregledi.sortiranjeSobeBroj();
					else if(input == 2) Pregledi.sortiranjeSobeTip();
					else if(input == 0) {System.out.println("Uspesno ste se izlogovali. \n");
					korisnickiMeni(korisnik);}
					break;
				case 2:
					SobaIO.dodavanjeSoba();
					SobaIO.azurirajSobe();
					break;
				case 3:
					SobaIO.brisanjeSoba();
					SobaIO.azurirajSobe();
					break;
				case 4:
					SobaIO.izmenaSobe();
					SobaIO.azurirajSobe();
					break;
				case 5:
					System.out.println("-------------------------------------\n");
					System.out.println("1) Sortiranje soba po imenu");
					System.out.println("2) Sortiranje po broju krevetau");
					System.out.println("0) Izlazak iz programa");
					input = izaberiMeniOpciju(3, true);
					if(input == 1) Pregledi.sortiranjeTipSobeIme();
					else if(input == 2) Pregledi.sortiranjeTipSobeBrojKreveta();
					else if(input == 0) {System.out.println("Uspesno ste se izlogovali. \n");
					korisnickiMeni(korisnik);}
					break;
				case 6:
					TipSobeIO.dodavanjeTipaSobe();
					TipSobeIO.azurirajTipSobe();
					break;
				case 7:
					TipSobeIO.brisanjeTipSoba();
					TipSobeIO.azurirajTipSobe();
					break;
				case 8:
					TipSobeIO.izmenaTipaSobe();
					TipSobeIO.azurirajTipSobe();
					break;	
				case 0:
					System.out.println("Uspesno ste se izlogovali. \n");
					korisnickiMeni(korisnik);
					break;
					}
				}
				else if(input == 3) {
					System.out.println("-------------------------------------\n");
					System.out.println("1) Pregled cenovnika.");
					System.out.println("2) Kreiranje stavke cenovnika");
					System.out.println("3) Brisanje stavke cenovnika");
					System.out.println("4) Izmena stavke cenovnika");
					System.out.println("0) Odjavljivanje.");
					input = izaberiMeniOpciju(5, true);
					switch (input) {
					case 1:
						System.out.println("Uraditi pregled cenovnika");
						//Pregled soba
						break;
					case 2:
						CenovnikIO.dodavanjeCenovnik();
						CenovnikIO.azurirajCenovnik();
						break;
					case 3:
						CenovnikIO.brisanjeCenovnika();
						CenovnikIO.azurirajCenovnik();
						break;
					case 4:
						CenovnikIO.izmenaCenovnika();
						CenovnikIO.azurirajCenovnik();
						break;
					case 0:
						System.out.println("Uspesno ste se izlogovali. \n");
						korisnickiMeni(korisnik);
						break;
					}	
				}						
		}
		else if (korisnik.getTipKorisnika().equals("recepcioner")) {
			System.out.println("meni recepcionera");
			System.out.println("-------------------------------------\n");
			System.out.println("1) Izdavanje sobe");
			System.out.println("2) Izdavanje racuna");
			System.out.println("0) Odjavljivanje.");
			input = izaberiMeniOpciju(3, true);
			switch (input) {
			case 1:
				System.out.println("Uraditi izdavanje sobe");
				//Pregled menadzera
				break;
			case 2:
				System.out.println("Uraditi racuna");
				//Pregled menadzera
				break;
			case 0:
				System.out.println("Uspesno ste se izlogovali. \n");
				korisnickiMeni(korisnik);
				break;
			}	
		}
	}
	
	public static int izaberiMeniOpciju(int range, boolean saNulom) {
		int izbor = -1;
		int unetiBroj;
		while (izbor == -1) {
			System.out.print("Zelite opciju: ");
			unetiBroj = IOHandler.unosInt();
			try {
				izbor = (unetiBroj);
			} catch (NumberFormatException e) {
				izbor = -1;
			}
			if (saNulom) {
				if (izbor < 0 || izbor >= range) {
					System.out.println("Opcija koju ste uneli ne postoji.\nPokusajte ponovo.");
					System.out.println("-------------------------------------");
					izbor = -1;
				}
			} else {
				if (izbor <= 0 || izbor > range) {
					System.out.println("Opcija koju ste uneli ne postoji.Pokusajte ponovo.");
					System.out.println("-------------------------------------");
					izbor = -1;
				}

			}
		}
		return izbor;
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
				System.out.println("Uspesno ste se ulogovali kao administrator.");
				temp.setIme("admin");
				temp.setPrezime("admin");
				temp.setKorisnickoIme("admin");
				temp.setLozinka("admin");
				temp.setTipKorisnika("admin");
				temp.setBrojLK("");
				temp.setAktivnost(true);
				aktivan = false;
				return temp;
			}
			//______________USERS LoGIN___________________
			for(String key : DataBase.korisnici.keySet()) {
				if(DataBase.korisnici.get(key).getKorisnickoIme().equals(korisnickoIme) && DataBase.korisnici.get(key).getLozinka().equals(lozinka)) {
					if(!DataBase.korisnici.get(key).isAktivnost()) {
						System.out.println("Podaci koje ste uneli su ispravni ali korisnik nije aktivan u sistemu.");
						aktivan = false;
					}
					else {
						System.out.println("Uspesno ste se logovali kao " + DataBase.korisnici.get(key).getIme() + DataBase.korisnici.get(key).getPrezime() +".");
						temp = DataBase.korisnici.get(key);
						tipKorisnika = DataBase.korisnici.get(key).getTipKorisnika();
						
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
