package mille_bornes;

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

}
