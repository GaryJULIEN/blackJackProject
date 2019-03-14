package blackJackGame;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Deck {

	List<Card> cardsList;

	public Deck() {
		super();
		cardsList = new LinkedList<>();

		for (Face face : Face.values()) {
			for (Color couleur : Color.values()) {
				Card carte = new Card(couleur, face);
				cardsList.add(carte);
			}
		}
		Collections.shuffle(cardsList);

	}

	@Deprecated
	public void printDeck() {
		for (Card carte : cardsList) {
			System.out.println(
					carte.getCouleur() + " " + carte.getFace() + " " + carte.getValeur() + "\n****************\n");
		}
	}

	@Override
	public String toString() {
		for (Card carte : cardsList) {
			System.out.println(
					carte.getCouleur() + " " + carte.getFace() + " " + carte.getValeur() + "\n****************\n");
		}
		return super.toString();
	}

	public Card removeCard() {
		Card removedCard = cardsList.remove(0);
		return removedCard;
	}

	// constructeur

	public Deck(List<Card> cardsList) {
		super();
		this.cardsList = cardsList;
	}

	// getters et setters
	public List<Card> getCardsList() {
		return cardsList;
	}

	public void setCardsList(List<Card> cardsList) {
		this.cardsList = cardsList;
	}

}
