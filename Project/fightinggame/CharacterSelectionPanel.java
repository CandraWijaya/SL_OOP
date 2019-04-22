package fightinggame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class CharacterSelectionPanel extends JPanel{
	
	Image background;
	
	CharacterList character = new CharacterList();
	
	private int statusPlayerA = 0;
	private int statusPlayerB = 0;
	
	private Image dbImage;
	private Graphics dbg;
	
	ImageIcon up = new ImageIcon("res/up.png");
	ImageIcon down = new ImageIcon("res/down.png");
	ImageIcon bg = new ImageIcon("res/menu.jpg");
	
	//playerA
	Rectangle p = new Rectangle(1440/5, 300, 220, 220);
//	ImageIcon imgA = new ImageIcon("res/Zeus.png");
	private int wA, hA, wBasicA, hBasicA;
	private int xA = 0, yA = 0;
	private int cntA = 0;
	
	//playerB
	Rectangle q = new Rectangle(1440*3/5+220, 300, 220, 220);
//	ImageIcon imgB = new ImageIcon("res/Loki.png");
	private int wB, hB, wBasicB, hBasicB;
	private int xB = 0, yB = 0;
	private int cntB = 0;

	public void select() { // fungsi untuk masuk ke pilihan
		Main.frame.remove(CharacterSelectionPanel.this);
		JPanel panel = new GamePanel(character.getCharacterList().get(statusPlayerA).name, character.getCharacterList().get(statusPlayerA).img, 
				character.getCharacterList().get(statusPlayerA).imgfw, character.getCharacterList().get(statusPlayerA).imgbw,
				character.getCharacterList().get(statusPlayerA).imgbasic, character.getCharacterList().get(statusPlayerA).imgblock,  
				character.getCharacterList().get(statusPlayerA).imglose, character.getCharacterList().get(statusPlayerA).hp, 
				character.getCharacterList().get(statusPlayerA).saveHp, character.getCharacterList().get(statusPlayerA).basic, 
				wA, hA, wBasicA, hBasicA, character.getCharacterList().get(statusPlayerA).xScale, character.getCharacterList().get(statusPlayerA).yScale,
				character.getCharacterList().get(statusPlayerA).xBasicScale, character.getCharacterList().get(statusPlayerA).yBasicScale,
				character.getCharacterList().get(statusPlayerA).imgNum, character.getCharacterList().get(statusPlayerA).imgBasicNum,
				
				character.getCharacterList().get(statusPlayerB).name, character.getCharacterList().get(statusPlayerB).img, 
				character.getCharacterList().get(statusPlayerB).imgfw, character.getCharacterList().get(statusPlayerB).imgbw,
				character.getCharacterList().get(statusPlayerB).imgbasic, character.getCharacterList().get(statusPlayerB).imgblock,  
				character.getCharacterList().get(statusPlayerB).imglose, character.getCharacterList().get(statusPlayerB).hp, 
				character.getCharacterList().get(statusPlayerB).saveHp, character.getCharacterList().get(statusPlayerB).basic, 
				wB, hB, wBasicB, hBasicB, character.getCharacterList().get(statusPlayerB).xScale, character.getCharacterList().get(statusPlayerB).yScale,
				character.getCharacterList().get(statusPlayerB).xBasicScale, character.getCharacterList().get(statusPlayerB).yBasicScale, 
				character.getCharacterList().get(statusPlayerB).imgNum, character.getCharacterList().get(statusPlayerA).imgBasicNum);
		Main.frame.add(panel);
		panel.requestFocus();
		Main.frame.validate();
	}

	KeyListener keyListener = new KeyListener() {
		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			// select playerA
			case KeyEvent.VK_W:
				statusPlayerA--;
				cntA = xA = yA = 0;
				if (statusPlayerA > character.getCharacterList().size()-1)
					statusPlayerA = 0;
				else if (statusPlayerA < 0)
					statusPlayerA = character.getCharacterList().size()-1;
				break;
			case KeyEvent.VK_S:
				statusPlayerA++;
				cntA = xA = yA = 0;
				if (statusPlayerA > character.getCharacterList().size()-1)
					statusPlayerA = 0;
				else if (statusPlayerA < 0)
					statusPlayerA = character.getCharacterList().size()-1;
				break;
				
			// select playerB 
			case KeyEvent.VK_I:
				statusPlayerB--;
				cntB = xB = yB = 0;
				if (statusPlayerB > character.getCharacterList().size()-1)
					statusPlayerB = 0;
				else if (statusPlayerB < 0)
					statusPlayerB = 1;
				break;
			case KeyEvent.VK_K:
				statusPlayerB++;
				cntB = xB = yB = 0;
				if (statusPlayerB > character.getCharacterList().size()-1)
					statusPlayerB = 0;
				else if (statusPlayerB < 0)
					statusPlayerB = 1;
				break;

			case KeyEvent.VK_ENTER:
				select();
				break;
			}
		}
	};
	
	Thread th = new Thread(() -> {
		while (true) {
			
			wA = character.getCharacterList().get(statusPlayerA).img.getIconWidth() / character.getCharacterList().get(statusPlayerA).xScale;
			hA = character.getCharacterList().get(statusPlayerA).img.getIconHeight() / character.getCharacterList().get(statusPlayerA).yScale;
			wBasicA = character.getCharacterList().get(statusPlayerA).imgbasic.getIconWidth() / character.getCharacterList().get(statusPlayerA).xBasicScale;
			hBasicA = character.getCharacterList().get(statusPlayerA).imgbasic.getIconHeight() / character.getCharacterList().get(statusPlayerA).yBasicScale;
			
			wB = character.getCharacterList().get(statusPlayerB).img.getIconWidth() / character.getCharacterList().get(statusPlayerB).xScale;
			hB = character.getCharacterList().get(statusPlayerB).img.getIconHeight() / character.getCharacterList().get(statusPlayerB).yScale;
			wBasicB = character.getCharacterList().get(statusPlayerB).imgbasic.getIconWidth() / character.getCharacterList().get(statusPlayerB).xBasicScale;
			hBasicB = character.getCharacterList().get(statusPlayerB).imgbasic.getIconHeight() / character.getCharacterList().get(statusPlayerB).yBasicScale;
			
			// playerA
			xA++;
			xA %= character.getCharacterList().get(statusPlayerA).xScale;
			if(xA == 0) {
				yA++;
				yA %= character.getCharacterList().get(statusPlayerA).yScale;
			}
			cntA++;
			if(cntA == character.getCharacterList().get(statusPlayerA).imgNum)
				cntA = xA = yA = 0;
			
			// playerB
			xB++;
			xB %= character.getCharacterList().get(statusPlayerB).xScale;
			if(xB == 0) {
				yB++;
				yB %= character.getCharacterList().get(statusPlayerB).yScale;
			}
			cntB++;
			if(cntB == character.getCharacterList().get(statusPlayerB).imgNum)
				cntB = xB = yB = 0;
			
			repaint();
			
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
//			System.out.println(character.getCharacterList().get(statusPlayerB).imgNum);
//			System.out.println(cntA);
		}
	});

	public CharacterSelectionPanel() {
		
		setFont(new Font("Eight Bit Dragon", Font.BOLD, 30));
		addKeyListener(keyListener);
		th.start();
		setVisible(true);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.clearRect(0, 0, 2000, 2000);
		g.setColor(Color.BLACK);
		g.drawImage(bg.getImage(), 0, 0, 1440, 720, null);
		g.drawString("CHOOSE YOUR CHARACTER", 460, 100);
		
		//playerA
		g.drawString("Player  1", p.x+50, p.y-50);
		g.drawImage(up.getImage(), p.x+85, p.y-25, 50, 50, null);
		g.drawImage(down.getImage(), p.x+85, p.y+200, 50, 50, null);
		
		//playerB
		g.drawString("Player  2", q.x-180, q.y-50);
		g.drawImage(up.getImage(), q.x-135, q.y-25, 50, 50, null);
		g.drawImage(down.getImage(), q.x-135, q.y+200, 50, 50, null);
		
		g.drawImage(character.getCharacterList().get(statusPlayerA).img.getImage(), p.x, p.y, p.x+220, p.y+220, xA*wA, yA*hA, (xA*wA)+wA, (yA*hA)+hA, null);
		g.drawImage(character.getCharacterList().get(statusPlayerB).img.getImage(), q.x, q.y, q.x-220, q.y+220, xB*wB, yB*hB, (xB*wB)+wB, (yB*hB)+hB, null);

	}

	public int getStatusPlayerA() {
		return statusPlayerA;
	}

	public int getStatusPlayerB() {
		return statusPlayerB;
	}
	
}
