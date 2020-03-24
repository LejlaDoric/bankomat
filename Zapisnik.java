
public class Zapisnik {
public static String zapisnikString= "";
		public void zapisiTrenutneDetaljeRacuna(int brojRacuna, double iznosNaRacunu, String imeVlasnika){
			zapisnikString+="Broj racuna je: "+brojRacuna+"Iznos na racunu je: "+iznosNaRacunu+"Ime vlasnika je: "+imeVlasnika;
		}
		public static String getZapisnikString() {
			return zapisnikString;
		}
}
