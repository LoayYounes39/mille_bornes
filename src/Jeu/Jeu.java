package Jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class Jeu {
	private Sabot sabot; 
	HashSet<Joueur> joueurs = new LinkedHashSet<>();
	
	public Jeu() {
		JeuDeCartes jc = new JeuDeCartes();
		Carte[] tabCartes = jc.donnerCartes();
		List<Carte> listeCartes = new ArrayList<Carte>();
		Collections.addAll(listeCartes, tabCartes);
		listeCartes = GestionCartes.melanger(listeCartes);
		Carte [] tabCartesArr = (Carte[]) listeCartes.toArray();
		sabot = new Sabot(tabCartesArr);	
		
	}
	public void inscrire(Joueur... joueursAInscrire) {
		for (Joueur joueur : joueursAInscrire) {
			joueurs.add(joueur);
		}
	}
 
}
