import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class bankomat {//Klasa velikim slovom, molit cu! Čuvaj zdravlje, cuvaj se.

	public static void main(String[] args) throws IOException, EOFException, ClassNotFoundException {
		zapisiIzFaila();
		glavniMeni();
	}
	
	public static void zapisiIzFaila() throws IOException, ClassNotFoundException {
		
		File file= new File("racuni.txt");
		
		if (!file.exists()) { 
			file.createNewFile();
			return;
		}
		
		FileInputStream fileInputStream= new FileInputStream(file);
		ObjectInputStream objectInputStream = null;
			
			try {
				objectInputStream = new ObjectInputStream(fileInputStream);
			}  catch (EOFException e) {
				return;
			}
			
		
			while(true) 
				try {
				Racun.getArrayList().add((Racun)(objectInputStream.readObject()));
				} catch(EOFException e) {
					break;
				}
				
			
	    } 
	    
	
	
public static void glavniMeni() throws IOException {
	int  brojRacuna;
	double iznosNaRacunu;
	String imeVlasnika;
	Scanner input=new Scanner(System.in);
	System.out.println("1. Kreiranje racuna");
	System.out.println("2. Prebacivanje novca");
	System.out.println("3. Ispisivanje postojeceg racuna");
	System.out.println("4. Napustite aplikaciju");
	System.out.println("Pisite zeljeni broj za odredjenu akciju");
	int unos=input.nextInt();

	if(unos==1) {
		System.out.println("Unesite broj racuna");
		brojRacuna = input.nextInt();
		System.out.println("Unesite iznos na racunu");
		iznosNaRacunu=input.nextInt();
		String imeVlasnika2=input.nextLine();
		System.out.println("Unesite ime vlasnika");
		imeVlasnika=input.nextLine();
		
		
		if(provjeraKreiranjaRacuna(brojRacuna, iznosNaRacunu, imeVlasnika)) {
			new Racun(brojRacuna, iznosNaRacunu, imeVlasnika);
			System.out.println("Racun je kreiran...");
		} else
			System.out.println("Racun nije kreiran...");
		
	    glavniMeni();
	}
	if (unos==2) {
		System.out.println("Unesite racun s kojeg hocete da prebacite novac");
		int sourceBrRacuna=input.nextInt();
		System.out.println("Unesite racun na koji hocete da prebacite novac");
		int targetBrRacuna=input.nextInt();
		System.out.println("Unesite iznos koji hocete da prebacite");
		int iznos=input.nextInt();
		if (provjeraTransfera(sourceBrRacuna,targetBrRacuna,iznos)) {
		transferNovca(sourceBrRacuna, targetBrRacuna, iznos);}
		glavniMeni();
	}
	if(unos==3) {
		System.out.println("Unesite vas broj racuna");
		 brojRacuna=input.nextInt();
		Racun.ispisiRacun(brojRacuna);
		glavniMeni();
	}
		if(unos==4) {
		File file = new File("racuni.txt");
		 
		if (!file.exists()) { 
			 file.createNewFile();
		}
			FileOutputStream fileOutputStream= new FileOutputStream(file);
			ObjectOutputStream objectOutputStream= new ObjectOutputStream(fileOutputStream);
		
		 for(int i=0;i<Racun.getArrayList().size();i++) {
			 objectOutputStream.writeObject((Racun.getArrayList().get(i)));
		 }
				 
	
			
		 //Pohrani sve objekte koji su do sada nacinjeni
		 System.exit(0);
	 
			
			
	 }
}

public static boolean provjeraKreiranjaRacuna(int brojRacuna,double iznosNaRacunu2,String imeVlasnika) throws EOFException, IOException  {
	
	if(brojRacuna<0) {
		System.out.println("Ne mozete unijeti negativan broj");
		return false;
	}
	
	
	for(int i=0;i<Racun.getArrayList().size();i++) {
		if(Racun.getArrayList().get(i).getBrojRacuna()== brojRacuna) {
			System.out.println("Postojeci racun vec postoji");
			return false;
		}
	}
	
	if(iznosNaRacunu2<0) {
		System.out.println("Imate negativan iznos na racunu, ne mozete napraviti racun");
		return false;
	}
	
	
	return true;
	
	}

	public static  boolean provjeraTransfera(int sourceBrRacuna,int targetBrRacuna,double iznos ) {
	
		
			if (Racun.getRacun(sourceBrRacuna)==null) {
				System.out.println("Source broj racuna ne postoji");
				return false;
			}
			if (Racun.getRacun(targetBrRacuna)==null) {
				System.out.println("Target broj racuna ne postoji");
				return false;
			}
			if(Racun.getRacun(sourceBrRacuna).getIznosNaRacunu()-iznos<0) {
				System.out.println("Iznos na source racunu nije dovoljan za transfer");
				return false;
			}
			
			return true;
				
			
		
}


	public static void transferNovca(int sourceBrRacuna,int targetBrRacuna,double iznos) {
	
		Racun.getRacun(sourceBrRacuna).setIznosNaRacunu(Racun.getRacun(sourceBrRacuna).getIznosNaRacunu()-iznos);
		Racun.getRacun(targetBrRacuna).setIznosNaRacunu(Racun.getRacun(sourceBrRacuna).getIznosNaRacunu()+iznos);
		
			
	}

}