package tests_fonctionnels;

import cartes.Attaque;
import cartes.Borne;
import cartes.Carte;
import cartes.Parade;
import cartes.Type;

public class TestEquals {
	public static void main(String[] args) {
		Borne carte25_1 = new Borne(25);
		Borne carte25_2 = new Borne(25); 
		Attaque feuRouge_1 = new Attaque(Type.FEU);
		Attaque feuRouge_2 = new Attaque(Type.FEU);
		Parade feuVert_1 = new Parade(Type.FEU);
		System.out.println("Deux cartes de 25km sont identiques ? " + carte25_1.equals(carte25_2));
		System.out.println("Deux cartes feu rouge sont identiques ? " + feuRouge_1.equals(feuRouge_2));
		System.out.println("La carte feu rouge est identique à la carte feu Vert ?" + feuRouge_1.equals(feuVert_1));
	}
	
}
