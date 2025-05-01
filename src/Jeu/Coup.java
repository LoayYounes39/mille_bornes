package Jeu;

import java.util.HashSet;
import java.util.ListIterator;
import java.util.Set;

import cartes.Attaque;
import cartes.Carte;
import cartes.Limite;

public class Coup {
	private Joueur joueurCourant; 
	private Carte carteJouee; 
	private Joueur joueurCible;
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
	@Override
	public String toString() {
		if (joueurCible == null) {
			return "defausse la carte " + carteJouee;
		}
		if (joueurCible.equals(joueurCourant)) {
			return "depose la carte " + carteJouee + " dans sa zone de jeu" ;
		}
		return "depose la carte " + carteJouee + " dans la zone de jeu de " + joueurCible;
	}
	
}
