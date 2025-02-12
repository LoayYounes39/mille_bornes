package mille_bornes;

public class Parade extends Bataille {

	public Parade(Type type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.getType().getNomParade();
	}

}
