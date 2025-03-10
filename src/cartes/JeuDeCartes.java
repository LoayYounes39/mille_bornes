package cartes;

public class JeuDeCartes {
	private static final int NOMBRE_CARTES = 106;
	private Configuration typesDeCartes[] = {new Configuration(new Borne(25), 10), 
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
		super();
	}
	private static class Configuration {
		private Carte carte;
		private int nbExemplaires;
		
		private Configuration(Carte carte, int nbExemplaires) {
			super();
			this.carte = carte;
			this.nbExemplaires = nbExemplaires;
		}
		public Carte getCarte() {
			return carte;
		}
		public int getNbExemplaires() {
			return nbExemplaires;
		}
		
	}
	public String affichageJeuDeCartes () {
		StringBuilder sb = new StringBuilder();
		for (Configuration configuration : typesDeCartes) {
			sb.append(configuration.getNbExemplaires() + " " + configuration.getCarte().toString() + "\n");
		}
		return sb.toString();
	}
	public Carte[] donnerCartes() {
		Carte[] cartes = new Carte[NOMBRE_CARTES];
		int i = 0;
		for (Configuration configuration : typesDeCartes) {
			for (int j = 0; j < configuration.getNbExemplaires(); j++) {
				cartes[i] = configuration.getCarte();
				i++;
			}
		}
		return cartes;
	}
	public boolean checkCount() {
		Carte[] cartes = donnerCartes();
		for (Configuration configuration : typesDeCartes) {
			int nombreCartes = 0;
			for (Carte carte : cartes) {
				if (carte.getClass() == configuration.getCarte().getClass()) {
					nombreCartes ++;
				}
			}
			if (nombreCartes > configuration.getNbExemplaires()) {
				return false;
			}
		}
		// Solution plus efficace : Tableau de configurations cr�� avec des configurations initialis�s 
		// tous � 0 , remplir au fur et � mesure 
		// Puis check si ce tableau est �quivalent au tableau de Configurations.
		
		return true;
	}
	

}
