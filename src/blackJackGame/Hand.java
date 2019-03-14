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
		if (scoreHand > 21 && handGotAnAce()) {
			scoreHand -= 10;
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

	public void printPlayerHand() {
		System.out.println("Votre main contient : ");
		for (Card card : cardList) {
			System.out.println("   " + card.getFace() + " de " + card.getCouleur());
		}
		System.out.println("Vous avez " + getPointsHand() + " points en main");
	}

	public void printBankHand() {
		System.out.println("La main de la banque contient : ");
		for (Card card : cardList) {
			System.out.println("   " + card.getFace() + " de " + card.getCouleur());
		}
		System.out.println("La banque a " + getPointsHand() + " points en main");

	}

	public boolean handGotAnAce() {
		boolean gotAnAce = false;
		for (Card card : cardList) {
			if (card.getValeur() == 11) {
				gotAnAce = true;
			}
		}
		return gotAnAce;
	}

	// getters et setters

	public List<Card> getCardList() {
		return cardList;
	}

}