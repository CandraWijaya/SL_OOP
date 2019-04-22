package fightinggame;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public abstract class Character{
	
	protected String name;
	protected ImageIcon img;
	protected ImageIcon imgfw;
	protected ImageIcon imgbw;
	protected ImageIcon imgbasic;
	protected ImageIcon imgblock;
	protected ImageIcon imglose;
	protected int hp;
	protected int saveHp;
	protected int basic;
	protected int xScale, yScale;
	protected int xBasicScale, yBasicScale;
	protected int imgNum, imgBasicNum;
	protected int charNum;
	
	protected String skillName;
	protected int skillDamage;
	
	public Character(String name, ImageIcon img, ImageIcon imgfw, ImageIcon imgbw, ImageIcon imgbasic, ImageIcon imgblock, ImageIcon imglose, 
			int hp, int saveHp, int basic, int xScale, int yScale, int xBasicScale, int yBasicScale, int imgNum, int imgBasicNum, int charNum) {
		super();
		this.name = name;
		this.img = img;
		this.imgfw = imgfw;
		this.imgbw = imgbw;
		this.imgbasic = imgbasic;
		this.imgblock = imgblock;
		this.imglose = imglose;
		this.hp = hp;
		this.saveHp = saveHp;
		this.basic = basic;
		this.xScale = xScale;
		this.yScale = yScale;
		this.xBasicScale = xBasicScale;
		this.yBasicScale = yBasicScale;
		this.imgNum = imgNum;
		this.imgBasicNum = imgBasicNum;
		this.charNum = charNum;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ImageIcon getImg() {
		return img;
	}

	public void setImg(ImageIcon img) {
		this.img = img;
	}

	public ImageIcon getImgfw() {
		return imgfw;
	}

	public void setImgfw(ImageIcon imgfw) {
		this.imgfw = imgfw;
	}

	public ImageIcon getImgbw() {
		return imgbw;
	}

	public void setImgbw(ImageIcon imgbw) {
		this.imgbw = imgbw;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getSaveHp() {
		return saveHp;
	}

	public void setSaveHp(int saveHp) {
		this.saveHp = saveHp;
	}

	public int getBasic() {
		return basic;
	}

	public void setBasic(int basic) {
		this.basic = basic;
	}

	public int getxScale() {
		return xScale;
	}

	public void setxScale(int xScale) {
		this.xScale = xScale;
	}

	public int getyScale() {
		return yScale;
	}

	public void setyScale(int yScale) {
		this.yScale = yScale;
	}

	public int getImgNum() {
		return imgNum;
	}

	public void setImgNum(int imgNum) {
		this.imgNum = imgNum;
	}
	
	public void skill() {
		skillName = "skill";
		skillDamage = 0;
	}
}