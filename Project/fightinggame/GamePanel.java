package fightinggame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener{
	
	Timer tm = new Timer(5, this);
	
	private Color color;
	private Color colorLine;
	private Font font;
	
	private Image dbImage;
	private Graphics dbg;
	
	// world
	ImageIcon wall = new ImageIcon("res/Brick_Block.png");
	ImageIcon floor = new ImageIcon("res/floor.png");
	ImageIcon floora0 = new ImageIcon("res/floor_a_0.png");
	ImageIcon floora1 = new ImageIcon("res/floor_a_1.png");
	ImageIcon bg = new ImageIcon("res/bg.png");
	ImageIcon winner = new ImageIcon("res/winner.png");
//	ImageIcon fade = new ImageIcon("res/fade.png");
	
	// playerA
	Rectangle a = new Rectangle(288, 370, 220, 220);
	private String nameA;
	ImageIcon imgA;
	ImageIcon imgfwA;
	ImageIcon imgbwA;
	ImageIcon imgbasicA;
	ImageIcon imgblockA;
	ImageIcon imgloseA;
	private int hpA;
	private int saveHpA;
	private int hpBarA = 300;
	private Color colorA;
	private Integer basicA;
	private int xA = 0, yA = 0, cntA = 0;
	private int wA, hA, wBasicA, hBasicA;
	private int velXA = 0, velYA = 0;
	private boolean isRightA = false;
	private boolean isLeftA = false;
	private boolean isBasicA = false;
	private boolean isBlockA = false;
	private int detectA = 0;
	private int perHpA;
	private int xScaleA, yScaleA, xBasicScaleA, yBasicScaleA;
	private int charIdxA;
	private int pointXA = a.x, pointYA = 0;
	private int imgNumA, imgBasicNumA;
	private int manaA;
	
	// playerB
	Rectangle b = new Rectangle(1440*3/5+220, 370, 220, 220);
	private String nameB;
	ImageIcon imgB;
	ImageIcon imgfwB;
	ImageIcon imgbwB;
	ImageIcon imgbasicB;
	ImageIcon imgblockB;
	ImageIcon imgloseB;
	private int hpB;
	private int saveHpB;
	private int hpBarB = 300;
	private Color colorB;
	private Integer basicB;
	private int xB = 0, yB = 0, cntB = 0;
	private int wB, hB, wBasicB, hBasicB;
	private int velXB = 0, velYB = 0;
	private boolean isRightB = false;
	private boolean isLeftB = false;
	private boolean isBasicB = false;
	private boolean isBlockB = false;
	private int detectB = 0;
	private int xScaleB, yScaleB, xBasicScaleB, yBasicScaleB;
	private int charIdxB;
	private int pointXB = 1084, pointYB = 0;
	private int imgNumB, imgBasicNumB;
	private int manaB;
	
	KeyListener keyListener = new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyReleased(KeyEvent e) {
			velXA = 0;
			velYA = 0;
			velXB = 0;
			velYB = 0;
//			detectA = 0;
//			detectB = 0;
			
			if(hpA > 0 && hpB > 0) {
				// playerA
				if(e.getKeyCode() == KeyEvent.VK_Q) {
					detectA = 0;
					isBlockA = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_A) {
					isLeftA = false;
		//				isBlockB = false;
					detectA = 0;
				}
				if(isLeftA) {
					velXA = -4;
					velYA = 0;
					isBlockA = false;
					detectA = 1;
				}
				if(e.getKeyCode() == KeyEvent.VK_D) {
					isRightA = false;
		//				isBlockB = false;
					detectA = 0;
				}
				if(isRightA) {
					velXA = 4;
					velYA = 0;
					isBlockA = false;
					detectA = 2;
				}
				if(e.getKeyCode() == KeyEvent.VK_S) {
					isBasicA = false;
					detectA = 0;
				}
				
				// playerB
				if(e.getKeyCode() == KeyEvent.VK_O) {
					detectB = 0;
					isBlockB = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_L) {
					isRightB = false;
		//				isBlockB = false;
					detectB = 0;
				}
				if(isRightB) {
					velXB = 4;
					velYB = 0;
					isBlockB = false;
					detectB = 1;
				}
				if(e.getKeyCode() == KeyEvent.VK_J) {
					isLeftB = false;
		//				isBlockB = false;
					detectB = 0;
				}
				if(isLeftB) {
					velXB = -4;
					velYB = 0;
					isBlockB = false;
					detectB = 2;
				}
				if(e.getKeyCode() == KeyEvent.VK_K) {
					isBasicB = false;
					detectB = 0;
				}
			}
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if(hpA > 0 && hpB > 0) {
				switch(e.getKeyCode()) {
				// playerA
				case KeyEvent.VK_Q:
					isBlockA = true;
					detectA = 4;
					if(pointYA < 370)
						pointYA = 370;
					break;
				case KeyEvent.VK_A:
					velXA = -4;
					velYA = 0;
					detectA = 1;
					isLeftA = true;
					isBlockA = false;
					break;
				case KeyEvent.VK_D:
					if(pointYA < 370)
						velXA = 0;
					else
						velXA = 4;
					velYA = 0;
					detectA = 2;
					isRightA = true;
					isBlockA = false;
					break;
				case KeyEvent.VK_S:
					detectA = 3;
					if(pointXB >= pointXA+110 && pointXB <= pointXA+330 && !isBasicA) {
						if(pointYB < 370) {
//							dmgReceivedB = 0;
						}
						else if(isBlockB) {
							pointXB += 15;
							pointXA += 4;
							hpB -= basicA/4;
						}
						else {
//							dmgReceivedB = basicA;
							hpB -= basicA;
							pointXB += 15;
							pointYB -= 25;
							pointXA += 4;
						}
						isBasicA = true;
					}
					isBlockA = false;
					break;
				
				//playerB
				case KeyEvent.VK_O:
					isBlockB = true;
					detectB = 4;
					if(pointYB < 370)
						pointYB = 370;
					break;
				case KeyEvent.VK_J:
					if(pointYB < 370)
						velXB = 0;
					else
						velXB = -4;
					velYB = 0;
					detectB = 1;
					isLeftB = true;
					isBlockB = false;
					break;
				case KeyEvent.VK_L:
					velXB = 4;
					velYB = 0;
					detectB = 2;
					isRightB = true;
					isBlockB = false;
					break;
				case KeyEvent.VK_K:
					detectB = 3;
					if(pointXA <= pointXB-110 && pointXA >= pointXB-330 && !isBasicB) {
						if(pointYB < 370) {
							
						}
						else if(isBlockA) {
							pointXA -= 15;
							pointXB -= 4;
							hpA -= basicB/4;
						}
						else {
//							dmgReceivedA = basicB;
							hpA -= basicB;
							pointXA -= 15;
							pointYA -= 25;
							pointXB -= 4;
						}
						isBasicB = true;
					}
					isBlockB = false;
					break;
				default:
					break;
				}
			}
			else {
				if(hpA <= 0 && hpB <= 0)
					detectA = detectB = 5;
				else if(hpA <= 0) {
					detectA = 5;
					detectB = 0;
				}
				else if(hpB <= 0) {
					detectB = 5;
					detectA = 0;
				}
				switch (e.getKeyCode()) {
				case KeyEvent.VK_ENTER:
					if((hpA <= 0 && hpB <= 0) || hpA <= 0 || hpB <= 0) {
						Main.frame.remove(GamePanel.this);
						JPanel panel = new MainMenuPanel();
						Main.frame.add(panel);
						panel.requestFocus();
						Main.frame.validate();
					}
					break;
				default:
					break;
				}
			}
			repaint();
		}
	};
	
	Thread th = new Thread(() -> {
		while (true) {
			
			// playerA
			xA++;
			xA%=xScaleA;
			if(xA == 0) {
				yA++;
				yA%=yScaleA;
			}
			cntA++;
			if(cntA >= imgNumA) {
//				if(detectA == 5)
//					detectA = 6;
//				else
					cntA = xA = yA = 0;
			}
			hpBarA = hpA * 300 / saveHpA;
			if(hpBarA > 225)
				colorA = new Color(0, 255, 0);
			else if(hpBarA > 150)
				colorA = new Color(158, 255, 0);
			else if(hpBarA > 75)
				colorA = new Color(255, 219, 1);
			else if(hpBarA >= 0)
				colorA = new Color(255, 74, 1);
			if(hpBarA/3 == 100)
				perHpA = 455;
			else if(hpBarA/3 < 100 && hpBarA/3 >=10)
				perHpA = 465;
			else if(hpBarA/3 <10)
				perHpA = 476;
				
			
			// playerB
			xB++;
			xB%=xScaleB;
			if(xB == 0) {
				yB++;
				yB%=yScaleB;
			}
			cntB++;
			if(cntB >= imgNumB) {
//				if(detectB == 5)
//					detectB = 6;
//				else
					cntB = xB = yB = 0;
			}
			hpBarB = hpB * 300 / saveHpB;
			if(hpBarB > 225)
				colorB = new Color(0, 255, 0);
			else if(hpBarB > 150)
				colorB = new Color(158, 255, 0);
			else if(hpBarB > 75)
				colorB = new Color(255, 219, 1);
			else if(hpBarB >= 0)
				colorB = new Color(255, 74, 1);
			
			colorLine = new Color(255, 0, 0);
			repaint();
			try {
					Thread.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	});
	
	public GamePanel(String nameA, ImageIcon imgA, ImageIcon imgfwA, ImageIcon imgbwA, ImageIcon imgbasicA, ImageIcon imgblockA, ImageIcon imgloseA,  
			int hpA, int saveHpA, int basicA, int wA, int hA, int wBAsicA, int hBasicA, int xScaleA, int yScaleA, 
			int xBasicScaleA, int yBasicScaleA, int imgNumA, int imgBasicNumA,
			
			String nameB, ImageIcon imgB, ImageIcon imgfwB, ImageIcon imgbwB, ImageIcon imgbasicB, ImageIcon imgblockB, ImageIcon imgloseB,  
			int hpB, int saveHpB, int basicB, int wB, int hB, int wBAsicB, int hBasicB, int xScaleB, int yScaleB, 
			int xBasicScaleB, int yBasicScaleB, int imgNumB, int imgBasicNumB) {
		super();
		tm.start();
		// playerA
		this.nameA = nameA;
		this.imgA = imgA;
		this.imgfwA = imgfwA;
		this.imgbwA = imgbwA;
		this.imgbasicA = imgbasicA;
		this.imgblockA = imgblockA;
		this.imgloseA = imgloseA;
		this.hpA = hpA;
		this.saveHpA = saveHpA;
		this.basicA = basicA;
		this.wA = wA;
		this.hA = hA;
		this.wBasicA = wBAsicA;
		this.hBasicA = hBasicA;
		this.xScaleA = xScaleA;
		this.yScaleA = yScaleA;
		this.xBasicScaleA = xBasicScaleA;
		this.yBasicScaleA = yBasicScaleA;
		this.imgNumA = imgNumA;
		this.imgBasicNumA = imgBasicNumA;
		
		// playerB
		this.nameB = nameB;
		this.imgB = imgB;
		this.imgfwB = imgfwB;
		this.imgbwB = imgbwB;
		this.imgbasicB = imgbasicB;
		this.imgblockB = imgblockB;
		this.imgloseB = imgloseB;
		this.hpB = hpB;
		this.saveHpB = saveHpB;
		this.basicB = basicB;
		this.wB = wB;
		this.hB = hB;
		this.wBasicB = wBAsicB;
		this.hBasicB = hBasicB;
		this.xScaleB = xScaleB;
		this.yScaleB = yScaleB;
		this.xBasicScaleB = xBasicScaleB;
		this.yBasicScaleB = yBasicScaleB;
		this.imgNumB = imgNumB;
		this.imgBasicNumB = imgBasicNumB;
		
		// playerA
		wA = imgA.getIconWidth();
		hA = imgA.getIconHeight();
		
		// playeB
		wB = imgB.getIconWidth();
		hB = imgB.getIconHeight();
		
		addKeyListener(keyListener);
		th.start();
		setVisible(true);
	}
	
	public void paintComponent (Graphics g) {
		g.clearRect(0, 0, 1440, 720);
		
		// background
		g.drawImage(bg.getImage(), -1000, 0, 3072, 704, null);
		
		// floor
		g.drawImage(floor.getImage(), -179, 500, 1792, 106, null);
		
		// floora1
		for(int i = 0; i < 1440; i+=320)
			g.drawImage(floora1.getImage(), i, 490, 20, 20, null);
		
		// playerA
		if(detectA == 0)
			g.drawImage(imgA.getImage(), pointXA, pointYA, pointXA+220, pointYA+220, xA*wA, yA*hA, (xA*wA)+wA, (yA*hA)+hA, null);
		else if(detectA == 1)
			g.drawImage(imgbwA.getImage(), pointXA, pointYA, pointXA+220, pointYA+220, xA*wA, yA*hA, (xA*wA)+wA, (yA*hA)+hA, null);
		else if(detectA == 2)
			g.drawImage(imgfwA.getImage(), pointXA, pointYA, pointXA+220, pointYA+220, xA*wA, yA*hA, (xA*wA)+wA, (yA*hA)+hA, null);
		else if(detectA == 3)
			g.drawImage(imgbasicA.getImage(), pointXA, pointYA, pointXA+220, pointYA+220, 0, 0, wBasicA, hBasicA, null);
		else if(detectA == 4)
			g.drawImage(imgblockA.getImage(), pointXA, pointYA, pointXA+220, pointYA+220, 0, 0, wBasicA, hBasicA, null);
		else if(detectA == 5)
			g.drawImage(imgloseA.getImage(), pointXA, pointYA, pointXA+220, pointYA+220, xA*wA, yA*hA, (xA*wA)+wA, (yA*hA)+hA, null);
//		else if(detectA == 6)
//			g.drawImage(fade.getImage(), pointXA, pointYA, pointXA+220, pointYA+220, 0, 0, wBasicA, hBasicA, null);
		
		// playerB
		if(detectB == 0) 
			g.drawImage(imgB.getImage(), pointXB, pointYB, pointXB-220, pointYB+220, xB*wB, yB*hB, (xB*wB)+wB, (yB*hB)+hB, null);
		else if(detectB == 1)
			g.drawImage(imgfwB.getImage(), pointXB, pointYB, pointXB-220, pointYB+220, xB*wB, yB*hB, (xB*wB)+wB, (yB*hB)+hB, null);
		else if(detectB == 2)
			g.drawImage(imgbwB.getImage(), pointXB, pointYB, pointXB-220, pointYB+220, xB*wB, yB*hB, (xB*wB)+wB, (yB*hB)+hB, null);
		else if(detectB == 3)
			g.drawImage(imgbasicB.getImage(), pointXB, pointYB, pointXB-220, pointYB+220, 0, 0, wBasicB, hBasicB, null);
		else if(detectB == 4)
			g.drawImage(imgblockB.getImage(), pointXB, pointYB, pointXB-220, pointYB+220, 0, 0, wBasicB, hBasicB, null);
		else if(detectB == 5)
			g.drawImage(imgloseB.getImage(), pointXB, pointYB, pointXB-220, pointYB+220, xB*wB, yB*hB, (xB*wB)+wB, (yB*hB)+hB, null);
//		else if(detectB == 6)
//			g.drawImage(fade.getImage(), pointXB, pointYB, pointXB-220, pointYB+220, 0, 0, wBasicB, hBasicB, null);
		
		// wall
//		for(int i=0; i<=720; i+=80) {
//			g.drawImage(wall.getImage(), 0, i, 80, 80, null);
//		}
//		for(int i=0; i<=720; i+=80) {
//			g.drawImage(wall.getImage(), 1286, i, 80, 80, null);
//		}
		
		// floora0
		for(int i = 0; i < 1440; i+=400)
			g.drawImage(floora0.getImage(), i, 560, 40, 40, null);
		
		// nameA
		color = new Color(0, 0, 0);
		font = new Font("Eight Bit Dragon", Font.BOLD, 40);
		g.setColor(color);
		g.setFont(font);
		g.drawString(nameA, 197, 75);
		g.drawString(nameA, 201, 75);
		color = new Color(255, 0, 0);
		g.setColor(color);
		g.drawString(nameA, 198, 75);
		
		// nameB
		color = new Color(0, 0, 0);
		font = new Font("Eight Bit Dragon", Font.BOLD, 40);
		g.setColor(color);
		g.setFont(font);
		g.drawString(nameB, 860, 75);
		g.drawString(nameB, 856, 75);
		color = new Color(255, 0, 0);
		g.setColor(color);
		g.drawString(nameB, 859, 75);
		
		// hp barA
		g.setColor(Color.DARK_GRAY);
		g.fillRect(200, 80, 301, 26);
		g.setColor(colorA);
		g.fillRect(200+300-hpBarA, 80, hpBarA+1, 26);
		g.setColor(colorLine);
		g.drawRect(199, 79, 302, 27);
		g.drawRect(198, 78, 304, 29);
		g.drawRect(197, 77, 306, 31);
		
		font = new Font("Eight Bit Dragon", Font.BOLD, 14);
		color = new Color(0, 0, 0);
		g.setColor(color);
		g.setFont(font);
		g.drawString(hpBarA/3+"%", perHpA-2, 100);
		g.drawString(hpBarA/3+"%", perHpA+2, 100);
		g.drawString(hpBarA/3+"%", perHpA, 102);
		g.drawString(hpBarA/3+"%", perHpA, 98);
		color = new Color(255, 255, 255);
		g.setColor(color);
		g.drawString(hpBarA/3+"%", perHpA, 100);
		
		// hp barB
		g.setColor(Color.DARK_GRAY);
		g.fillRect(859, 80, 301, 26);
		g.setColor(colorB);
		g.fillRect(859, 80, hpBarB+1, 26);
		g.setColor(colorLine);
		g.drawRect(858, 79, 302, 27);
		g.drawRect(857, 78, 304, 29);
		g.drawRect(856, 77, 306, 31);
		
		font = new Font("Eight Bit Dragon", Font.BOLD, 14);
		color = new Color(0, 0, 0);
		g.setColor(color);
		g.setFont(font);
		g.drawString(hpBarB/3+"%", 867, 100);
		g.drawString(hpBarB/3+"%", 871, 100);
		g.drawString(hpBarB/3+"%", 869, 102);
		g.drawString(hpBarB/3+"%", 869, 98);
		color = new Color(255, 255, 255);
		g.setColor(color);
		g.drawString(hpBarB/3+"%", 869, 100);
		
		// win
		font = new Font("Eight Bit Dragon", Font.BOLD, 170);
		color = new Color(0, 0, 0);
		g.setColor(color);
		g.setFont(font);
		if(hpA <= 0 && hpB <= 0) {
			detectA = detectB = 5;
			g.drawString("DRAW", 445, 400);
		}
		else if(hpA <= 0) {
			if(cntA < imgNumA)
				detectA = 5;
			else if(cntA == imgNumA-1)
				detectA = 6;
			g.drawString("WINNER P2", 190, 400);
			
		}
		else if(hpB <= 0) {
			if(cntB < imgNumB)
				detectB = 5;
			else if(cntA == imgNumB-1)
				detectB = 6;
			g.drawString("WINNER P1", 190, 400);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// playerA
		if(pointXA < 0) {
			velXA = 0;
			pointXA = 0;
		}
		if(pointXB-220 < pointXA+73) {
			velXB = 0;
			pointXB = pointXA+220+73;
		}
		if(pointYA < 370) {
			velYA = 4;
		}
		if(pointYA < 300) {
			velYA = 4;
			pointYA = 300;
		}
		if(pointYA > 370) {
			velYA = 0;
			pointYA = 370;
		}
		if(hpA <= 0) {
			hpA = 0;
		}
		if(hpBarA/3 <= 0) {
			hpBarA = 0;
		}
		pointXA += velXA;
		pointYA += velYA;
		
		
		
		// playerB
		if(pointXB > 1370) {
			velXB = 0;
			pointXB = 1370;
		}
		if(pointXA+220 > pointXB-73) {
			velXA = 0;
			pointXA = pointXB-220-73;
		}
		if(pointYB < 370) {
			velYB = 4;
		}
		if(pointYB < 300) {
			velYB = 4;
			pointYB = 300;
		}
		if(pointYB > 370) {
			velYB = 0;
			pointYB = 370;
		}
		if(hpB <= 0) { 
			hpB = 0;
		}
		if(hpBarB/3 <= 0) {
			hpBarB = 0;
		}
		pointXB += velXB;
		pointYB += velYB;
		
		repaint();
	}
}
