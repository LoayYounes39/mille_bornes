package cartes;

public abstract class Carte {
	

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		// C'est pas une bonne pratique !! 
		return this.getClass() == obj.getClass() ;
	}
}
