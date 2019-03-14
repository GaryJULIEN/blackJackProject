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
		printPlayerHand(nouvellePartie.getMainJoueur());

		// 5-Faire tirer joueur
		boolean playerWantsToPlay = doesPlayerWantToPlay(scanner);
		while (playerWantsToPlay) {
			nouvellePartie.playerHitACard();
			printPlayerHand(nouvellePartie.getMainJoueur());

			int playerHandValue = nouvellePartie.getMainJoueur().getPointsHand();
			if (playerHandValue > GameService.MAX_SCORE_TO_WIN) {
				System.out.println("Vous avez dépassé la limite de points. Vous perdez ...");
				playerWantsToPlay = false;
			} else {
				playerWantsToPlay = doesPlayerWantToPlay(scanner);
			}

		}
		// 6-faire tirer bank
		nouvellePartie.bankToPlay();
		printBankHand(nouvellePartie.getMainBank());

		// 7-Determiner gagnant
		Player winnerPlayer = nouvellePartie.getWinnerPlayer();
		displayWinner(winnerPlayer);

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

	public static void displayWinner(Player winner) {
		if (winner == Player.Banker) {
			System.out.println("La banque gagne");
		} else if (winner == Player.Human) {
			System.out.println("Vous avez gagné");
		}
	}

	public static void printPlayerHand(Hand playerHand) {
		System.out.println("Votre main contient : ");
		for (Card card : playerHand.getCardList()) {
			System.out.println("   " + card.getFace() + " de " + card.getCouleur());
		}
		System.out.println("Vous avez " + playerHand.getPointsHand() + " points en main");
	}

	public static void printBankHand(Hand bankHand) {
		System.out.println("La main de la banque contient : ");
		for (Card card : bankHand.getCardList()) {
			System.out.println("   " + card.getFace() + " de " + card.getCouleur());
		}
		System.out.println("La banque a " + bankHand.getPointsHand() + " points en main");

	}

}
