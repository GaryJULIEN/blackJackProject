package blackJackGame;

import java.util.LinkedList;
import java.util.List;

public class Deck {

	List<Card> cardsList;

	public Deck() {
		super();
		cardsList = new LinkedList<>();

		for (Face face : Face.values()) {
			for (Color couleur : Color.values()) {
				Card carte = new Card(couleur, face, face.getValeur());
				cardsList.add(carte);
			}
		}

	}

	public void printDeck() {
		for (Card carte : cardsList) {
			System.out.println(
					carte.getCouleur() + " " + carte.getFace() + " " + carte.getValeur() + "\n****************\n");
		}
	}

}
