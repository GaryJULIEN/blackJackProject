package blackJackGame;

import java.util.Scanner;

public class Launcher {

	private static final int VALUE_TO_HIT_A_CARD = 1;
	private static final int VALUE_TO_STOP_HIT = 0;

	public static void main(String[] args) {
		// 0-Initialiser le scanner
		Scanner scanner = new Scanner(System.in);
		// 1-Initialiser la partie (un deck, une main joueur vide et une main bank vide)
		GameService nouvellePartie = new GameService();
		// 2-Distribuer les cartes aux joueurs
		nouvellePartie.initializeFirstHands();
		// 3-Afficher main bank
		Card firstCard = nouvellePartie.getMainBank().getCardList().get(0);
		System.out.println(
				"La banque a cette carte dans sa main : " + firstCard.getFace() + " de " + firstCard.getCouleur());
		// 4-Afficher main joueur
		nouvellePartie.getMainJoueur().printPlayerHand();

		// 5-Faire tirer joueur
		boolean playerWantsToPlay = doesPlayerWantToPlay(scanner);
		while (playerWantsToPlay) {
			playerHitACArd(nouvellePartie);
			int playerHandValue = nouvellePartie.getMainJoueur().getPointsHand();
			if (playerHandValue > nouvellePartie.getMaxScoreToWin()) {
				System.out.println("Vous avez dépassé la limite de points. Vous perdez ...");
				playerWantsToPlay = false;
			} else {
				playerWantsToPlay = doesPlayerWantToPlay(scanner);
			}

		}
		// 6-faire tirer bank
		nouvellePartie.bankToPlay();
		nouvellePartie.getMainBank().printBankHand();
		// 7-Determiner gagnant
		Hand winnerHand = nouvellePartie.getWinner();
		displayWinner(winnerHand, nouvellePartie);

	}

	public static void playerHitACArd(GameService partie) {
		partie.playerHitACard();
	}

	public static void alertWrongNextInt() {
		System.out.println("Merci de saisir 1 ou 0");
		System.out.println("Voulez vous piocher une carte ?\n   OUI : 1\n   NON : 0");

	}

	public static boolean doesPlayerWantToPlay(Scanner scanner) {
		System.out.println("Voulez vous piocher une carte ?\n   OUI : 1\n   NON : 0");
		int playerChoice = scanner.nextInt();
		boolean booleanChoice = false;
		while (playerChoice != VALUE_TO_HIT_A_CARD && playerChoice != VALUE_TO_STOP_HIT) {
			alertWrongNextInt();
			playerChoice = scanner.nextInt();
		}
		if (playerChoice == VALUE_TO_HIT_A_CARD) {
			booleanChoice = true;
		}

		return booleanChoice;
	}

	public static void displayWinner(Hand winnerHand, GameService partie) {
		if (winnerHand.equals(partie.getMainJoueur())) {
			System.out.println("Vous remportez la partie");
		} else {
			System.out.println("La banque remporte la partie");
		}
	}

}
