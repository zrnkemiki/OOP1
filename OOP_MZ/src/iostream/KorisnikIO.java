package iostream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import model.DataBase;
import model.Korisnik;

public class KorisnikIO {
	static BufferedReader buff;
	static BufferedWriter bw;
	static FileWriter fw;
	
	public static void ucitavanjeKorisnika() {
		
		String linija;
		try {
			buff = new BufferedReader(new InputStreamReader(new FileInputStream("data/korisnici.txt"), "UTF-8"));

			try {
				while ((linija = buff.readLine()) != null) {
					Korisnik korisnik = new Korisnik();
					linija = linija.trim();
					String[] podaci = linija.split("\\|");
					
					
					if (podaci.length == 7) {
						String ime = podaci[0].trim();
						
						if (ime.equals("")) {
							continue;
						} else {
							korisnik.setIme(ime.substring(0, 1).toUpperCase() + ime.substring(1).toLowerCase());
						}
						
						String prezime = podaci[1].trim();
						if (prezime.equals("")) {
							continue;
						} else {
							korisnik.setPrezime(
									prezime.substring(0, 1).toUpperCase() + prezime.substring(1).toLowerCase());
						}

						String brojLK = podaci[2].trim();
						if (brojLK.equals("")) {
							continue;
						} else if (brojLK.length() != 9) {
							continue;
						} else {
							korisnik.setBrojLK(brojLK);
						}

						String korisnickoIme = podaci[3].trim();
						if (korisnickoIme.equals("")) {
							continue;
						} else {
							korisnik.setKorisnickoIme(korisnickoIme);
						}

						String lozinka = podaci[4].trim();
						if (lozinka.equals("")) {
							continue;
						} else {
							korisnik.setLozinka(lozinka);
						}

						String tipKorisnika = podaci[5].trim();
						
						if (tipKorisnika.equals("")) {
							continue;
						} else {
							korisnik.setTipKorisnika(tipKorisnika);					}

						String aktivnost = podaci[6].trim();
						if (aktivnost.equals("")) {
							continue;
						} else {
							korisnik.setAktivnost(Boolean.parseBoolean(aktivnost));
						}
						
						String  id = korisnik.getBrojLK();
					    if(DataBase.korisnici.containsKey(id)){
					        System.out.println("Korisnik sa brojem licne karte: " + id + " vec postoji.");
					    } else{
					    	DataBase.korisnici.put(korisnik.getBrojLK(), korisnik);
					    	//System.out.println("Korisnik dodat."); 									//OBRISATI
					    }			
						
					}					
			}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	
	public static void dodavanjeProdavca() {
		Korisnik korisnik = new Korisnik();
		
		String ime = IOHandler.unosImena();
		String prezime = IOHandler.unosPrezimena();
		String brojLK = IOHandler.unosBrojLK();
		String korisnickoIme = IOHandler.unosKorisnickoIme();
		String lozinka = IOHandler.unosLozinke();
		String tipKorisnika = "recepcioner";
		boolean aktivnost = IOHandler.unosBoolean();
		
		korisnik.setIme(ime);
		korisnik.setPrezime(prezime);
		korisnik.setBrojLK(brojLK);
		korisnik.setKorisnickoIme(korisnickoIme);
		korisnik.setLozinka(lozinka);
		korisnik.setTipKorisnika(tipKorisnika);
		korisnik.setAktivnost(aktivnost);
		
		String  id = brojLK;
	    if(DataBase.korisnici.containsKey(id)){
	        System.out.println("Korisnik sa brojem licne karte: " + id + " vec postoji.");
	    } else{
	    	DataBase.korisnici.put(korisnik.getBrojLK(), korisnik);
	    	System.out.println("Korisnik dodat."); 									//OBRISATI
	    }			
				
	}
	
	public static void dodavanjeMenadzera() {
		Korisnik korisnik = new Korisnik();
		
		String ime = IOHandler.unosImena();
		String prezime = IOHandler.unosPrezimena();
		String brojLK = IOHandler.unosBrojLK();
		String korisnickoIme = IOHandler.unosKorisnickoIme();
		String lozinka = IOHandler.unosLozinke();
		String tipKorisnika = "menadzer";
		boolean aktivnost = IOHandler.unosBoolean();
		
		korisnik.setIme(ime);
		korisnik.setPrezime(prezime);
		korisnik.setBrojLK(brojLK);
		korisnik.setKorisnickoIme(korisnickoIme);
		korisnik.setLozinka(lozinka);
		korisnik.setTipKorisnika(tipKorisnika);
		korisnik.setAktivnost(aktivnost);
		
		String  id = brojLK;
	    if(DataBase.korisnici.containsKey(id)){
	        System.out.println("Korisnik sa brojem licne karte: " + id + " vec postoji.");
	    } else{
	    	DataBase.korisnici.put(korisnik.getBrojLK(), korisnik);
	    	System.out.println("Korisnik dodat."); 									//OBRISATI
	    }			
				
	}
	
	public static void azurirajKorisnike() {
		String sadrzaj = "";
		
		for (String key : DataBase.korisnici.keySet()) {
			
			Korisnik temp = DataBase.korisnici.get(key);
			sadrzaj += temp.toString() + "\n";

		}
		try {
			fw = new FileWriter("data/korisnici.txt");
			bw = new BufferedWriter(fw);
			bw.write(sadrzaj);
			bw.close();
			System.out.println("Ukoliko je bilo izmena, fajl je izmenjen.");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void brisanjeKorisnika() {
		while(true) {
			String brLK = IOHandler.unosBrojLK();
			if(DataBase.korisnici.containsKey(brLK)) {
				DataBase.korisnici.remove(brLK);
				System.out.println("Korisnik sa brojem licne karte" + brLK + " je uklonjen");
				break;
							
			}
			else
			{
				System.out.println("Korisnik sa tim brojem Licne karte ne postoji.");
				continue;
			}
		}
		
	}
	
	public static void izmenaKorisnika() {
		while(true) {
			String brLK = IOHandler.unosBrojLK();
			if(DataBase.korisnici.containsKey(brLK)) {
				Korisnik korisnik = DataBase.korisnici.get(brLK);
				System.out.println("IZMENA KORISNIKA + " + korisnik.toString() );
				
				String ime = IOHandler.unosImena();
				String prezime = IOHandler.unosPrezimena();
				String brojLK = IOHandler.unosBrojLK();
				String korisnickoIme = IOHandler.unosKorisnickoIme();
				String lozinka = IOHandler.unosLozinke();
				String tipKorisnika = IOHandler.unosTipaKorisnika();
				boolean aktivnost = IOHandler.unosBoolean();
				
				korisnik.setIme(ime);
				korisnik.setPrezime(prezime);
				korisnik.setBrojLK(brojLK);
				korisnik.setKorisnickoIme(korisnickoIme);
				korisnik.setLozinka(lozinka);
				korisnik.setTipKorisnika(tipKorisnika);
				korisnik.setAktivnost(aktivnost);
				
				System.out.println("Korisnik sa brojem licne karte" + brLK + " je izmenjen.");
				break;			
			}
			else
			{
				System.out.println("Korisnik sa tim brojem Licne karte ne postoji.");
				continue;
			}
		}
		
	}

	
}
