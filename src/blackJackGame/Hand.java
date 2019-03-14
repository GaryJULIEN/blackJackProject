package blackJackGame;

import java.util.LinkedList;
import java.util.List;

public class Hand {

	private static final int VALUE_MAX_TO_WIN = 21;
	private List<Card> cardList;

	// constructeur

	public Hand() {
		super();
		cardList = new LinkedList<>();
	}

	public void ajouterCarte(Card carte) {
		cardList.add(carte);
	}

	public int getPointsHand() {
		int scoreHand = 0;
		for (Card card : cardList) {
			scoreHand += card.getValeur();
		}
		int nbAces = nbAcesInHand();
		if (nbAces > 0 && scoreHand > VALUE_MAX_TO_WIN) {
			while ((scoreHand > VALUE_MAX_TO_WIN) || nbAces == 0) {
				scoreHand -= 10;
				nbAces--;
			}
		}

		return scoreHand;
	}

	public boolean handIsToBig() {
		boolean toMuch = false;
		if (getPointsHand() > VALUE_MAX_TO_WIN) {
			toMuch = true;
		}
		return toMuch;
	}

	public int nbAcesInHand() {
		int nbAces = 0;
		for (Card card : cardList) {
			if (card.getValeur() == 11) {
				nbAces++;
			}
		}
		return nbAces;
	}

	public int nbCardsInHand() {
		int nbCardsInHand = 0;
		for (Card card : cardList) {
			nbCardsInHand++;
		}
		return nbCardsInHand;
	}

	// getters et setters

	public List<Card> getCardList() {
		return cardList;
	}

}