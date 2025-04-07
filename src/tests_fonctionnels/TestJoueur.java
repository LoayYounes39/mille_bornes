package tests_fonctionnels;

import Jeu.Joueur;
import Jeu.ZoneDeJeu;
import cartes.Borne;
import cartes.DebutLimite;
import cartes.FinLimite;

public class TestJoueur {
	public static void main(String[] args) {
		Joueur joueur1 = new Joueur("X", new ZoneDeJeu());
		joueur1.deposer(new Borne(25));
		System.out.println("Déposer carte 25 km.");
		joueur1.deposer(new Borne(50));
		System.out.println("Déposer carte 50 km.");
		joueur1.deposer(new Borne(75));
		System.out.println("Déposer carte 75 km.");
		System.out.println("Total des bornes " + joueur1.donnerKmParcourus());
		ZoneDeJeu zone = joueur1.getZone();
		joueur1.deposer(new FinLimite());
		joueur1.deposer(new DebutLimite());
		joueur1.deposer(new FinLimite());
		for (int i =0; i < 3; i++) {
			System.out.println("Limite: " + zone.donnerLimitationVitesse());
		}
		
	}
}
