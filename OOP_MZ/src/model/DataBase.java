package model;

import java.util.ArrayList;
import java.util.HashMap;

public class DataBase {
	
	public static HashMap<String,Korisnik> korisnici=new HashMap<String,Korisnik>();
	
	public static HashMap<String,Gost> gosti=new HashMap<String,Gost>();

	public static HashMap<String, ArrayList<Iznajmljivanje>> getIznajmljivanja() {
		return iznajmljivanja;
	}

	public static void addIznajmljivanja(String key, Iznajmljivanje iznajmljivanje) {

		if(!DataBase.iznajmljivanja.containsKey(key)) {
			ArrayList<Iznajmljivanje> lista = new ArrayList<>();
			lista.add(iznajmljivanje);
			DataBase.iznajmljivanja.put(key, lista);
		}else {
			DataBase.iznajmljivanja.get(key).add(iznajmljivanje);
			}
			
	}

	public static HashMap<Integer,Soba> sobe=new HashMap<Integer,Soba>();
	public static HashMap<Integer, TipSobe> tipSobe = new HashMap<Integer, TipSobe>();
	
	public static HashMap<Integer, Cenovnik> cenovnik = new HashMap<Integer, Cenovnik>();
	
	public static  HashMap<String, ArrayList<Iznajmljivanje>> iznajmljivanja = new HashMap<>();

}
