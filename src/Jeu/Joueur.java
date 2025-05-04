package Jeu;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import cartes.Botte;
import cartes.Carte;
import strategies.Strategie;

public class Joueur implements Comparable<Joueur> {
	String nom; 
	ZoneDeJeu zone; 
	MainJoueur main = new MainJoueur();
	
	private Strategie strategie = new Strategie() {
		
	};
	
	
	
	public void setStrategie(Strategie strategie) {
		this.strategie = strategie;
	}
	
	public Joueur(String nom, ZoneDeJeu zone) {
		super();
		this.nom = nom;
		this.zone = zone;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Joueur) {
			Joueur joueur = (Joueur) obj;
			return (nom.equals(joueur.nom));
		}
		return this.equals(obj);
	}
	@Override
	public String toString() {
		return nom;
	}
	public MainJoueur getMain() {
		return main;
	}
	public void donner(Carte carte) {
		main.prendre(carte);
	}
	public Carte prendreCarte (Sabot sabot) {
		Iterator<Carte> it = sabot.iterator();
		if (! it.hasNext()) {
			return null;
		} 
		return sabot.piocher();
	}
	public int donnerKmParcourus() {
		return zone.donnerKmParcourus();
	}
	public void deposer(Carte c) {
		zone.deposer(c);
	}
	public void deposerJoueurCible (Joueur joueur, Carte carte) {
		ZoneDeJeu zone = joueur.getZone(); 
		zone.deposer(carte);
	}
	public ZoneDeJeu getZone() {
		return zone;
	}
	private void ajouterCoups ( Set<Coup> coups, Iterator<Carte> itCartes, Joueur participant) {
		while (itCartes.hasNext()) {
			Carte carte = itCartes.next();
			Coup coup = new Coup(this, carte, participant);
			if (coup.estValide()) {
				coups.add(coup);
			}
		}
	}
	public HashSet<Coup> coupsPossibles(Set<Joueur> participants){
		HashSet<Coup> coups = new HashSet<>();
		for (Joueur participant : participants) {
			ListIterator<Carte> itCartes = main.getListeCartes().listIterator();
			ajouterCoups (coups,itCartes, participant);
		}
		return coups;
	}
	
	public HashSet<Coup> coupsDefausse(){
		HashSet<Coup> coups = new HashSet<>();
		ListIterator<Carte> itCartes = main.getListeCartes().listIterator();
		ajouterCoups (coups,itCartes, null);
		return coups;
	}
	
	public void retirerDeLaMain(Carte carte) {
		main.jouer(carte);
	}
	private Coup choisirCoupAleatoire (Set<Coup> coups){
		Random rnd = new Random();
		Iterator<Coup> itCoups = coups.iterator();
		for (int ind = rnd.nextInt(coups.size()) ; ind > 0; ind --) {
			itCoups.next();
		}
		return itCoups.next(); 
	}
	public Coup choisirCoup (Set<Joueur> participants) {
		// L'ordre pour le hashset est aléatoire (Pourant il est conservé)	
		HashSet <Coup> coupsPos = (HashSet<Coup>) coupsPossibles(participants);
		if ( coupsPos.isEmpty() ) {
			//return choisirCoupAleatoire(coupsDefausse());
			return strategie.selectionnerDefausse(coupsDefausse());
		}
			return strategie.selectionnerCoup(coupsPos);
		}
	public String afficherEtatJoueur() {
		StringBuilder sb = new StringBuilder();
		sb.append(zone.getBottes() + "\n");
		sb.append(zone.isPileLimitesEmpty() + "\n");
		sb.append(zone.sommetPileBatailles() + "\n");
		sb.append(main.getListeCartes() + "\n");
		return sb.toString();
	}

	@Override
	public int compareTo(Joueur o) {
		int difKm = donnerKmParcourus() - o.donnerKmParcourus();
		if (difKm == 0) {
			return nom.compareTo(o.nom);
		}
		return difKm;
	}

	public Carte donnerSommetPile() {
		return zone.sommetPileBatailles();
	}

	public Set<Botte> donnerBottes() {
		return zone.getBottes();
	}

}
