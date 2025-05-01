package tests_fonctionnels;

import Jeu.Cartes;
import Jeu.Joueur;
import Jeu.ZoneDeJeu;
import cartes.Attaque;
import cartes.Borne;
import cartes.Botte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Parade;
import cartes.Type;

public class TestZoneDeJeu {
	public static void main(String[] args) {
		Joueur joueur1 = new Joueur("X", new ZoneDeJeu());
		joueur1.deposer(new Borne(25));
		System.out.println("Déposer carte 25 km.");
		joueur1.deposer(new Borne(50));
		System.out.println("Déposer carte 50 km.");
		joueur1.deposer(new Borne(75));
		System.out.println("Déposer carte 75 km.");
		System.out.println("Total des bornes " + joueur1.donnerKmParcourus());
		ZoneDeJeu zone = joueur1.getZone();
		joueur1.deposer(new FinLimite());
		System.out.println("Limite: " + zone.donnerLimitationVitesse());
		joueur1.deposer(new DebutLimite());
		System.out.println("Limite: " + zone.donnerLimitationVitesse());
		joueur1.deposer(new FinLimite());
		System.out.println("Limite: " + zone.donnerLimitationVitesse());
		boolean depotOK = false;
		ZoneDeJeu zoneDeJeu = new ZoneDeJeu();
		/*// Feu rouge
		System.out.println("Deposer carte Feu rouge");
		depotOK = zoneDeJeu.estDepotAutorise(Cartes.FEU_ROUGE);
		System.out.println("dépôt ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(Cartes.FEU_ROUGE);
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		// RESULTAT ATTENDU POUR LA PARTIE 3 (ne pas décommenter)
//			Deposer carte Feu rouge
//		dépôt ok ? false
//		peut avancer ? false
//		// accident
		System.out.println("Deposer carte attaque - accident");
		depotOK = zoneDeJeu.estDepotAutorise(new Attaque(Type.ACCIDENT));
		System.out.println("dépôt ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new Attaque(Type.ACCIDENT));
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		Deposer carte attaque - accident
//		dépôt ok ? false
//		peut avancer ? false
		// Feu vert
		System.out.println("Deposer carte Feu vert");
		depotOK = zoneDeJeu.estDepotAutorise(Cartes.FEU_VERT);
		System.out.println("dépôt ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(Cartes.FEU_VERT);
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		Deposer carte Feu vert
//		dépôt ok ? true
//		peut avancer ? true		
		// panne d'essence
		System.out.println("Deposer carte attaque - essence");
		depotOK = zoneDeJeu.estDepotAutorise(new Attaque(Type.ESSENCE));
		System.out.println("dépôt ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new Attaque(Type.ESSENCE));
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		Deposer carte attaque - essence
//		dépôt ok ? true
//		peut avancer ? false
		// roue de secours
		System.out.println("Deposer carte parade - roue de secours");
		depotOK = zoneDeJeu.estDepotAutorise(new Parade(Type.CREVAISON));
		if (depotOK) {
			zoneDeJeu.deposer(new Parade(Type.CREVAISON));
		}
		System.out.println("dépôt ok ? " + depotOK);
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		Deposer carte parade - roue de secours
//		dépôt ok ? false
//		peut avancer ? false	
		// bidon d'essence
		System.out.println("Deposer carte parade - essence");
		depotOK = zoneDeJeu.estDepotAutorise(new Parade(Type.ESSENCE));
		if (depotOK) {
			zoneDeJeu.deposer(new Parade(Type.ESSENCE));
		}
		System.out.println("dépôt ok ? " + depotOK);
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		Deposer carte parade - essence
//		dépôt ok ? true
//		peut avancer ? false
		// Feu vert
		System.out.println("Deposer carte Feu vert");
		depotOK = zoneDeJeu.estDepotAutorise(Cartes.FEU_VERT);
		System.out.println("dépôt ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(Cartes.FEU_VERT);
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		Deposer carte Feu vert
//		dépôt ok ? true
//		peut avancer ? true
		// Dépot 100 bornes
		System.out.println("Deposer carte borne - 100");
		depotOK = zoneDeJeu.estDepotAutorise(new Borne(100));
		System.out.println("dépôt ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new Borne(100));
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		Deposer carte borne - 100
//		dépôt ok ? true
//		peut avancer ? true
		// Dépot limitation de vitesse 50 bornes
		System.out.println("Deposer carte limite - 50");
		depotOK = zoneDeJeu.estDepotAutorise(new DebutLimite());
		System.out.println("dépôt ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new DebutLimite());
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		Deposer carte limite - 50
//		dépôt ok ? true
//		peut avancer ? true
		// Dépot 100 bornes
		System.out.println("Deposer carte borne - 100");
		depotOK = zoneDeJeu.estDepotAutorise(new Borne(100));
		System.out.println("dépôt ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new Borne(100));
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		Deposer carte borne - 100
//		dépôt ok ? false
//		peut avancer ? true
		// Depot 25 bornes
		System.out.println("Deposer carte borne - 25");
		depotOK = zoneDeJeu.estDepotAutorise(new Borne(25));
		System.out.println("dépôt ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new Borne(25));
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		Deposer carte borne - 25
//		dépôt ok ? true
//		peut avancer ? true
		// Dépot fin limitation
		System.out.println("Deposer carte fin limite - 50");
		depotOK = zoneDeJeu.estDepotAutorise(new FinLimite());
		System.out.println("dépôt ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new FinLimite());
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		Deposer carte fin limite - 50
//		dépôt ok ? true
//		peut avancer ? true
		// Dépot 100 bornes
		System.out.println("Deposer carte borne - 100");
		depotOK = zoneDeJeu.estDepotAutorise(new Borne(100));
		System.out.println("dépôt ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new Borne(100));
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		Deposer carte borne - 100
//		dépôt ok ? true
//		peut avancer ? true
*/
		// TP4 Partie 1
		depotOK = false;
		// Feu rouge
		System.out.println("Deposer carte Feu rouge");
		depotOK = zoneDeJeu.estDepotAutorise(Cartes.FEU_ROUGE);
		System.out.println("dépôt ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(Cartes.FEU_ROUGE);
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		//RESULTAT ATTENDU POUR LE TP4 Partie 1
//		Deposer carte Feu rouge
//		d�p�t ok ? false
//		peut avancer ? false
//		// Botte Vehicule prioritaire
		System.out.println("Deposer carte Vehicule prioritaire");
		depotOK = zoneDeJeu.estDepotAutorise(Cartes.PRIORITAIRE);
		System.out.println("d�p�t ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(Cartes.PRIORITAIRE);
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		Deposer carte Vehicule prioritaire
//		d�p�t ok ? true
//		peut avancer ? true
		// accident
		System.out.println("Deposer carte attaque - accident");
		depotOK = zoneDeJeu.estDepotAutorise(new Attaque(Type.ACCIDENT));
		System.out.println("d�p�t ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new Attaque(Type.ACCIDENT));
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		Deposer carte attaque - accident
//		d�p�t ok ? true
//		peut avancer ? false
		// botte roue de secours
		System.out.println("Deposer botte - roue de secours");
		depotOK = zoneDeJeu.estDepotAutorise(new Botte(Type.CREVAISON));
		if (depotOK) {
			zoneDeJeu.deposer(new Botte(Type.CREVAISON));
		}
		System.out.println("d�p�t ok ? " + depotOK);
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		Deposer botte - roue de secours
//		d�p�t ok ? true
//		peut avancer ? false
		// botte as du volant
		System.out.println("Deposer carte as du volant");
		depotOK = zoneDeJeu.estDepotAutorise(new Botte(Type.ACCIDENT));
		if (depotOK) {
			zoneDeJeu.deposer(new Botte(Type.ACCIDENT));
		}
		System.out.println("d�p�t ok ? " + depotOK);
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		Deposer carte as du volant
//		d�p�t ok ? true
//		peut avancer ? true
//		// Feu vert
		System.out.println("Deposer carte Feu vert");
		depotOK = zoneDeJeu.estDepotAutorise(Cartes.FEU_VERT);
		System.out.println("d�p�t ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(Cartes.FEU_VERT);
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		Deposer carte Feu vert
//		d�p�t ok ? false
//		peut avancer ? true
//		// D�pot attaque accident
		System.out.println("Deposer carte accident");
		depotOK = zoneDeJeu.estDepotAutorise(new Attaque(Type.ACCIDENT));
		System.out.println("d�p�t ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new Attaque(Type.ACCIDENT));
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
//		Deposer carte accident
//		d�p�t ok ? false
//		peut avancer ? true
//		// D�pot limitation de vitesse 50 bornes
		System.out.println("Deposer carte limite - 50");
		depotOK = zoneDeJeu.estDepotAutorise(new DebutLimite());
		System.out.println("d�p�t ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new DebutLimite());
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
	}
//	Deposer carte limite - 50
//	d�p�t ok ? false
//	peut avancer ? true
}

