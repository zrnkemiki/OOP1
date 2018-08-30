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
import model.Soba;

public class SobaIO {

	static BufferedReader buff;
	static BufferedWriter bw;
	static FileWriter fw;
	
	public static void ucitavanjeSoba() {

		String linija;
		String temp;

		try {
			buff = new BufferedReader(new InputStreamReader(new FileInputStream("data/sobe.txt"), "UTF-8"));
			try {
				while ((linija = buff.readLine()) != null) {
					Soba soba = new Soba();
					linija = linija.trim();
					String[] podaci = linija.split("\\|");

					if (podaci.length == 5) {

						int brSobe;
						temp = podaci[0].trim();
						try {
							brSobe = Integer.parseInt(temp);
							soba.setBrSobe(brSobe);
						} catch (Exception e) {
							continue;
						}

						int brTipaSobe;
						temp = podaci[1].trim();
						try {
							brTipaSobe = Integer.parseInt(temp);
							soba.setTipSobeID(brTipaSobe);
						} catch (Exception e) {

							continue;
						}

						temp = podaci[2].trim();
						try {
							boolean tv = Boolean.parseBoolean(temp);
							soba.setTv(tv);
						} catch (Exception e1) {

							continue;
						}
						String bar = podaci[3].trim();
						try {
							boolean miniBar = Boolean.parseBoolean(bar);
							soba.setMiniBar(miniBar);
						} catch (Exception e1) {

							continue;
						}

						String aktivan = podaci[4].trim();
						try {
							boolean aktivnost = Boolean.parseBoolean(aktivan);
							soba.setAktivnost(aktivnost);
						} catch (Exception e1) {

							continue;
						}
						DataBase.sobe.put(soba.getBrSobe(), soba);

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
		finally {
			
		}

	}


	public static void dodavanjeSoba() {
		Soba soba = new Soba();
		
		System.out.println("Unesite broj sobe");
		int brSobe = IOHandler.unosInt();
		System.out.println("Unesite id tipa sobe");
		int tipSobeID = IOHandler.unosInt();
		System.out.println("Da li soba poseduje TV?");
		boolean tv = IOHandler.unosBoolean();
		System.out.println("Da li soba poseduje miniBar?");
		boolean miniBar = IOHandler.unosBoolean();
		System.out.println("Da li je soba u funkciji?");
		boolean aktivnost = IOHandler.unosBoolean();
		
		soba.setBrSobe(brSobe);
		soba.setTipSobeID(tipSobeID);
		soba.setTv(tv);
		soba.setMiniBar(miniBar);
		soba.setAktivnost(aktivnost);
		
				
		int  id = brSobe;
	    if(DataBase.sobe.containsKey(id)){
	        System.out.println("Soba sa brojem : " + id + " vec postoji.");
	    } else{
	    	DataBase.sobe.put(soba.getBrSobe(), soba);
	    	System.out.println("Soba dodata dodat."); 									//OBRISATI
	    }
	}


	public static void azurirajSobe() {
		String sadrzaj = "";
		
		for (int key : DataBase.sobe.keySet()) {
			
			Soba temp = DataBase.sobe.get(key);
			sadrzaj += temp.toString() + "\n";

		}
		try {
			fw = new FileWriter("data/sobe.txt");
			bw = new BufferedWriter(fw);
			bw.write(sadrzaj);
			bw.close();
			System.out.println("Ukoliko je bilo izmena, fajl je izmenjen.");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
	public static void brisanjeSoba() {
		while(true) {
			int brSobe = IOHandler.unosInt();
			if(DataBase.sobe.containsKey(brSobe)) {
				DataBase.sobe.remove(brSobe);
				System.out.println("Tip Sobe sa brojem" + brSobe + " je uklonjen");
							
			}
			else
			{
				System.out.println("Ovaj broj sobe ne postoji.");
				continue;
			}
		}
		
	}
	
	public static void izmenaSobe() {
		while(true) {
			System.out.println("Unesite broj sobe");
			int brojSobe = IOHandler.unosInt();
			if(DataBase.sobe.containsKey(brojSobe)) {
				Soba soba = DataBase.sobe.get(brojSobe);
				System.out.println("IZMENA SOBE" + soba.toString());
				
				System.out.println("Unesite id tipa sobe");
				int tipSobeID = IOHandler.unosInt();
				System.out.println("Da li soba poseduje TV?");
				boolean tv = IOHandler.unosBoolean();
				System.out.println("Da li soba poseduje miniBar?");
				boolean miniBar = IOHandler.unosBoolean();
				System.out.println("Da li je soba u funkciji?");
				boolean aktivnost = IOHandler.unosBoolean();
				
				soba.setBrSobe(brojSobe);
				soba.setTipSobeID(tipSobeID);
				soba.setTv(tv);
				soba.setMiniBar(miniBar);
				soba.setAktivnost(aktivnost);
				
				System.out.println("Soba sa brojem" + brojSobe + " je izmenjena.");
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
