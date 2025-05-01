package Jeu;

import java.util.HashSet;
import java.util.ListIterator;
import java.util.Set;

import cartes.Attaque;
import cartes.Carte;
import cartes.Limite;

public class Coup {
	Joueur joueurCourant; 
	Carte carteJouee; 
	Joueur joueurCible;
	public Coup(Joueur joueurCourant, Carte carteJouee, Joueur joueurCible) {
		super();
		this.joueurCourant = joueurCourant;
		this.carteJouee = carteJouee;
		this.joueurCible = joueurCible;
	}
	public Joueur getJoueurCourant() {
		return joueurCourant;
	}
	public Carte getCarteJouee() {
		return carteJouee;
	}
	public Joueur getJoueurCible() {
		return joueurCible;
	}
	public boolean estValide() {
		if (carteJouee instanceof Attaque || carteJouee instanceof Limite) {
			return ! joueurCible.equals(joueurCourant);
		}
		return true;
	}
	
}
