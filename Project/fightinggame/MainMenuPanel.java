package fightinggame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenuPanel extends JPanel {
	
	private BufferedImage image;
	private BufferedImage logo;
	
	JLabel play;
	JLabel help;
	JLabel quit;
	Clip clip;
	
	public MainMenuPanel() {
		setLayout(null);
		
		try {
			image = ImageIO.read(new File("res/menu.jpg"));
			logo = ImageIO.read(new File("res/fott.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setBackground(Color.BLACK);
		
		play = new JLabel("PLAY", JLabel.CENTER);
		play.setBounds(608, 445, 170, 50);
		play.setFont(new Font("Eight Bit Dragon", Font.BOLD, 36));
		play.setForeground(Color.WHITE);
		play.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				Main.frame.remove(MainMenuPanel.this);
				JPanel panel = new CharacterSelectionPanel();
				Main.frame.add(panel);
				panel.requestFocus();
				Main.frame.validate();
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				play.setForeground(Color.white);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				play.setForeground(Color.red);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.frame.remove(MainMenuPanel.this);
				JPanel panel = new CharacterSelectionPanel();
				Main.frame.add(panel);
				panel.requestFocus();
				Main.frame.validate();
//				isRunning = false;
			}
		});
		add(play);
		
		help = new JLabel("HELP", JLabel.CENTER);
		help.setBounds(608, 495, 170, 50);
		help.setFont(new Font("Eight Bit Dragon", Font.BOLD, 36));
		help.setForeground(Color.WHITE);
		help.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				help.setForeground(Color.white);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				help.setForeground(Color.red);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		add(help);
		
		quit = new JLabel("QUIT", JLabel.CENTER);
		quit.setBounds(608, 545, 170, 50);
		quit.setFont(new Font("Eight Bit Dragon", Font.BOLD, 36));
		quit.setForeground(Color.WHITE);
		quit.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				quit.setForeground(Color.white);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				quit.setForeground(Color.red);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		add(quit);
		
//		try {
//			clip = AudioSystem.getClip();
//			AudioInputStream stream = AudioSystem.getAudioInputStream(new File("res/song.wav"));
//			clip.open(stream);
//			clip.start();
//		} catch(LineUnavailableException | UnsupportedAudioFileException | IOException e1) {
//			e1.printStackTrace();
//		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, 1440, 720, null);
		g.drawImage(logo, 487, 10, 400, 400, null);
	}
}