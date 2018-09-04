package iostream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import main.Meni;
import model.Cenovnik;
import model.DataBase;
import model.Gost;
import model.Iznajmljivanje;
import model.Korisnik;
import model.Soba;
import model.TipBoravka;

public class IznajmljivanjeIO {
	static BufferedReader buff;
	static BufferedWriter bw;
	static FileWriter fw;

	public static Date stringDatumUcitaj(String datum) {
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy. HH.mm");
		Date datumDate = new Date();
		try {
			datumDate = format.parse(datum);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datumDate;
	}

	public static void ucitajIznajmljivanja() {

		String linija;

		try {
			buff = new BufferedReader(new InputStreamReader(new FileInputStream("Data/iznajmljivanje.txt"), "UTF-8"));
			try {
				while ((linija = buff.readLine()) != null) {

					linija = linija.trim();
					String[] parametri = linija.split("\\|");

					if (parametri.length != 8) {
						System.out.println("Ulazni fajl poseduje greske, ucitana su samo iznajmljivanja koja su ispravnog formata.");
						;
					}

					if (parametri.length == 8) {

						try {
							Date datumPocetka = stringDatumUcitaj(parametri[0].trim());
							Date datumKraja = stringDatumUcitaj(parametri[1].trim());
							TipBoravka tipBoravka = TipBoravka.valueOf(parametri[2].trim().toUpperCase());
							double ukupnaCena = Double.parseDouble(parametri[3].trim());
							int brojSobe = Integer.parseInt(parametri[4].trim());
							String gostiString = parametri[5].trim();
							String[] gostiNiz = gostiString.split("\\;");
							boolean aktivnost = Boolean.parseBoolean(parametri[6].trim());
							String korisnickoIme = parametri[7].trim();

							ArrayList<String> gosti = new ArrayList<String>();
							boolean postojiGost = true;
							for (String gost : gostiNiz) {
								// System.out.println("Gost je: " + gost);
								if (!DataBase.gosti.containsKey(gost)) {
									// ne postoji gost u bazi
									postojiGost = false;
									break;
								}
								gosti.add(gost);
							}
							// ako ne postoji, preskoci celo iznajmljivanje
							if (!postojiGost) {
								continue;
							}

							Soba soba;
							if ((soba = DataBase.sobe.get(brojSobe)) == null) {
								// preskoci ceo red
								continue;
							}

							if (DataBase.iznajmljivanja.get(korisnickoIme) == null) {
								ArrayList<Iznajmljivanje> iznajmljivanja = new ArrayList<>();
								
								iznajmljivanja.add(new Iznajmljivanje(datumPocetka, datumKraja, tipBoravka, ukupnaCena,
										soba, gosti, aktivnost, korisnickoIme));
								DataBase.iznajmljivanja.put(korisnickoIme, iznajmljivanja);
							} else {
								DataBase.iznajmljivanja.get(korisnickoIme).add(new Iznajmljivanje(datumPocetka,
										datumKraja, tipBoravka, ukupnaCena, soba, gosti, aktivnost, korisnickoIme ));
							}

						} catch (Exception e) {
							continue;
						}
					}
				}

				buff.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
					buff.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		} catch (

		UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	// promeni da ne bude static
	public static void dodajIznajmljivanje(Korisnik korisnik) {

		Scanner sc = new Scanner(System.in);
		Iznajmljivanje iznajmljivanje = new Iznajmljivanje();
		Date datumPocetka = null;
		Date datumZavrsetka = null;

		while (true) {
			System.out.println("Datum pocetka (format)");
			datumPocetka = ucitajDatum();

			System.out.println("Datum zavrsetka");
			datumZavrsetka = ucitajDatum();

			if (uporediDatume(datumPocetka, datumZavrsetka)) {
				System.out.println("Vreme pocetka mora biti pre vremena zavrsetka iznajmljivanja. Pokusajte ponovo.");
				System.out.println("---------------------------------------------------------------------------------");
				continue;
			} else {
				iznajmljivanje.setDanIzdavanja(datumPocetka);
				iznajmljivanje.setDanIsteka(datumZavrsetka);
				break;
			}
		}
		iznajmljivanje.setDanIzdavanja(datumPocetka);
		iznajmljivanje.setDanIsteka(datumZavrsetka);
		System.out.println("Tip boravka: ");
		TipBoravka tipBoravka = null;

		System.out.print("Unesite tip boravka:\n1) Dnevni\n2) Nocni\n");
		int tSobe = Meni.izaberiMeniOpciju(2, false);
		if (tSobe == 1) {
			tipBoravka = TipBoravka.DNEVNI;
		} else if (tSobe == 2) {
			tipBoravka = TipBoravka.NOCNI;
		}
		iznajmljivanje.setTipBoravka(tipBoravka);

		ArrayList<String> gosti = new ArrayList<>();

		boolean unosiJos = false;
		while (!unosiJos) {
			System.out.println("1)Iskoristi postojece goste.");
			System.out.println("2)Dodaj novog gosta.");

			int opcijaGost = Meni.izaberiMeniOpciju(2, false);
			if (opcijaGost == 1) {

				GostIO.stampajZaglavlje();
				for (Gost gost : DataBase.gosti.values()) {
					GostIO.stampaj(gost);
				}
				while (true) {
					System.out.println("Unesite broj licne karte gosta: ");
					String lKarta = IOHandler.unosBrojLK();
					if (!DataBase.gosti.containsKey(lKarta)) {
						System.out.println("Morate uneti ponudjen broj licnce karte.");
						continue;
					}
					gosti.add(lKarta);

					System.out.println("Zelite li jos gostiju:");
					System.out.println("1) da \n 2)Ne");
					int option = Meni.izaberiMeniOpciju(2, false);
					if (option == 1) {
						break;
					} else {
						unosiJos = true;
						break;
					}

				}
			} else if (opcijaGost == 2) {
				String novGost = GostIO.dodavanjeGost();
				gosti.add(novGost);
				System.out.println("Zelite li jos gostiju:");
				System.out.println("1) da \n 2)Ne");
				int option = Meni.izaberiMeniOpciju(2, false);
				if (option == 1) {
					continue;
				} else {
					break;
				}
			}
		}
		iznajmljivanje.setGosti(gosti);

		for (Soba soba : DataBase.sobe.values()) {
			System.out.println(soba.toString());
		}
		while (true) {
			System.out.println("Unesite broj sobe:");
			int brSobe = IOHandler.unosInt();
			if (!DataBase.sobe.containsKey(brSobe)) {
				System.out.println("Morate uneti postojeci.");
				continue;
			}
			iznajmljivanje.setIznajmljenaSoba(DataBase.sobe.get(brSobe));
			break;
		}
		iznajmljivanje.setAktivnost(true);
		iznajmljivanje.setKorisnickoIme(korisnik.getKorisnickoIme());

		double cena = 0;
		int idTipaSobe = iznajmljivanje.getIznajmljenaSoba().getTipSobeID(); // tipSobeID

		long brojDana = ChronoUnit.DAYS.between(iznajmljivanje.getDanIzdavanja().toInstant(),
				iznajmljivanje.getDanIsteka().toInstant()); // broj dana boravka

		for (int key : DataBase.cenovnik.keySet()) {
			Cenovnik c = DataBase.cenovnik.get(key);
			if (c.getIdTipaSobe() == idTipaSobe) {
				if (iznajmljivanje.getTipBoravka().equals(TipBoravka.NOCNI)) {
					cena = c.getCenaNocenje();
					break;
				} else {
					cena = c.getCenaDnevniBoravak();
					break;
				}
			}
		}

		cena = cena * brojDana;
		iznajmljivanje.setCenaUkupna(cena);
		System.out.println("Uspesno ste iznajmili sobu!");
		
		DataBase.addIznajmljivanja(iznajmljivanje.getKorisnickoIme(), iznajmljivanje);
		azurirajIznajmljivanja();		

	}

	
	public void brisanjeIznajmljivanja() {
		
	}

	

	

	public static Date ucitajDatum() {
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy. HH.mm");
		Date datum = new Date();
		while (true) {
			try {
				System.out.println("Unesite datum: (dd.MM.yyyy. HH.mm)");
				format.setLenient(false);
				datum = format.parse(IOHandler.ucitajLiniju());

				return datum;
			} catch (ParseException e) {
				System.out.print("Pogresno unet datum i vreme. Pokusajte ponovo. \n");
			}
		}
	}

	private static boolean uporediDatume(Date prvi, Date drugi) {

		if (prvi.after(drugi)) {
			return true;
		} else {
			return false;
		}
	}

	public void stampajZaglavljeSoba() {
		System.out.println(
				"\n===========================================================================================================");
		System.out.printf("%-2s%-16s%-2s%-16s%-2s%-14s%-2s%-16s%-2s%-16s%-2s%-16s%-2s\n", "|", "Broj sobe", "|",
				"Id tipa sobe", "|", "Naziv sobe", "|", "Broj kreveta", "|", "TV", "|", "Mini bar", "|");
		System.out.println(
				"===========================================================================================================");

	}

	/*
	 * 
	 * ----------------------- ---------------DOBRO // gosti boolean aktivnost =
	 * true; ArrayList<Gost> gosti = new ArrayList<Gost>();
	 * 
	 * // System.out.println("Slobodne sobe"); // SobaIO sm = new SobaIO(); // Soba
	 * s = new Soba(); // //sm.stampajZaglavljeSoba(); // boolean postojiSlobodna =
	 * false; Soba soba = null; ArrayList<Soba> listaSoba = new ArrayList<Soba>();
	 * // for (int key : DataBase.sobe.keySet()) { // s = DataBase.sobe.get(key); //
	 * boolean zauzeta = false; // for (Iznajmljivanje iz : DataBase.iznajmljivanja)
	 * { // if (iz.isAktivnost() && iz.getIznajmljenaSoba().getBrSobe() ==
	 * s.getBrSobe()) { // zauzeta = true; // break; // } // // } // if (!zauzeta)
	 * // postojiSlobodna = true; // } // if (!postojiSlobodna) { //
	 * System.out.println("Ne postoji slobodna soba. "); // return; // } while
	 * (true) { System.out.print("Unesite broj sobe: "); int brojSobe =
	 * IOHandler.unosInt(); for (Soba sobaTemp : listaSoba) { if
	 * (sobaTemp.getBrSobe() == brojSobe) { soba = sobaTemp; break; } } if (soba ==
	 * null) { System.out.
	 * println("Morate uneti jednu od ponudjenih opcija. Pokusajte ponovo. ");
	 * continue; } break; }
	 * 
	 * GostIO gost = new GostIO(); Gost gostTemp = new Gost();
	 * //gm.stampajZaglavlje(); int odsGost = 0; ArrayList<Gost> moguciGosti = new
	 * ArrayList<Gost>(); for (String key : DataBase.gosti.keySet()) { gostTemp =
	 * DataBase.gosti.get(key); boolean aktivan = false; if (gostTemp.isAktivnost())
	 * { for (Iznajmljivanje iz : DataBase.iznajmljivanja) { if
	 * (iz.getGosti().size() != 0) { for (Gost gos : iz.getGosti()) { if
	 * (gos.equals(gostTemp)) { aktivan = true; break; } } if (!aktivan) {
	 * moguciGosti.add(gostTemp); odsGost += 1; break; } } }
	 * 
	 * } } if (odsGost == 0) { System.out.
	 * println("Nema potencijalnih gostiju. Morate prvo uneti novog gosta. ");
	 * return; }
	 * 
	 * ArrayList<String> listBrLK = new ArrayList<String>();
	 * 
	 * int brUnetih = 0;
	 * 
	 * while (!moguciGosti.isEmpty()) { Gost dodati = null; boolean dodao = false;
	 * if (brUnetih == 0) {
	 * System.out.print("Unesite broj licne karte gosta koji iznajmljuje sobu: ");
	 * String brLK = IOHandler.unosBrojLK();
	 * 
	 * for (Gost ge : moguciGosti) { if (ge.getBrojLK().equals(brLK)) {
	 * listBrLK.add(brLK); dodao = true; dodati = ge; brUnetih += 1; } } if (dodao)
	 * { moguciGosti.remove(dodati); } if (brUnetih == 0) {
	 * System.out.println("Mozete uneti samo ponudjeni broj LK. Pokusajte ponovo. "
	 * ); } } else { String brLK1 = null;
	 * System.out.println("1) Zelite jos gostiju"); System.out.println("2) Zavrsi");
	 * int opcija = Meni.izaberiMeniOpciju(2, false); switch (opcija) { case 1:
	 * gost.stampajZaglavlje(); for (Gost gostTemp1 : moguciGosti) {
	 * gost.stampaj(gostTemp1); }
	 * System.out.print("Unesite jmbg gosta koji iznajmljuje sobu: "); brLK1 =
	 * IOHandler.unosBrojLK(); for (Gost ge : moguciGosti) { if
	 * (ge.getBrojLK().equals(brLK1)) { listBrLK.add(brLK1); dodati = ge; dodao =
	 * true;
	 * 
	 * break; } } if (dodao) { moguciGosti.remove(dodati); }else{
	 * System.out.println("Mozete odabrati samo nekog od ponudjenih."); }
	 * 
	 * break; case 2: moguciGosti.clear(); break;
	 * 
	 * } }
	 * 
	 * } // puni goste for (int m = 0; m < DataBase.gosti.size(); m++) { for (int j
	 * = 0; j < listBrLK.size(); j++) {
	 */
	 //if (listBrLK.get(j).equals(DataBase.gosti.get(m).getBrojLK())) {
	 //gosti.add(DataBase.gosti.get(m)); } } }
	 //System.out.println("Uspesno ste obavili iznajmljivanje. ");
	 //DataBase.iznajmljivanja.add(new Iznajmljivanje(datumPocetka, datumZavrsetka,
	 //tipBoravka, 100,soba, gosti, aktivnost, "test korisnik"));
	 //azurirajIznajmljivanja(); } 

	
	 public static void azurirajIznajmljivanja() { //
		 String sadrzaj = ""; 
		 for (ArrayList<Iznajmljivanje> lista : DataBase.iznajmljivanja.values()) {
			for (Iznajmljivanje iznajmljivanje : lista) {
				sadrzaj += iznajmljivanje.toFile() + "\n"; 
			} 
		}
		 try { 
			 fw = new FileWriter("Data/iznajmljivanje.txt"); 
			 bw = new BufferedWriter(fw);
			 bw.write(sadrzaj); 
			 bw.close();
		 
		 } catch (IOException e) {
			 e.printStackTrace(); 
		}
		 
		 
	 
	}
	 

	 
	
	 
	 public static void izmeniIznajmljivanje() {
	 
	 }
	 

}