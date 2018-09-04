package iostream;

import java.util.ArrayList;
import java.util.Collections;

import model.DataBase;
import model.Korisnik;
import model.Soba;
import model.TipSobe;


public class Pregledi {
	
	public static ArrayList<Korisnik> korisnici = new ArrayList<Korisnik>();
	public static ArrayList<TipSobe> tipSobe = new ArrayList<TipSobe>();
	public static ArrayList<Soba> sobe = new ArrayList<Soba>();
	
	public static void sortiranjeKorisnikaIme() {
		Korisnik korisnik = new Korisnik();
		for (String key : DataBase.korisnici.keySet()) {
			
			korisnik = DataBase.korisnici.get(key);
			korisnici.add(korisnik);				
		}
		Collections.sort(korisnici,(a,b)-> a.getIme().compareTo(b.getIme()));
		System.out.println("ime" + "|" + "prezime" + "|" + "brojLK" + "|" + "korisnickoIme"+ "|" + "lozinka" +"|" +  " tipKorisnika" + "|" +" aktivnost   " + "\n");
		for(int i=0; i<korisnici.size();i++) {
			System.out.println(korisnici.get(i).toString());
		}
	}
	
	public static void sortiranjeKorisnikaPrezime() {
		Korisnik korisnik = new Korisnik();
		for (String key : DataBase.korisnici.keySet()) {
			
			korisnik = DataBase.korisnici.get(key);
			korisnici.add(korisnik);				
		}
		Collections.sort(korisnici,(a,b)-> a.getPrezime().compareTo(b.getPrezime()));
		System.out.println("ime" + "|" + "prezime" + "|" + "brojLK" + "|" + "korisnickoIme"+ "|" + "lozinka" +"|" +  " tipKorisnika" + "|" +" aktivnost"  + "\n");
		for(int i=0; i<korisnici.size();i++) {
			System.out.println(korisnici.get(i).toString());
		}
	}
	
	public static void sortiranjeKorisnikaKorisnickoIme() {
		Korisnik korisnik = new Korisnik();
		for (String key : DataBase.korisnici.keySet()) {
			
			korisnik = DataBase.korisnici.get(key);
			korisnici.add(korisnik);				
		}
		Collections.sort(korisnici,(a,b)-> a.getKorisnickoIme().compareTo(b.getKorisnickoIme()));
		System.out.println("ime" + "|" + "prezime" + "|" + "brojLK" + "|" + "korisnickoIme"+ "|" + "lozinka" +"|" +  " tipKorisnika" + "|" +" aktivnost" + "\n");
		for(int i=0; i<korisnici.size();i++) {
			System.out.println(korisnici.get(i).toString());
		}
	}
	
	public static void sortiranjeTipSobeIme(){
		TipSobe tipSobetemp = new TipSobe();
		for (int key : DataBase.tipSobe.keySet()) {
			
			tipSobetemp = DataBase.tipSobe.get(key);
			tipSobe.add(tipSobetemp);				
		}
		Collections.sort(tipSobe,(a,b)-> a.getNazivSobe().compareTo(b.getNazivSobe()));
		System.out.println("ID" + "|" + "ime" + "|" + "BROJ KREVETA" + "|" + "AKTIVNOST"+ "|" + "\n");
		for(int i=0; i<tipSobe.size();i++) {
			System.out.println(tipSobe.get(i).toString());
		}
	}
	
	public static void sortiranjeTipSobeBrojKreveta(){
		TipSobe tipSobetemp = new TipSobe();
		for (int key : DataBase.tipSobe.keySet()) {
			
			tipSobetemp = DataBase.tipSobe.get(key);
			tipSobe.add(tipSobetemp);				
		}
		Collections.sort(tipSobe,(a,b)->  Integer.compare(a.getBrojKreveta(), b.getBrojKreveta()));
		System.out.println("ID" + "|" + "ime" + "|" + "BROJ KREVETA" + "|" + "AKTIVNOST"+ "|" + "\n");
		for(int i=0; i<tipSobe.size();i++) {
			System.out.println(tipSobe.get(i).toString());
		}
	}
	
	public static void sortiranjeSobeBroj() {
		Soba sobaTemp = new Soba();
		for (int key : DataBase.sobe.keySet()) {
			
			sobaTemp = DataBase.sobe.get(key);
			sobe.add(sobaTemp);				
		}
		Collections.sort(sobe,(a,b)->  Integer.compare(a.getBrSobe(), b.getBrSobe()));
		System.out.println("ID" + "|" + "ime" + "|" + "BROJ KREVETA" + "|" + "AKTIVNOST"+ "|" + "\n");
		for(int i=0; i<tipSobe.size();i++) {
			System.out.println(tipSobe.get(i).toString());
		}
	}
	
	public static void sortiranjeSobeTip() {
		
	}
	
}
