package Jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot implements Iterable<Carte> {
	private Carte[] cartes;
	private int nbCartes = 0;
	public int getNbCartes() {
		return nbCartes;
	}
	private int nbOperationsRef = 0;
	public Sabot(Carte[] cartes) {
		super();
		this.cartes = cartes;
		nbCartes = cartes.length;
	} 
	public boolean estVide() {
		return nbCartes == 0;
	}
	public void ajouterCarte(Carte carte) {
		if (nbCartes >= cartes.length) {
			throw new IndexOutOfBoundsException();
		} else {
			cartes[nbCartes] = carte;
			nbCartes ++;
		}
	}
	@Override
	public Iterator<Carte> iterator() {
		return new Iterateur();
	}
	private class Iterateur implements Iterator<Carte>{
		int indiceIterateur = 0;
		boolean nextEffectue = false;
		int nbOperations = nbOperationsRef;
		
		private Iterateur() {
			super();
		}
		@Override
		public boolean hasNext() {
			return indiceIterateur < nbCartes;
		}
		@Override
		public Carte next() {
			if (! validerConcurrence()) {
				throw new ConcurrentModificationException();
			}
			if (hasNext()) {
				Carte carte = cartes[indiceIterateur];
				indiceIterateur++;
				nextEffectue = true;
				return carte;
			} else {
				throw new NoSuchElementException();
			}
		}
		private boolean validerConcurrence() {
			return nbOperations == nbOperationsRef;
		}
		public void remove () {
			if (! nextEffectue || nbCartes < 1) {
				throw new IllegalStateException();
			} else if (! validerConcurrence()) {
				throw new ConcurrentModificationException();
			} else {
				indiceIterateur --;
				for (int i = indiceIterateur ; i < nbCartes-1 ; i++) {
					cartes[i] = cartes[i+1];
				}
				nextEffectue = false;
				nbCartes --;
				nbOperations ++;
				nbOperationsRef ++;
			}
		}
	}
	public Carte piocher() {
		Iterateur it = new Iterateur();
		Carte carte = it.next();
		it.remove();
		return carte;
	}
		
}
