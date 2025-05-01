package Jeu;

import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Set;

import cartes.Carte;

public class Joueur {
	String nom; 
	ZoneDeJeu zone; 
	MainJoueur main = new MainJoueur();
	
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
	public ZoneDeJeu getZone() {
		return zone;
	}
	public HashSet<Coup> coupsPossibles(Set<Joueur> participants){
		HashSet<Coup> coups = new HashSet<>();
		for (Joueur participant : participants) {
			MainJoueur mainJ = participant.getMain();
			ListIterator<Carte> itCartes = mainJ.getListeCartes().listIterator();
			while (itCartes.hasNext()) {
				Carte carte = itCartes.next();
				Coup coup = new Coup(this, carte, participant);
				if (coup.estValide()) {
					coups.add(coup);
				}
			}
		}
		return coups;
	}
	public HashSet<Coup> coupsDefausse(){
		HashSet<Coup> coups = new HashSet<>();
		ListIterator<Carte> itCartes = main.getListeCartes().listIterator();
		while (itCartes.hasNext()) {
			Carte carte = itCartes.next();
			Coup coup = new Coup(this, carte, null);
			if (coup.estValide()) {
				coups.add(coup);
			}
		}
		return coups;
	}
	public void retirerDeLaMain(Carte carte) {
		main.getListeCartes().remove(carte);
	}
 
	
}
