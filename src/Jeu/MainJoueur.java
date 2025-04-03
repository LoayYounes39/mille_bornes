package Jeu;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import cartes.Carte;

public class MainJoueur implements Iterable<Carte>{
	List <Carte> listeCartes = new LinkedList<>();
	
	public MainJoueur() {
		
	}
	public void jouer(Carte carte) {
		assert(listeCartes.contains(carte));
		listeCartes.remove(carte);
	}
	public void prendre(Carte carte) {
		listeCartes.add(carte);
	}
	@Override
	public String toString() {
		ListIterator<Carte> it = listeCartes.listIterator();
		StringBuilder sb = new StringBuilder();
		while (it.hasNext()) {
			sb.append(it.next().toString()).append("\n");
		}
		return sb.toString();
	}
	@Override
	public Iterator<Carte> iterator() {
		return listeCartes.iterator();
	}
	
}
