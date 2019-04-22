package fightinggame;

import javax.swing.ImageIcon;

public class Loki extends Character{
	
	public Loki() {
		super("LOKI", new ImageIcon("res/Loki.png"), new ImageIcon("res/Loki Forward.png"), new ImageIcon("res/Loki Forward.png"), 
				new ImageIcon("res/Loki Basic.png"), new ImageIcon("res/Loki Block.png"), new ImageIcon("res/Loki Lose.png"),
				9000, 9000, 100, 3, 3, 1, 1, 8, 1, 0);
	}
	
	@Override
	public void skill() {
		skillName = "Backstab";
		skillDamage = 500;
	}
}
