package cartes;

public class Borne extends Carte implements Comparable<Borne>{
	 private int km;

	public Borne(int km) {
		super();
		this.km = km;
	}

	public int getKm() {
		return km;
	}

	@Override
	public String toString() {
		return  km + " KM";
	}
	@Override
	public boolean equals(Object obj) {
		boolean estEgal = super.equals(obj);
		if (estEgal) {
			Borne borne = (Borne) obj;
			return km == borne.km;
		}
		return estEgal;
	}

	@Override
	public int compareTo(Borne o) {
		return km - o.getKm();
	}
	
	
}
