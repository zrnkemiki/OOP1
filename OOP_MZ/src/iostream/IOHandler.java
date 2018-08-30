package iostream;

import java.util.Scanner;

public class IOHandler {
	static Scanner input = new Scanner(System.in);

	public static String unosBrojLK() {
		System.out.println("Unesite broj licne karte: ");
		while (true) {
			String brojLK = input.nextLine();		
			if (brojLK == "") {
				System.out.println("Broj licne karte ne moze biti prazno polje.");
				continue;
			} else if (brojLK.length() != 9) {
				System.out.println("Broj licne karte mora sadrzati 9 cifara.");
				continue;
			} else {
				return brojLK;
			}

		}
	}

	public static String unosImena() {		
		System.out.println("Unesite ime: ");
		while (true) {
			String ime = input.nextLine();
			if (ime == "") {
				System.out.println("Ime ne moze biti prazno polje.");
				continue;
			} else if (!ime.matches("[a-zA-Z]+")) {
				System.out.println("Ime moze sadrzati samo mala i velika slova.");
				continue;
			} else {
				return ime;
			}
		}

	}

	public static String unosPrezimena() {
		System.out.println("Unesite Prezime: ");
		while (true) {
			String prezime = input.nextLine();

			if (prezime == "") {
				System.out.println("Prezime ne moze biti prazno polje.");
				continue;
			} else if (!prezime.matches("[a-zA-Z]+")) {
				System.out.println("Prezime moze sadrzati samo mala i velika slova.");
				continue;
			} else {
				return prezime;
			}
		}

	}
	
	public static String unosKorisnickoIme() {
		System.out.println("Unesite korisnicko ime: ");
		while (true) {
			String korisnickoIme = input.nextLine();
			if (korisnickoIme == "") {
				System.out.println("Korisnicko ime ne moze biti prazno polje.");
				continue;
			} else {
				return korisnickoIme;
			}
		}
	}
	
	public static String unosLozinke() {		
		System.out.println("Unesite lozinku: ");
		while (true) {
			String lozinka = input.nextLine();
			if (lozinka == "") {
				System.out.println("Lozinka ne moze biti prazno polje.");
				continue;
			} else {
				return lozinka;
			}
		}

	}
	
	public static String unosTipaKorisnika() {		
		System.out.println("Unesite tip korinsika: ");
		while(true) {
			System.out.println("Korisnik moze biti menadzer i prodavac.");
			String tipKorisnika = input.nextLine();
			if (tipKorisnika.equals("")) {
				System.out.println("Tip korisnika ne moze biti prazno polje.");
				continue;
			}else if(tipKorisnika.toLowerCase().equals("menadzer") || tipKorisnika.toLowerCase().equals("prodavac")) {
				return tipKorisnika;
			}else {
				//System.out.println(tipKorisnika);
				System.out.println("Korisnik mora biti menadzer ili prodavac.");
				
				
			}
		}
		
	}
	
	public static boolean unosBoolean() {
		System.out.println("Unesite TRUE ili FALSE vrednost.");
		while(true) {
			String aktivnostTemp = input.nextLine();
			boolean aktivnost;
			if (aktivnostTemp.equals("")){
				System.out.println("Morate uneti vrednost.");
				continue;
			}else if(aktivnostTemp.equalsIgnoreCase("true") || aktivnostTemp.equalsIgnoreCase("false")){
				aktivnost = Boolean.valueOf(aktivnostTemp);
				return aktivnost;
			}else {
				System.out.println("Los unos.\n");
			}
		}
	}

	public static int unosInt() {
		String unos;
		int broj;
		while (true)
		{
			unos = input.nextLine();
			try {
				broj = Integer.parseInt(unos);
				break;
			} catch (Exception e) {
				System.out.println("Dozvoljen je samo unos brojeva.");
			}
			
		}
		return broj;
	}
	
	public static String unosTipaSobeNaziv() {
		System.out.println("Unesite naziv tipa sobe: ");
		while (true) {
			String nazivSobe = input.nextLine();
			if (nazivSobe == "") {
				System.out.println("Ime ne moze biti prazno polje.");
				continue;
			} else if (!nazivSobe.matches("[a-zA-Z]+")) {
				System.out.println("Ime moze sadrzati samo mala i velika slova.");
				continue;
			} else {
				return nazivSobe;
			}
		}
	}
	


}
