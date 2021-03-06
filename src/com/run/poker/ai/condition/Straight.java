package com.run.poker.ai.condition;

import java.util.List;

import com.run.poker.entity.card.Card;
import com.run.poker.entity.card.Rank;

/**
 * <p> Similar to flush comparison, instead of using the suit 
 * this algorithm uses the card value.
 * <p> The constant value is the value between each consecutive 
 * poker card, in this case it's 1.
 * @return
 */
public class Straight extends Condition {
	
	/**
	 * Place holder for the first card of the straight.
	 */
	private Card card;
	
	public Straight() {
		this.rank = Rank.Straight;
	}

	@Override
	public boolean check(List<Card> cards) {
		int consecutives = 0;
		Card previous = null;
		for (Card current: cards) {
			if (previous != null) {
				consecutives = previous.value == current.value + 1 ? 
							   consecutives + 1 : 0;
				if (consecutives == 1) {
					card = previous;
				}
			}
			previous = current;
		}
		return consecutives >= STRAIGHT_CONDITION;
	}

	@Override
	public void finalise(List<Card> cards) {
		int index = cards.indexOf(card);
		for (int i = index; i < index + 5; i++) {
			tempList.add(cards.get(i));
		}
	}
}