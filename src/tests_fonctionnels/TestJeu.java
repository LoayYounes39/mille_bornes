package tests_fonctionnels;

import Jeu.Jeu;
import Jeu.Joueur;
import Jeu.ZoneDeJeu;
import cartes.JeuDeCartes;

public class TestJeu {
	public static void main(String[] args) {
		Jeu jeu = new Jeu();
		jeu.inscrire(new Joueur("Loay", new ZoneDeJeu()), new Joueur ("Maeva", new ZoneDeJeu()), new Joueur("Mathis", new ZoneDeJeu()));
		jeu.distribuerCartes();
		System.out.println(jeu.lancer());
	}
}
