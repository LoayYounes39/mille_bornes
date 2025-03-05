package cartes;

public abstract class Carte {
	
	@Override
	public String toString() {
		return "";
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		// C'est pas une bonne pratique !! 
		return this.getClass() == obj.getClass() && toString().equals(obj.toString()) ;
	}
}
