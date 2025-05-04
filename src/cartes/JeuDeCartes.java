package cartes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;


public class JeuDeCartes {
	private static final int NOMBRE_CARTES = 106;
	private Map<Carte, Integer> typesDeCartes = new HashMap<>();
	
	private Configuration ensTypesDeCartes[] = {new Configuration(new Borne(25), 10), 
			new Configuration(new Borne(50), 10), new Configuration(new Borne(75), 10), 
			new Configuration(new Borne(100), 12), new Configuration(new Borne(200), 4),
			new Configuration(new Parade(Type.FEU), 14), new Configuration(new FinLimite(),6 ),
			new Configuration(new Parade(Type.ESSENCE), 6), new Configuration(new Parade(Type.CREVAISON), 6), 
			new Configuration(new Parade(Type.ACCIDENT), 6), new Configuration(new Attaque(Type.FEU), 5), 
			new Configuration(new DebutLimite(), 4), new Configuration(new Attaque(Type.ESSENCE), 3),
			new Configuration(new Attaque(Type.CREVAISON), 3), new Configuration(new Attaque(Type.ACCIDENT), 3), 
			new Configuration(new Botte(Type.FEU), 1), new Configuration(new Botte(Type.ACCIDENT), 1), 
			new Configuration(new Botte(Type.ESSENCE), 1), new Configuration(new Botte(Type.CREVAISON), 1)} ;
	
	public JeuDeCartes() {
		for (Configuration conf : ensTypesDeCartes) {
			typesDeCartes.put(conf.carte, conf.nbExemplaires);
		}
	}
	
	private static class Configuration {
		private Carte carte;
		private int nbExemplaires;
		private Configuration(Carte carte, int nbExemplaires) {
			super();
			this.carte = carte;
			this.nbExemplaires = nbExemplaires;
		}
	}
		
	
	public String affichageJeuDeCartes () {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Carte, Integer> entry : typesDeCartes.entrySet()) {
			sb.append(entry.getValue() + " " + entry.getKey() + "\n");
		}
		return sb.toString();
	}
	
	public Carte[] donnerCartes() {
		Carte[] cartes = new Carte[NOMBRE_CARTES];
		int i = 0;
		for (Map.Entry<Carte, Integer> entry : typesDeCartes.entrySet()) {
			for (int j = 0; j < entry.getValue(); j++) {
				cartes[i] = entry.getKey();
				i++;
			}
			
		}
		return cartes;
	}
	public boolean checkCount() {
		List<Carte> listeCartes = Arrays.asList(donnerCartes());
		ListIterator<Carte> listeIt = listeCartes.listIterator();
		Map<Carte, Integer> copieTypesCartes = new HashMap<>(typesDeCartes);
		while (listeIt.hasNext()) {	
			Carte exemplaire = listeIt.next();
			if (! copieTypesCartes.containsKey(exemplaire)) {
				return false;
			}
			int nbExemplairesConfig = copieTypesCartes.get(exemplaire);
			copieTypesCartes.remove(exemplaire);
			for (int nb = 2 ; nb <= nbExemplairesConfig; nb++) {
				if (!listeIt.hasNext() || !listeIt.next().equals(exemplaire)) {
					return false;
				}
			}
		}
		if (! copieTypesCartes.isEmpty()) {
			return false;
		}
		return true;
		// Solution plus efficace : Tableau de configurations 
		// cree avec des configurations initialises 
	}
	

}
