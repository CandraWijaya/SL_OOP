package fightinggame;

import javax.swing.JFrame;

public class Main {
	
	public static JFrame frame;
	
	public Main() {
		frame = new JFrame("Fight for the Throne");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		frame.add(new MainMenuPanel());
		
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new Main();
	}

}
