package blackJackGame;

import java.util.List;

public class GameService {

	private static final int VALUE_TO_STAY_FOR_BANK = 17;
	private static final int MAX_SCORE_TO_WIN = 21;

	// constructeur
	public GameService() {
		super();
		deck = new Deck();
		mainBank = new Hand();
		mainJoueur = new Hand();
	}

	// attributs
	private Deck deck;
	private Hand mainJoueur;
	private Hand mainBank;

	// methodes
	public void initializeFirstHands() {
		// main du joueur
		for (int i = 0; i < 2; i++) {
			Card cartePiochee = deck.removeCard();
			mainJoueur.ajouterCarte(cartePiochee);
		}
		// main de la bank
		for (int i = 0; i < 2; i++) {
			Card cartePiochee = deck.removeCard();
			mainBank.ajouterCarte(cartePiochee);
		}
	}

	public void playerHitACard() {
		Card cartePiochee = deck.removeCard();
		mainJoueur.ajouterCarte(cartePiochee);
		mainJoueur.printPlayerHand();

	}

	public void bankToPlay() {
		int bankHandValue = mainBank.getPointsHand();
		while (bankHandValue < VALUE_TO_STAY_FOR_BANK) {
			Card cartePiochee = deck.removeCard();
			mainBank.ajouterCarte(cartePiochee);
			bankHandValue = mainBank.getPointsHand();
		}
	}

	public boolean playerGotBlackJack() {

		int nbCardsInPlayerHand = getnbCardsInHand(mainJoueur);
		int playerHandValue = mainJoueur.getPointsHand();
		boolean playerGotBJ = false;
		if (nbCardsInPlayerHand == 2 && playerHandValue == 21) {
			playerGotBJ = true;
		}
		return playerGotBJ;
	}

	public int getnbCardsInHand(Hand main) {
		int nbCardsInPlayerHand = 0;
		List<Card> playerCardsList = main.getCardList();
		for (Card card : playerCardsList) {
			nbCardsInPlayerHand++;
		}
		return nbCardsInPlayerHand;
	}

	public Hand getWinner() {
		Hand winnerHand = null;
		// si aucun joueur ne depasse 21
		if (mainBank.getPointsHand() <= MAX_SCORE_TO_WIN && mainJoueur.getPointsHand() <= MAX_SCORE_TO_WIN) {
			// si la banque est inferieure
			if (mainBank.getPointsHand() < mainJoueur.getPointsHand()) {
				winnerHand = mainJoueur;
				// si la banque est superieure
			} else if (mainBank.getPointsHand() > mainJoueur.getPointsHand()) {
				winnerHand = mainBank;
			}
			// si egalité
			else if (mainBank.getPointsHand() == mainJoueur.getPointsHand()) {
				winnerHand = null;
			} else if (playerGotBlackJack()) {
				winnerHand = mainJoueur;
			}

		}
		// si la banque depasse 21
		else if (mainBank.getPointsHand() > MAX_SCORE_TO_WIN) {
			// si le joueur n'a pas depassé 21
			if (mainJoueur.getPointsHand() <= MAX_SCORE_TO_WIN) {
				winnerHand = mainJoueur;
			}
			// si le joueur dépasse 21
			else {
				winnerHand = mainBank;
			}

		}
		// si le joueur depasse 21
		else if (mainJoueur.getPointsHand() > MAX_SCORE_TO_WIN) {
			winnerHand = mainBank;
		}

		return winnerHand;
	}

	// getters et setters
	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public Hand getMainJoueur() {
		return mainJoueur;
	}

	public void setMainJoueur(Hand mainJoueur) {
		this.mainJoueur = mainJoueur;
	}

	public Hand getMainBank() {
		return mainBank;
	}

	public void setMainBank(Hand mainBank) {
		this.mainBank = mainBank;
	}

	public int getValueToStayForBank() {
		return VALUE_TO_STAY_FOR_BANK;
	}

	public int getMaxScoreToWin() {
		return MAX_SCORE_TO_WIN;
	}

}
