package tests_fonctionnels;

import java.util.Iterator;

import Jeu.Sabot;
import cartes.Carte;
import cartes.JeuDeCartes;

public class TestSabot {
	public static void main(String[] args) {
		JeuDeCartes jc = new JeuDeCartes();
		Carte[] cartes = jc.donnerCartes();
		Sabot sabot = new Sabot(cartes);
		int nbCartes = sabot.getNbCartes();
		// La méthode de piocher (petit a)
		// Insérer l'as du volant lève NoSuchElementException (petit c)
		System.out.println( "Je pioche " + sabot.piocher().toString());
		for (int i = 0; i < nbCartes; i++) {
			System.out.println( "Je pioche " + sabot.piocher().toString());
		}
		// la méthode de itérateur + remove */ (petit b)
		Iterator<Carte> it = sabot.iterator();
		for (int i = 0; i < nbCartes; i++) {
			Carte prochaineCarte = it.next();
			System.out.println("Je pioche " + prochaineCarte.toString());
			it.remove();
			// Ça met Concurrent modification exception (petit c)
			System.out.println("Je pioche " + sabot.piocher().toString());
		}
		
	}
}
