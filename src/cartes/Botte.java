package cartes;

public class Botte extends Probleme {

	public Botte(Type type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.getType().getNomBotte();
	}
	@Override
	public boolean equals(Object obj) {
		boolean estEgal = super.equals(obj);
		if (estEgal) {
			Botte botte = (Botte)obj;
			return getType().getNomBotte().equals(botte.getType().getNomBotte());
		}
		return estEgal;
	}

}
