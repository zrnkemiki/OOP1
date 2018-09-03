package iostream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import model.Cenovnik;
import model.DataBase;

public class CenovnikIO {
	static BufferedReader buff;
	static BufferedWriter bw;
	static FileWriter fw;
	
	public static void ucitajCenovnik() {
		String linija;		
		try {
			buff = new BufferedReader(new InputStreamReader(new FileInputStream("data/cenovnik.txt"), "UTF-8"));
			try {
				while((linija = buff.readLine()) != null) {
					Cenovnik cenovnik = new Cenovnik();
					linija = linija.trim();
					String[] podaci = linija.split("\\|");
					
					if (podaci.length == 4) {
						int idTipaSobe;
						
						try {
							idTipaSobe = Integer.parseInt(podaci[0].trim());
							cenovnik.setIdTipaSobe(idTipaSobe);
						
						} catch (Exception e) {
							continue;
						}
	
						int cenaDnevnogBoravka;
					
						try {
							cenaDnevnogBoravka =  Integer.parseInt(podaci[1].trim());
							cenovnik.setCenaDnevniBoravak(cenaDnevnogBoravka);
						} catch (Exception e) {
	
							continue;
						}
	
						int cenaNocenje;
						
						try {
							cenaNocenje = Integer.parseInt( podaci[2].trim());
							cenovnik.setVikendPoskupljenje(cenaNocenje);
						} catch (Exception e) {
	
							continue;
						}
						
						int poskupljenje;
						
						try {
							poskupljenje = Integer.parseInt(podaci[3].trim());
							cenovnik.setVikendPoskupljenje(poskupljenje);
						} catch (Exception e) {
	
							continue;
						}
						DataBase.cenovnik.put(cenovnik.getIdTipaSobe(), cenovnik);
						
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
	
	public static void dodavanjeCenovnik() {
		Cenovnik cenovnik = new Cenovnik();
		
		System.out.println("Unesite id tipa sobe: ");
		int idTipaSobe = IOHandler.unosInt();
		System.out.println("Unesite cenu dnevnog boravka:");
		int cenaDnevnog = IOHandler.unosInt();
		System.out.println("Unesite cenu nocenja: ");
		int cenaNocenje = IOHandler.unosInt();
		System.out.println("Unesite popust");
		int popust = IOHandler.unosInt();
		
		cenovnik.setIdTipaSobe(idTipaSobe);
		cenovnik.setCenaDnevniBoravak(cenaDnevnog);
		cenovnik.setCenaNocenje(cenaNocenje);
		cenovnik.setVikendPoskupljenje(popust);
				
		int  id = idTipaSobe;
	    if(DataBase.cenovnik.containsKey(id)){
	        System.out.println("Soba sa brojem : " + id + " vec postoji.");
	    } else{
	    	DataBase.cenovnik.put(cenovnik.getIdTipaSobe(), cenovnik);
	    	System.out.println("Nova stavka cenovnika dodata. "); 									//OBRISATI
	    }
	}
	
	public static void azurirajCenovnik() {
		String sadrzaj = "";
		for (int key : DataBase.cenovnik.keySet()) {
			
			Cenovnik temp = DataBase.cenovnik.get(key);
			sadrzaj += temp.toString() + "\n";

		}
		try {
			fw = new FileWriter("data/cenovnik.txt");
			bw = new BufferedWriter(fw);
			bw.write(sadrzaj);
			bw.close();
			System.out.println("Ukoliko je bilo izmena, fajl je izmenjen.");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void brisanjeCenovnika() {
		while(true) {
			System.out.println("Unesite tipSobeID sobe iz cenovnika koji zelite da obriste");
			int brSobe = IOHandler.unosInt();
			if(DataBase.cenovnik.containsKey(brSobe)) {
				DataBase.cenovnik.remove(brSobe);
				System.out.println("Tip Sobe sa brojem" + brSobe + " je uklonjen iz cenovnika");
				break;			
			}
			else
			{
				System.out.println("Ovaj broj tipa sobe sobe ne postoji.");
				continue;
			}
		}
		
	}
	
	public static void izmenaCenovnika() {
		while(true) {
			System.out.println("Unesite tipSobeID sobe");
			int tipSobeID = IOHandler.unosInt();
			if(DataBase.cenovnik.containsKey(tipSobeID)) {
				Cenovnik cenovnik = DataBase.cenovnik.get(tipSobeID);
				System.out.println("IZMENA SOBE " + cenovnik.toString());
				;
				System.out.println("Unesite cenu dnevnog boravka:");
				int cenaDnevnog = IOHandler.unosInt();
				System.out.println("Unesite cenu nocenja: ");
				int cenaNocenje = IOHandler.unosInt();
				System.out.println("Unesite popust");
				int popust = IOHandler.unosInt();
				
				cenovnik.setIdTipaSobe(tipSobeID);
				cenovnik.setCenaDnevniBoravak(cenaDnevnog);
				cenovnik.setCenaNocenje(cenaNocenje);
				cenovnik.setVikendPoskupljenje(popust);
				
				System.out.println("Stavka cenovnika sa id-sobe " + tipSobeID + " je izmenjena.");
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
