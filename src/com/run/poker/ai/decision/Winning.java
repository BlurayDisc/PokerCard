package com.run.poker.ai.decision;

import com.run.poker.utils.GameUtils;

/**
 * When a bot is winning it would either Call/Check or Raise or All-In.
 * @author RuN
 *
 */
public class Winning extends Decision {

	@Override
	public Decision process() {
		Decision decision;
		int n = GameUtils.random(1, 100);
		if (n < 5) {
			decision = new AllIn();
		} else if (n > 70) {
			decision = new Raise();
		} else {
			decision = new CallCheck();
		}
		return decision;
	}
}