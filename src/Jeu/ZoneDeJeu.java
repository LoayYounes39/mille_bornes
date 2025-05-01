package Jeu;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import cartes.Limite;
import cartes.Parade;
import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;
public class ZoneDeJeu {
	private LinkedList <Limite> pileLimites = new LinkedList<Limite>();
	private LinkedList <Bataille> pileBatailles = new LinkedList<Bataille>();
	private Collection<Borne> collectionBornes = new LinkedList<Borne>();
	private Set <Botte> bottes = new HashSet <>();
	
	public int donnerLimitationVitesse() {
		if (estPrioritaire()) {
			return 0;
		}
		if (pileLimites.isEmpty()) {
			return 200;
		} 
		if (pileLimites.getFirst() instanceof FinLimite) {
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
		} else if (c instanceof Botte) {
			bottes.add((Botte) c);
		}
	}
	public boolean peutAvancer() {
		if (pileBatailles.isEmpty()){
			if (estPrioritaire()) {
				return true;
			}
			return false;
		}
		Bataille bataille = pileBatailles.getFirst();
		return bataille.equals(Cartes.FEU_VERT) || estPrioritaire() && ( bataille instanceof Parade 
				|| bataille.equals(Cartes.FEU_ROUGE) || ( bataille instanceof Attaque && bottes.contains(new Botte(bataille.getType())) ) );
	}
	private boolean estDepotFeuVertAutorise() {
		if (estPrioritaire()) {
			return false;
		}
		if (pileBatailles.isEmpty()) {
			return true;
		}

		Carte carte = pileBatailles.getFirst();
		return carte.equals(Cartes.FEU_ROUGE)
				|| (carte instanceof Parade && ! carte.equals(Cartes.FEU_VERT)) || ( carte instanceof Attaque && bottes.contains(new Botte( ((Attaque) carte).getType())) );
	}
	 private boolean estDepotBorneAutorise(Borne borne) {
		 return peutAvancer() && 
				 borne.getKm() <= donnerLimitationVitesse()
				 && donnerKmParcourus() <= 1000;
	 }
	 private boolean estDepotLimiteAutorise(Limite limite) {
		 if (estPrioritaire()) {
			 return false;
		 }
		 if (limite instanceof DebutLimite) {
			 if (pileLimites.isEmpty()) {
				 return true;
			 } else {
				 return pileLimites.getFirst() instanceof FinLimite;
			 }
		 } else {
			 return !pileLimites.isEmpty() 
					 && pileLimites.getFirst() instanceof DebutLimite;	 
		 }
	 }
	 private boolean estDepotBatailleAutorise(Bataille bataille) {
		 if (bottes.contains(new Botte(bataille.getType()))) {
			 return false;
		 }
		 if (bataille instanceof Attaque) {
			 return peutAvancer();
		 } 
		 if (bataille.equals(Cartes.FEU_VERT)) {
			 if (pileBatailles.isEmpty()) {
				 return true;
			 } 
			 return estDepotFeuVertAutorise();
		 }
		 return !pileBatailles.isEmpty() && pileBatailles.getFirst().getType().equals(bataille.getType());
	 }
	 public boolean estDepotAutorise(Carte carte) {
		 if (carte instanceof Bataille) {
			 return estDepotBatailleAutorise((Bataille)carte);
		 } else if (carte instanceof Borne) {
			 return estDepotBorneAutorise((Borne) carte);
		 } else if (carte instanceof Limite) {
			 return estDepotLimiteAutorise((Limite) carte);
		 } else if (carte instanceof Botte) {
			 return true;
		 }
		 return false;
	 }
	 public boolean estPrioritaire() {
		 return bottes.contains(Cartes.PRIORITAIRE);
	 }
	public Set<Botte> getBottes() {
		return bottes;
	}
	public boolean isPileLimitesEmpty() {
		return pileLimites.isEmpty();
	}
	public Bataille sommetPileBatailles() {
		if (pileBatailles.isEmpty()) {
			return null;
		}
		return pileBatailles.getFirst();
	}
	
	 

}