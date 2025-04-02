package utils;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import cartes.Carte;


public class GestionCartes <E extends Carte>{
	public static <E> E extraire (List<E> liste) {
		Random random = new Random();
		int indiceAleatoire = random.nextInt(liste.size());
		E element = liste.get(indiceAleatoire); 
		liste.remove(indiceAleatoire);
		return element;
	}
	public static <E> E extraireV2 (List<E> liste) {
		Random random = new Random();
		int indiceAleatoire = random.nextInt(liste.size());
		ListIterator <E> it = liste.listIterator();
		for ( ; it.hasNext() && indiceAleatoire > 0; indiceAleatoire --) {
			it.next();
		}
		E element = it.next();
		it.remove();
		return element;
	}
	public static <E> List<E> melanger (List<E> liste){
		List<E> nouvListe = new ArrayList<E>();
		while (! liste.isEmpty()) {
			nouvListe.add(extraireV2(liste));
		}
		return nouvListe;
	}
	// La méthode statique de test
	public static <E> boolean verifierMelange(List<E> listeNonMelangee, List<E> listeMelangee) {
		ListIterator<E> it = listeNonMelangee.listIterator();
		while (it.hasNext()) {
			E elemCour = it.next(); 
			if (Collections.frequency(listeMelangee, elemCour) != Collections.frequency(listeNonMelangee, elemCour)) {
				return false;
			}
			E elemIdentique = elemCour;
			while (it.hasNext() && elemIdentique == elemCour) {
				elemIdentique = it.next();
			}
		}
		return true;
	}
	public static <E> List<E> rassembler(List<E> listeRandom){
		ArrayList<E> listeRangee = new ArrayList<E>();
		ListIterator<E> it = (ListIterator<E>) listeRandom.iterator();
		while (it.hasNext()) {
			E elementCour = it.next();
			if (! listeRangee.contains(elementCour)) {
				ListIterator<E> it2 = (ListIterator<E>) listeRandom.iterator(); 
				while (it2.hasNext()) {
					if (it2.next().equals(elementCour)) {
						listeRangee.add(elementCour);
					}
				}
			}
		}
		return listeRangee;
	}
	public static <E> boolean verifierRassemblement(List<E> liste) {
		ListIterator<E> it = (ListIterator<E>) liste.listIterator();
		while (it.hasNext()) {
			E elementCour = it.next();
			int nextIndex = it.nextIndex();
			ListIterator<E> it2 = (ListIterator<E>) liste.listIterator(nextIndex);
			while (it2.hasNext()) {
				E elementComp = it.next();
				if (elementComp.equals(elementCour) && it2.nextIndex() != nextIndex + 1) {
					return false;
				} else if (elementComp.equals(elementCour)) {
					nextIndex++;
				}
			}
		}
		return true;
	}

}
