package Jeu;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import cartes.Limite;
import cartes.Bataille;
import cartes.Borne;
import cartes.Carte;
import cartes.FinLimite;
public class ZoneDeJeu {
	LinkedList <Limite> pileLimites = new LinkedList<Limite>();
	LinkedList <Bataille> pileBatailles = new LinkedList<Bataille>();
	Collection<Borne> collectionBornes = new LinkedList<Borne>();
	Iterator<Limite> itLim = pileLimites.iterator();
	public int donnerLimitationVitesse() {
		if (pileLimites.isEmpty()) {
			return 200;
		} 
		Limite premLim = itLim.next();
		if (premLim instanceof FinLimite) {
			return 200;
		}
		return 50;
	}
	public int donnerKmParcourus() {
		Iterator<Borne> it = collectionBornes.iterator();
		int somme = 0;
		while (it.hasNext()) {
			Borne borne = it.next();
			somme += borne.getKm();
		}
		return somme;
	}
	public void deposer (Carte c) {
		if (c instanceof Limite) {
			pileLimites.add(0, (Limite) c);
		} else if (c instanceof Bataille) {
			pileBatailles.add(0, (Bataille) c);
		} else if (c instanceof Borne) {
			collectionBornes.add((Borne) c);
		}
	}
}