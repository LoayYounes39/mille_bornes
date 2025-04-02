package tests_fonctionnels;

import java.util.ArrayList;
import java.util.LinkedList;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class TestGestionCartes {
	public static void main(String[] args) {
		JeuDeCartes jc = new JeuDeCartes();
		// Change to LinkedList
		LinkedList<Carte> listeCarteNonMelangee = new LinkedList<>();
		for (Carte carte : jc.donnerCartes()) {
			listeCarteNonMelangee.add(carte);
		}
		ArrayList<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);
		System.out.println(listeCartes);
		listeCartes = (ArrayList<Carte>)GestionCartes.melanger(listeCartes);
		System.out.println(listeCartes);
		System.out.println("liste mélangée sans erreur ? "
		+ GestionCartes.verifierMelange(listeCarteNonMelangee, listeCartes));
		listeCartes = (ArrayList<Carte>) GestionCartes.rassemblerV2(listeCartes);
		System.out.println(listeCartes);
		System.out.println("liste rassemblée sans erreur ? "
		+ GestionCartes.verifierRassemblement(listeCartes));
	}
}
		
