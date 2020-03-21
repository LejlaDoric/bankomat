
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.io.EOFException;
import java.io.File;

	public class Racun implements Serializable{
	private static final long serialVersionUID = 1L;
	private static int brojRacuna;
	private static String imeVlasnika;
	private static double iznosNaRacunu;
	public static ArrayList<Racun> racuni= new ArrayList<Racun>();
	private static Zapisnik z= new Zapisnik();
	private static int targetBrRacuna;


	Racun(int brojRacuna, double iznosNaRacunu, String imeVlasnika){
		
			try {
				if(bankomat.provjeraKreiranjaRacuna(brojRacuna, iznosNaRacunu, imeVlasnika)) {
					setBrojRacuna(brojRacuna);
					setImeVlasnika(imeVlasnika);
					setIznosNaRacunu(iznosNaRacunu);
					racuni.add(this);
					System.out.println("Racun je kreiran");
					z.zapisiTrenutneDetaljeRacuna(brojRacuna,  iznosNaRacunu, imeVlasnika);}
				else System.out.println("Racun nije kreiran");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
		
	private void setIznosNaRacunu(double iznosNaRacunu2) {
		// TODO Auto-generated method stub
		
	}

	private void setImeVlasnika(String imeVlasnika2) {
		// TODO Auto-generated method stub
		
	}

	public  static void ispisiRacun(int brojRacuna) {
		for(int i=0;i<racuni.size();i++) {
			if (racuni.get(i).getBrojRacuna()==brojRacuna) {
			racuni.get(i);
			System.out.println("Broj racuna je: "+Racun.getBrojRacuna()+" Ime vlasnika: "+racuni.get(i).imeVlasnika+" Stanje na racunu "+racuni.get(i).iznosNaRacunu);
		}
	} 
}
	
	public Racun getRacun(int brojRacuna) {
		for(int i=0;i<racuni.size();i++) {
			if (racuni.get(i).getBrojRacuna()==brojRacuna) 
			return racuni.get(i);
		
	}
		return null;
	}
	public static ArrayList<Racun> getArrayList(){
		return racuni;
	}

	public static int getBrojRacuna() {
		return brojRacuna;
	}
	public static double getIznosNaRacunu() {
		return iznosNaRacunu;
	}
	public static String getImeVlasnika() {
		return imeVlasnika;
	}
	public static void setBrojRacuna(int brojRacuna) {
		Racun.brojRacuna = brojRacuna;
	}
}



		
		
	
