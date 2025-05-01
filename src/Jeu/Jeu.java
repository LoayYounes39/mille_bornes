package Jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class Jeu {
	private Sabot sabot; 
	private static final int NB_CARTES = 6;
	HashSet<Joueur> joueurs = new LinkedHashSet<>();
	Iterator<Joueur> it = joueurs.iterator();
	
	public Jeu() {
		JeuDeCartes jc = new JeuDeCartes();
		Carte[] tabCartes = jc.donnerCartes();
		List<Carte> listeCartes = new ArrayList<Carte>();
		Collections.addAll(listeCartes, tabCartes);
		listeCartes = GestionCartes.melanger(listeCartes);
		Carte[] tabCartesArr = new Carte[listeCartes.size()];
		tabCartesArr = listeCartes.toArray(tabCartesArr);
		sabot = new Sabot(tabCartesArr);	
		
	}
	public void inscrire(Joueur... joueursAInscrire) {
		for (Joueur joueur : joueursAInscrire) {
			joueurs.add(joueur);
		}
	}
	public void distribuerCartes() {
		for (int i = 0; i < NB_CARTES; i++) {
			Iterator<Joueur> it = joueurs.iterator();
			while (it.hasNext()) {
				Joueur joueur = it.next();
				Carte carte = sabot.piocher();
				joueur.donner(carte);
			}
		}
	}
	
	public String jouerTour (Joueur joueur) {
		StringBuilder sb = new StringBuilder();
		Carte carte = joueur.prendreCarte(sabot); 
		joueur.getMain().prendre(carte);
		sb.append("Le joueur ").append(joueur).append(" a pioché ").append(carte).append("\n").append("\n");
		sb.append("Il a dans sa main : ").append(joueur.getMain()).append("\n");
		Coup coupSelectionne = joueur.choisirCoup(joueurs); 
		joueur.retirerDeLaMain(carte);
		if (coupSelectionne.getJoueurCible() == null) {
			joueur.deposer(carte);
		} else {
			joueur.deposerJoueurCible(coupSelectionne.getJoueurCible(), carte);
		}
		sb.append(coupSelectionne).append("\n").append("\n");
		return sb.toString();
	}
	public HashSet<Joueur> getJoueurs() {
		return joueurs;
	}
	public String lancer() {
		StringBuilder sb = new StringBuilder();
		Joueur joueur;
		do {
			joueur = donnerJoueurSuivant(); 
			sb.append(jouerTour(joueur));
		} while (joueur.donnerKmParcourus() < 1000);
		if (! sabot.estVide()) {
			sb.append(jouerTour(joueur));
		}
		return sb.toString();
	}
	public Joueur donnerJoueurSuivant () {
		if (! it.hasNext()) {
			it = joueurs.iterator(); 
		}
		return it.next();
	}
	
}
