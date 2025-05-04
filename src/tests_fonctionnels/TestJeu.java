package tests_fonctionnels;

import Jeu.Jeu;
import Jeu.Joueur;
import Jeu.ZoneDeJeu;
import cartes.JeuDeCartes;
import strategies.Presse;

public class TestJeu {
	public static void main(String[] args) {
		Jeu jeu = new Jeu();
		Joueur loay = new Joueur("Loay", new ZoneDeJeu()); 
		Joueur maeva = new Joueur ("Maeva", new ZoneDeJeu()); 
		Joueur mathis =  new Joueur("Mathis", new ZoneDeJeu());
		loay.setStrategie(new Presse() {});
		maeva.setStrategie(new Presse() {}); 
		jeu.inscrire(loay, maeva, mathis);
		jeu.distribuerCartes();
		System.out.println(jeu.lancer());
	}
}
