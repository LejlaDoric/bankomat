
import java.io.Serializable;
import java.util.ArrayList;

	public class Racun implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int brojRacuna;
	private String imeVlasnika;
	private double iznosNaRacunu;
	
	public static ArrayList<Racun> racuni= new ArrayList<Racun>();
	private static Zapisnik z= new Zapisnik();


	Racun(int brojRacuna, double iznosNaRacunu, String imeVlasnika){
				
				this.brojRacuna=brojRacuna;
				this.imeVlasnika=imeVlasnika;
				this.iznosNaRacunu=iznosNaRacunu;
				racuni.add(this);
				z.zapisiTrenutneDetaljeRacuna(brojRacuna,  iznosNaRacunu, imeVlasnika);
		
	}
		
	

	public int getBrojRacuna() {
		return brojRacuna;
	}



	public void setBrojRacuna(int brojRacuna) {
		this.brojRacuna = brojRacuna;
	}



	public String getImeVlasnika() {
		return imeVlasnika;
	}



	public void setImeVlasnika(String imeVlasnika) {
		this.imeVlasnika = imeVlasnika;
	}



	public double getIznosNaRacunu() {
		return iznosNaRacunu;
	}



	public void setIznosNaRacunu(double iznosNaRacunu) {
		this.iznosNaRacunu = iznosNaRacunu;
	}



	public  static void ispisiRacun(int brojRacuna) {
		for(int i=0;i<racuni.size();i++) {
			if (racuni.get(i).getBrojRacuna()==brojRacuna) {
			System.out.println("Broj racuna je: "+racuni.get(i).getBrojRacuna()+" Ime vlasnika: "+racuni.get(i).getImeVlasnika()+" Stanje na racunu "+racuni.get(i).getIznosNaRacunu());
		}
	} 
}
	
	public static Racun getRacun(int brojRacuna) {
		for(int i=0;i<racuni.size();i++) {
			if (racuni.get(i).brojRacuna==brojRacuna) 
			return racuni.get(i);
		
	}
		return null;
	}
	
	public static ArrayList<Racun> getArrayList(){
		return racuni;
	}
	
	


	
	
}



		
		
	
