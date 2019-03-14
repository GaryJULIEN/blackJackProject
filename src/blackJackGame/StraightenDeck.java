package blackJackGame;

import java.util.LinkedList;
import java.util.List;

public class StraightenDeck {

	List<Card> cardsList;

	public StraightenDeck() {
		super();
		cardsList = new LinkedList<>();
	}

	public List<Card> getCardsList() {
		return cardsList;
	}

	public void setCardsList(List<Card> cardsList) {
		this.cardsList = cardsList;
	}

}
