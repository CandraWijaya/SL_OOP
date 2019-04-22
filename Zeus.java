package fightinggame;

import javax.swing.ImageIcon;

public class Zeus extends Character{
	
	public Zeus() {
		super("ZEUS", new ImageIcon("res/Zeus.png"), new ImageIcon("res/Zeus Forward.png"), new ImageIcon("res/Zeus.png"), 
				new ImageIcon("res/Zeus Basic.png"), new ImageIcon("res/Zeus Block.png"), new ImageIcon("res/Zeus Lose.png"), 10000, 10000, 85, 3, 3, 1, 1, 9, 1, 1);
	}
	
	@Override
	public void skill() {
		skillName = "Heavenly Thunder";
		skillDamage = 1000;
	}
}
