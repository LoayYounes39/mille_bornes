package mille_bornes;

public abstract class Probleme extends Carte {
	private Type type;

	
	
	protected Probleme(Type type) {
		super();
		this.type = type;
	}



	@Override
	public String toString() {
		return "";
	}



	public Type getType() {
		return type;
	}

}
