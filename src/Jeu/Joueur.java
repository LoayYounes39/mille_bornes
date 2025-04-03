package Jeu;

public class Joueur {
	String nom; 
	ZoneDeJeu zone; 
	MainJoueur main;
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Joueur) {
			Joueur joueur = (Joueur) obj;
			return (nom.equals(joueur.nom));
		}
		return this.equals(obj);
	}
	@Override
	public String toString() {
		return nom;
	}
}
