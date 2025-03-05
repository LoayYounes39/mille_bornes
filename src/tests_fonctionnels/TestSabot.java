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
		// La methode de piocher (petit a)
		// Inserer l'as du volant  NoSuchElementException (petit c)
		//System.out.println( "Je pioche " + sabot.piocher().toString());
		/*for (int i = 0; i < nbCartes; i++) {
			System.out.println( "Je pioche " + sabot.piocher().toString());
		}*/
		// la methode de iterateur + remove */ (petit b)
		Iterator<Carte> it = sabot.iterator();
		for (int i = 0; i < nbCartes; i++) {
			Carte prochaineCarte = it.next();
			System.out.println("Je pioche " + prochaineCarte.toString());
			it.remove();
			//Concurrent modification exception (petit c)
			System.out.println("Je pioche " + sabot.piocher().toString());
		}
		
	}
}
