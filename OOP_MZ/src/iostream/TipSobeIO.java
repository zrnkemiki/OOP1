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
import model.TipSobe;

public class TipSobeIO {
	static BufferedReader buff;
	static BufferedWriter bw;
	static FileWriter fw;
	
	public static void ucitajTipSobe() {
		String linija;		
		try {
			buff = new BufferedReader(new InputStreamReader(new FileInputStream("data/tipSobe.txt"), "UTF-8"));
			try {
				while((linija = buff.readLine()) != null) {
					TipSobe tipSobe = new TipSobe();
					linija = linija.trim();
					String[] podaci = linija.split("\\|");
					
					if (podaci.length == 4) {
						int idTipaSobe;
						
						try {
							idTipaSobe = Integer.parseInt(podaci[0].trim());
							tipSobe.setIdTipaSobe(idTipaSobe);
						
						} catch (Exception e) {
							continue;
						}
	
						String nazivTipaSobe;
					
						try {
							nazivTipaSobe = podaci[1].trim();
							tipSobe.setNazivSobe(nazivTipaSobe);
						} catch (Exception e) {
	
							continue;
						}
	
						int brojKreveta;
						
						try {
							brojKreveta = Integer.parseInt( podaci[2].trim());
							tipSobe.setBrojKreveta(brojKreveta);
						} catch (Exception e) {
	
							continue;
						}
						
						boolean aktivnost;
						
						try {
							aktivnost = Boolean.parseBoolean( podaci[3].trim());
							tipSobe.setAktivnost(aktivnost);
						} catch (Exception e) {
	
							continue;
						}
						DataBase.tipSobe.put(tipSobe.getIdTipaSobe(), tipSobe);
						
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
		
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void dodavanjeTipaSobe() {
		TipSobe tipSobe = new TipSobe();
		
		System.out.println("Unesite id tipa sobe: ");
		int tipSobeID = IOHandler.unosInt();
		System.out.println("Unesite naziv sobe:");
		String nazivSobe = IOHandler.unosTipaSobeNaziv();
		System.out.println("Unesite broj kreveta: ");
		int brKreveta = IOHandler.unosInt();
		System.out.println("Da li je ovaj tip sobe aktivan?");
		boolean aktivnost = IOHandler.unosBoolean();
		
		tipSobe.setIdTipaSobe(tipSobeID);
		tipSobe.setNazivSobe(nazivSobe);
		tipSobe.setBrojKreveta(brKreveta);
		tipSobe.setAktivnost(aktivnost);
		
				
		int  id = tipSobeID;
	    if(DataBase.tipSobe.containsKey(id)){
	        System.out.println("Soba sa brojem : " + id + " vec postoji.");
	    } else{
	    	DataBase.tipSobe.put(tipSobe.getIdTipaSobe(), tipSobe);
	    	System.out.println("Novi tip sobe dodat"); 									//OBRISATI
	    }
	}
	
	public static void azurirajTipSobe() {
		String sadrzaj = "";
		for (int key : DataBase.tipSobe.keySet()) {
			
			TipSobe temp = DataBase.tipSobe.get(key);
			sadrzaj += temp.toString() + "\n";

		}
		try {
			fw = new FileWriter("data/tipSobe.txt");
			bw = new BufferedWriter(fw);
			bw.write(sadrzaj);
			bw.close();
			System.out.println("Ukoliko je bilo izmena, fajl je izmenjen.");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void brisanjeTipSoba() {
		while(true) {
			int brSobe = IOHandler.unosInt();
			if(DataBase.tipSobe.containsKey(brSobe)) {
				DataBase.tipSobe.remove(brSobe);
				System.out.println("Tip Sobe sa brojem" + brSobe + " je uklonjen");
							
			}
			else
			{
				System.out.println("Ovaj broj tipa sobe sobe ne postoji.");
				continue;
			}
		}
		
	}
	
	public static void izmenaTipaSobe() {
		while(true) {
			System.out.println("Unesite tipSobeID sobe");
			int tipSobeID = IOHandler.unosInt();
			if(DataBase.tipSobe.containsKey(tipSobeID)) {
				TipSobe tipSobe = DataBase.tipSobe.get(tipSobeID);
				System.out.println("IZMENA SOBE " + tipSobe.toString());
				;
				System.out.println("Unesite naziv sobe:");
				String nazivSobe = IOHandler.unosTipaSobeNaziv();
				System.out.println("Unesite broj kreveta: ");
				int brKreveta = IOHandler.unosInt();
				System.out.println("Da li je ovaj tip sobe aktivan?");
				boolean aktivnost = IOHandler.unosBoolean();
				
				tipSobe.setIdTipaSobe(tipSobeID);
				tipSobe.setNazivSobe(nazivSobe);
				tipSobe.setBrojKreveta(brKreveta);
				tipSobe.setAktivnost(aktivnost);
				
				System.out.println("Soba sa brojem " + tipSobeID + " je izmenjena.");
				break;			
			}
			else
			{
				System.out.println("Ovaj broj sobe ne postoji.");
				continue;
			}
		}
		
	}
}
		

