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
import model.Gost;
public class GostIO {
	static BufferedReader buff;
	static BufferedWriter bw;
	static FileWriter fw;

	
	public static void stampajZaglavlje() {
		System.out.println(
				"\n=================================================================================================");
		System.out.printf("%-2s%-16s%-2s%-16s%-2s%-14s%-2s%-16s%-2s\n", "|", "Ime", "|", "Prezime", "|", "BR LK", "|",
				"Aktivan", "|");
		System.out.println(
				"=================================================================================================");

	}
	
	public static void stampaj(Gost gost) {
		System.out.printf("%-2s%-16.15s%-2s%-16.15s%-2s%-14.13s%-2s%-16.15s%-2s\n", "|", gost.getIme(), "|",
				gost.getPrezime(), "|", gost.getBrojLK(), "|", gost.isAktivnost(), "|");
		System.out.println(
				"-------------------------------------------------------------------------------------------------");
	}
	
	public static void ucitajGoste() {

		String linija = "";

		try {
			buff = new BufferedReader(new InputStreamReader(new FileInputStream("data/gosti.txt"), "UTF-8"));

			try {
				while ((linija = buff.readLine()) != null) {
					Gost gost;
					String[] parametri = linija.split("\\|");

					String ime = parametri[0].trim();
					String prezime = parametri[1].trim();
					String brLK = parametri[2].trim();
					if (brLK.equals("")) {
						continue;
					} else if (brLK.length() != 9) {
						continue;
					} 
					String aktivan = parametri[3].trim();
					try {
						boolean aktivnost = Boolean.parseBoolean(aktivan);
						gost = new Gost(ime, prezime, brLK, aktivnost);
					} catch (Exception e) {
						continue;
					}
					//System.out.println(gost.getBrojLK());
					DataBase.gosti.put(gost.getBrojLK(), gost);
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
	
	// vraca brLicneKarte
	public static String dodavanjeGost() {
		Gost gost = new Gost();
		
		String ime = IOHandler.unosImena();
		String prezime = IOHandler.unosPrezimena();
		String brojLK = IOHandler.unosBrojLK();
		boolean aktivnost = IOHandler.unosBoolean();
		
		gost.setIme(ime);
		gost.setPrezime(prezime);
		gost.setBrojLK(brojLK);
		gost.setAktivnost(aktivnost);
		
		String  id = brojLK;
	    if(DataBase.gosti.containsKey(id)){
	        System.out.println("Korisnik sa brojem licne karte: " + id + " vec postoji.");
	    } else{
	    	DataBase.gosti.put(gost.getBrojLK(), gost);
	    	System.out.println("Gost dodat."); 									//OBRISATI
	    }
	    return gost.getBrojLK();
	}
	    
	public static void azurirajGoste() {
		String sadrzaj = "";
		
		for (String key : DataBase.gosti.keySet()) {
			
			Gost temp = DataBase.gosti.get(key);
			sadrzaj += temp.toString() + "\n";

		}
		try {
			fw = new FileWriter("data/gosti.txt");
			bw = new BufferedWriter(fw);
			bw.write(sadrzaj);
			bw.close();
			System.out.println("Ukoliko je bilo izmena, fajl je izmenjen.");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void brisanjeGosta() {
		while(true) {
			String brojLK = IOHandler.unosBrojLK();
			if(DataBase.gosti.containsKey(brojLK)) {
				DataBase.gosti.remove(brojLK);
				System.out.println("Gost sa brojem licne karte" + brojLK + " je uklonjen.");
							
			}
			else
			{
				System.out.println("Gost sa ovim brojem licne karte ne postoji.");
				continue;
			}
		}
		
	}
	
	public static void izmenaGost() {
		while(true) {
			String brLK = IOHandler.unosBrojLK();
			if(DataBase.gosti.containsKey(brLK)) {
				Gost gost = DataBase.gosti.get(brLK);
				System.out.println("IZMENA KORISNIKA + " + gost.toString() );
				
				String ime = IOHandler.unosImena();
				String prezime = IOHandler.unosPrezimena();
				String brojLK = IOHandler.unosBrojLK();
				boolean aktivnost = IOHandler.unosBoolean();
				
				gost.setIme(ime);
				gost.setPrezime(prezime);
				gost.setBrojLK(brojLK);
				gost.setAktivnost(aktivnost);
				
				System.out.println("Gost sa brojem licne karte" + brLK + " je izmenjen.");
				break;			
			}
			else
			{
				System.out.println("Gost sa tim brojem Licne karte ne postoji.");
				continue;
			}
		}
		
	}
	
	
}
