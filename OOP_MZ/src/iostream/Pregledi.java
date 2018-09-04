package iostream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import main.Meni;
import model.DataBase;
import model.Korisnik;
import model.Soba;
import model.TipSobe;


public class Pregledi {
	
	public static ArrayList<Korisnik> korisnici = new ArrayList<Korisnik>();
	public static ArrayList<TipSobe> tipSobe = new ArrayList<TipSobe>();
	public static ArrayList<Soba> sobe = new ArrayList<Soba>();
	static Scanner sc = new Scanner(System.in);
	
	public static void sortiranjeKorisnikaIme() {
		Korisnik korisnik = new Korisnik();
		for (String key : DataBase.korisnici.keySet()) {
			
			korisnik = DataBase.korisnici.get(key);
			korisnici.add(korisnik);				
		}
		Collections.sort(korisnici,(a,b)-> a.getIme().compareTo(b.getIme()));
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
		for(int i=0; i<korisnici.size();i++) {
			System.out.println(korisnici.get(i).toString());
		}
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////
	public static void pretragaKorisnikaIme() {
		System.out.println("Unesi parametar za pretragu korisnika po imenu.");
		String input = sc.nextLine().toLowerCase();
		for (String key : DataBase.korisnici.keySet()) {
			if(DataBase.korisnici.get(key).getIme().toLowerCase().contains(input))
			System.out.println(DataBase.korisnici.get(key).toString());
		}
	}
	
	public static void pretragaKorisnikaPrezime() {
		System.out.println("Unesi parametar za pretragu korisnika po prezimenu.");
		String input = sc.nextLine().toLowerCase();
		for (String key : DataBase.korisnici.keySet()) {
			if(DataBase.korisnici.get(key).getPrezime().toLowerCase().contains(input))
			System.out.println(DataBase.korisnici.get(key).toString());
		}
	}
	
	public static void pretragaKorisnikaKorisnickoIme() {
		System.out.println("Unesi parametar za pretragu korisnika po korisnickom imenu.");
		String input = sc.nextLine().toLowerCase();
		
		for (String key : DataBase.korisnici.keySet()) {			
			if(DataBase.korisnici.get(key).getKorisnickoIme().toLowerCase().contains(input))
			System.out.println(DataBase.korisnici.get(key).toString());
		}
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////
	public static void pretragaGostIme() {
		System.out.println("Unesi parametar za pretragu gostiju po imenu.");
		String input = sc.nextLine().toLowerCase();
		for (String key : DataBase.gosti.keySet()) {
			if(DataBase.gosti.get(key).getIme().toLowerCase().contains(input))
			System.out.println(DataBase.gosti.get(key).toString());
		}
	}
	
	public static void pretragaGostPrezime() {
		System.out.println("Unesi parametar za pretragu gostiju po prezimenu.");
		String input = sc.nextLine().toLowerCase();
		for (String key : DataBase.gosti.keySet()) {
			if(DataBase.gosti.get(key).getPrezime().toLowerCase().contains(input))
			System.out.println(DataBase.gosti.get(key).toString());
		}
	}
	
	public static void pretragaGostBrojLK() {
		System.out.println("Unesi parametar za pretragu gostiju po broju licne karte:");
		String brojLK = IOHandler.unosBrojLK(); 
				
		for (String key : DataBase.gosti.keySet()) {			
			if(DataBase.gosti.get(key).getBrojLK().contains(((brojLK))));
			System.out.println(DataBase.gosti.get(key).toString());
		}
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////	
	public static void pretragaSobeBroj() {
		System.out.println("Unesi parametar za pretragu sobe po broju.");
		int input = IOHandler.unosInt();;
		for (int key : DataBase.sobe.keySet()) {
			if(DataBase.sobe.get(key).getBrSobe() == input )
			System.out.println(DataBase.sobe.get(key).toString());
		}
	}
	
	public static void pretragaSobaTV() {
		System.out.println("1) Sobe koje sadrze TV");
		System.out.println("2) Sobe koje ne sadrze TV");
		int input = Meni.izaberiMeniOpciju(3, false);
		if (input == 1)	{
			for (int key : DataBase.sobe.keySet()) {
				if(DataBase.sobe.get(key).isTv())
					System.out.println(DataBase.sobe.get(key).toString());
			}
		}
		else {			
			for (int key : DataBase.sobe.keySet()) {
			if(!DataBase.sobe.get(key).isTv())
				System.out.println(DataBase.sobe.get(key).toString());
			}		
		}
	}
	
	public static void pretragaSobaMiniBar() {
		System.out.println("1) Sobe koje sadrze miniBar");
		System.out.println("2) Sobe koje ne sadrze miniBar");
		int input = Meni.izaberiMeniOpciju(3, false);
		if (input == 1)	{
			for (int key : DataBase.sobe.keySet()) {
				if(DataBase.sobe.get(key).isMiniBar())
					System.out.println(DataBase.sobe.get(key).toString());
			}
		}
		else {			
			for (int key : DataBase.sobe.keySet()) {
			if(!DataBase.sobe.get(key).isMiniBar())
				System.out.println(DataBase.sobe.get(key).toString());
			}		
		}
	}

	public static void pretragaSobaAktivnost() {
		System.out.println("1) Sobe koje su aktivne");
		System.out.println("2) Sobe koje nisu aktivne");
		int input = Meni.izaberiMeniOpciju(3, false);
		if (input == 1)	{
			for (int key : DataBase.sobe.keySet()) {
				if(DataBase.sobe.get(key).isAktivnost())
					System.out.println(DataBase.sobe.get(key).toString());
			}
		}
		else {			
			for (int key : DataBase.sobe.keySet()) {
			if(!DataBase.sobe.get(key).isAktivnost())
				System.out.println(DataBase.sobe.get(key).toString());
			}		
		}
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////	
	public static void sortiranjeTipSobeIme(){
		TipSobe tipSobetemp = new TipSobe();
		for (int key : DataBase.tipSobe.keySet()) {
			
			tipSobetemp = DataBase.tipSobe.get(key);
			tipSobe.add(tipSobetemp);				
		}
		Collections.sort(tipSobe,(a,b)-> a.getNazivSobe().compareTo(b.getNazivSobe()));
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
		for(int i=0; i<sobe.size();i++) {
			System.out.println(sobe.get(i).toString());
		}
	}
	
	public static void sortiranjeSobeTip() {
		
	}
	
}
