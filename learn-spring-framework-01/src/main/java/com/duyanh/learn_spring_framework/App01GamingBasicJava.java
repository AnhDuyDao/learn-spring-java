package com.duyanh.learn_spring_framework;

import com.duyanh.learn_spring_framework.game.GameRunner;
import com.duyanh.learn_spring_framework.game.MarioGame;
import com.duyanh.learn_spring_framework.game.PacManGame;
import com.duyanh.learn_spring_framework.game.SuperContraGame;

public class App01GamingBasicJava {

	public static void main(String[] args) {
      // var game = new MarioGame();
      // var game = new SuperContraGame();
      // Tight coupling because GameRunner is dependent on superContraGame. If we want to change game, we need to change code in GameRunner
      var game = new PacManGame(); // 1: Object creation
      var gameRunner = new GameRunner(game); 
      // 2: Object Creation + Wiring or injecting the dependency
      // game is a dependency of GameRunner
      gameRunner.run();
	}

}
