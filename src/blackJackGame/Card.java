package blackJackGame;

public class Card {
	// Attributs
	private Color couleur;
	private Face face;
	private int valeur;

	// Constructeurs
	public Card(Color couleur, Face face, int valeur) {
		super();
		this.couleur = couleur;
		this.face = face;
		this.valeur = valeur;
	}

	// Getters setters
	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	public Face getFace() {
		return face;
	}

	public void setFace(Face face) {
		this.face = face;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

}
