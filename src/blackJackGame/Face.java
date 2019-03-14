package blackJackGame;

public enum Face {
	As(11), Deux(2), Trois(3), Quatre(4), Cinq(5), Six(6), Sept(7), Huit(8), Neuf(9), Dix(10), Valet(10), Dame(10),
	Roi(10);

	private int valeur;

	Face(int valeur) {
		this.valeur = valeur;
	}

	public int getValeur() {
		return valeur;
	}

}