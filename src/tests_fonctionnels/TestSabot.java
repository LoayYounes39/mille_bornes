package tests_fonctionnels;

import Jeu.Sabot;
import cartes.Carte;
import cartes.JeuDeCartes;

public class TestSabot {
	public static void main(String[] args) {
		JeuDeCartes jc = new JeuDeCartes();
		Carte[] cartes = jc.donnerCartes();
		Sabot sabot = new Sabot(cartes);
		int nbCartes = sabot.getNbCartes();
		for (int i = 0; i < nbCartes; i++) {
			System.out.println( "Je pioche " + sabot.piocher().toString());
		}
	}
}
