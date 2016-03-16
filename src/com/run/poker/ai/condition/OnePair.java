package com.run.poker.ai.condition;

import java.util.Collections;
import java.util.List;

import com.run.poker.card.Card;
import com.run.poker.card.Rank;

public class OnePair extends Condition {
	
	public OnePair() {
		this.rank = Rank.OnePair;
	}

	@Override
	public boolean check(List<Card> cards) {
		for (Card card: cards) {
			int frequency = Collections.frequency(cards, card);
			if (frequency == TWO_OF_A_KIND_CONDITION) {
				tempList.add(card);
			}
		}
		return tempList.size() == TWO_OF_A_KIND_CONDITION;
	}

	@Override
	public void finalise(List<Card> cards) {
		for (Card card: cards) {
			//Fill in the last 3 missing cards. 
			if (tempList.size() == 5) {
				break;
			}
			if (!tempList.contains(card)) {
				tempList.add(card);
			}
		}
	}
}