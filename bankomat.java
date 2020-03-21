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

public class bankomat {

	public static void main(String[] args) throws IOException {
		zapisiIzFaila();
		glavniMeni();
		
    }
	public static void zapisiIzFaila() throws FileNotFoundException {
		boolean fileExists=false;
		File file= new File("racuni.txt");
		if(fileExists) {
			FileInputStream fileInputStream= new FileInputStream(file);
			ObjectInputStream objectInputStream;
			try {
				objectInputStream = new ObjectInputStream(fileInputStream);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for (int i=0;i<Racun.getArrayList().size();i++)
				try {
					Racun.getArrayList().add((Racun)(objectInputStream.readObject()));
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
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
		String imeVlasnika3=input.nextLine();
		
		provjeraKreiranjaRacuna(brojRacuna, iznosNaRacunu, imeVlasnika);
	    new Racun(brojRacuna, iznosNaRacunu, imeVlasnika);
	    glavniMeni();
	}
	if (unos==2) {
		System.out.println("Unesite racun s kojeg hocete da prebacite novac");
		int sourceBrRacun=input.nextInt();
		System.out.println("Unesite racun na koji hocete da prebacite novac");
		int targetBrRacun=input.nextInt();
		System.out.println("Unesite iznos koji hocete da prebacite");
		int iznos=input.nextInt();
		provjeraTransfera(sourceBrRacun,targetBrRacun,iznos);
		transferNovca(iznos);
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
	Racun noviRacun= new Racun(brojRacuna,iznosNaRacunu2,imeVlasnika);
	if(brojRacuna<0) {
	System.out.println("Ne mozete unijeti negativan broj");
	return false;}
	for(int i=0;i<Racun.getArrayList().size();i++) {
		if(Racun.getArrayList().get(i).getBrojRacuna()== brojRacuna) {
			System.out.println("Postojeci racun vec postoji");
	return false;}
	}
	if(Racun.getIznosNaRacunu()<0) {
		System.out.println("Imate negativan iznos na racunu, ne mozete napraviti racun");
		return false;
	}
	return true;
}

public static  boolean provjeraTransfera(int sourceBrRacun,int targetBrRacun,double iznos) {
		boolean sourceBrValid=false;
		boolean targetBrValid=false;
		boolean iznosValid=false;
		boolean enoughMoney=false;
		for(int i=0;i<Racun.getArrayList().size();i++) {
			
			if(Racun.getArrayList().get(i).Racun.getBrojRacuna()==sourceBrRacun) {
			sourceBrValid=true;
			return true;}
	
		if(racuni.get(i).brojRacuna==targetBrRacun) {
			targetBrValid=true;
			return true;}
	
		if(racuni.get(i).iznosNaRacunu-iznos<=0) 
			System.out.println("Iznos na racunu nije dovoljan za transfer");
		else enoughMoney=true;}
		if (enoughMoney && targetBrValid && sourceBrValid)
			return true;
		else return false;
}


public static void transferNovca(double iznosNaRacunu) {
	if(provjeraTransfera(brojRacuna, brojRacuna, iznosNaRacunu)) {
		for (int i=0;i<racuni.size();i++) {

			int sourceBrRacuna=0;
			double iznos=0;
			if(Racun.getArrayList().get(i).get(i).getBrojRacuna()==sourceBrRacuna) 

				Racun.getArrayList().get(i).getIznosNaRacunu()-=iznos;

			if((Racun.getArrayList().get(i)).getBrojRacuna()==targetBrRacuna) {

				Racun.getArrayList().get(i).get(i).iznosNaRacunu+=iznos;
				System.out.println("uspjesna transakcija");}
			else System.out.println("nije uspjesna");
}
			}
}
}