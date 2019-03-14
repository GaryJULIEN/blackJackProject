package blackJackGame;

import java.util.List;

public class GameService {

	private static final int VALUE_TO_STAY_FOR_BANK = 17;
	public static final int MAX_SCORE_TO_WIN = 21;

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

		int nbCardsInPlayerHand = getnbCardsInHand();
		int playerHandValue = mainJoueur.getPointsHand();
		boolean playerGotBJ = false;
		if (nbCardsInPlayerHand == 2 && playerHandValue == 21) {
			playerGotBJ = true;
		}
		return playerGotBJ;
	}

	public int getnbCardsInHand() {
		int nbCardsInPlayerHand = 0;
		List<Card> playerCardsList = mainJoueur.getCardList();
		for (Card card : playerCardsList) {
			nbCardsInPlayerHand++;
		}
		return nbCardsInPlayerHand;
	}

	@Deprecated
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

	public Player getWinnerPlayer() {
		Player winner = null;
		// si aucun joueur ne depasse 21
		if (mainBank.getPointsHand() <= MAX_SCORE_TO_WIN && mainJoueur.getPointsHand() <= MAX_SCORE_TO_WIN) {
			// si la banque est inferieure
			if (mainBank.getPointsHand() < mainJoueur.getPointsHand()) {
				winner = Player.Human;
				// si la banque est superieure
			} else if (mainBank.getPointsHand() > mainJoueur.getPointsHand()) {
				winner = Player.Banker;
			}
			// si egalité
			else if (mainBank.getPointsHand() == mainJoueur.getPointsHand()) {
				winner = null;
			} else if (playerGotBlackJack()) {
				winner = Player.Human;
			}

		}
		// si la banque depasse 21
		else if (mainBank.getPointsHand() > MAX_SCORE_TO_WIN) {
			// si le joueur n'a pas depassé 21
			if (mainJoueur.getPointsHand() <= MAX_SCORE_TO_WIN) {
				winner = Player.Human;
			}
			// si le joueur dépasse 21
			else {
				winner = Player.Banker;
			}

		}
		// si le joueur depasse 21
		else if (mainJoueur.getPointsHand() > MAX_SCORE_TO_WIN) {
			winner = Player.Banker;
		}

		return winner;
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

}
