package strategies;

import java.util.Comparator;
import java.util.HashSet;
import java.util.NavigableSet;
import java.util.Random;
import java.util.TreeSet;

import Jeu.Coup;
import Jeu.Joueur;
import cartes.Attaque;
import cartes.Botte;
import cartes.Carte;
import cartes.Type;

public interface Presse extends Strategie, Priorite {
	public default TreeSet<Coup> trierCoups(HashSet<Coup> ensCoup){
		NavigableSet <Coup> coups = new TreeSet<Coup> (new Comparator<Coup>() {
			private int comparerCartes(Joueur joueur, Carte carte1, Carte carte2) {
				Integer comparaison = null;
				comparaison = donnerPrioriteLimites(carte1, carte2);
				if(comparaison != null) {
					return comparaison;
				}
				comparaison = donnerPrioriteBornes(carte1, carte2);
				if(comparaison != null) {
					return comparaison;
				}
				Carte carteSommet = joueur.donnerSommetPile();
				if(carteSommet instanceof Attaque attaque) {
					Type typeProbleme = attaque.getType();
					if(joueur.donnerBottes().contains(new Botte(typeProbleme))) {
						typeProbleme = Type.FEU;
					}
					comparaison = donnerPrioriteBottes(typeProbleme, carte1, carte2);
					if(comparaison != null) {
					return comparaison;
					}
					}
					comparaison = donnerPrioriteParades(carte1, carte2);
					if(comparaison != null) {
						return comparaison;
					}
					Random rnd = new Random();
					if (rnd.nextBoolean()) {
						return 1;
					} else {
						return -1;
					}
				}

			@Override
			public int compare(Coup o1, Coup o2) {
				int res = o1.compareTo(o2);
				if (res == 0) {
					return comparerCartes (o1.getJoueurCible(), o1.getCarteJouee(), o2.getCarteJouee());
				}
				return res;
			}
			});
		coups.addAll(ensCoup);
		return (TreeSet<Coup>)coups;
}
}
