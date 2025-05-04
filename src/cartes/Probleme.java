package cartes;

import java.util.Objects;

public abstract class Probleme extends Carte implements Comparable<Probleme>{
	private Type type;

	
	
	protected Probleme(Type type) {
		super();
		this.type = type;
	}




	public Type getType() {
		return type;
	}

	@Override
	public boolean equals(Object obj) {
		boolean estEgal = super.equals(obj);
		if (estEgal) {
			Probleme probleme = (Probleme) obj;
			return type.equals(probleme.type);
		}
		return estEgal;
	}

	@Override
	public int hashCode() {
		return Objects.hash(type);
	}
	
	@Override 
	public int compareTo(Probleme probleme) {
		return type.compareTo(probleme.type);
	}





	
}
