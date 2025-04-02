package cartes;

public enum Type {
	FEU("Feu Rouge","Feu Vert","Vehicule Prioritaire"), ESSENCE("Panne D'Essence","Bidon d'Essence","Citerne D'Essence"), 
	CREVAISON("Crevaison","Roue De Secours","Increvable"), ACCIDENT("Accident","Reparations","As Du Volant");
	private final String nomAttaque;
	private final String nomParade;
	private final String nomBotte;
	private Type(String nomAttaque, String nomParade, String nomBotte) {
		this.nomAttaque = nomAttaque;
		this.nomParade = nomParade;
		this.nomBotte = nomBotte;
	}
	public String getNomAttaque() {
		return nomAttaque;
	}
	public String getNomParade() {
		return nomParade;
	}
	public String getNomBotte() {
		return nomBotte;
	}
}
