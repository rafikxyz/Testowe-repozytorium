import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Plansza extends JPanel implements ActionListener{
	
	int licznik=0;
	int szerokosc = 300;
	int wysokosc = 400;
	static Timer timer;
	int delay;
	boolean gora=false;
	boolean dol=false;
	boolean lewo= true;
	boolean prawo=false;
	boolean status=false;
	boolean jedzenie=false;
	int dlWeza=200;
	int pokarmX;
	int pokarmY;
	int wazX[]= new int[dlWeza];
	int wazY[]= new int[dlWeza];
	BufferedImage jablko;
	BufferedImage glowa;
	BufferedImage cialo;
	
	
	public Plansza(){
	super();
	addKeyListener(new KAdapter());
	setPreferredSize(new Dimension(szerokosc, wysokosc));
	setBackground(Color.white);
	setFocusable(true);
	initGame();
	}

 
public void initGame() {
	
	gora=false;
	dol=false;
	prawo=false;
	lewo=true;
	dlWeza=3;
	delay=150;
	
	for (int i = 0; i < dlWeza; i++) {
	wazX[i]=(180 + i*10);
	wazY[i]=180;
	}
	 
dajZarcie();

try {
	jablko = ImageIO.read(new File("jablko.jpg"));
	//glowa = ImageIO.read(new File("head.jpg"));
	//cialo = ImageIO.read(new File("body.jpg"));
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
 
timer = new Timer(delay, this);
}
public void dajZarcie(){
	if (jedzenie==false){
	Random random=new Random();
	pokarmX=random.nextInt(28)*10+10;
	pokarmY=random.nextInt(38)*10+10;
	System.out.println(pokarmX + " "+ pokarmY);
	for (int i=0;i<dlWeza;i++){
	if (pokarmX==wazX[i] && pokarmY==wazY[i]){
	jedzenie=false;
		licznik++;
	System.out.println("dubel zarcia");
	dajZarcie();
	}
	else {
	jedzenie= true;
	}
	}
}
}

protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2d = (Graphics2D) g;
	g2d.setColor(Color.BLACK);
	g2d.fillOval(wazX[0], wazY[0], 10, 10);
	//g2d.drawImage(glowa, wazX[0], wazY[0], this);
	for(int i=1;i<dlWeza;i++){
		//g2d.drawImage(cialo, wazX[i], wazY[i], this);
		g2d.setColor(Color.blue);
		g2d.fillOval(wazX[i],wazY[i] , 10, 10);
	}
	if(jedzenie){
		//g2d.drawOval(pokarmX, pokarmY, 10, 10);
		g2d.drawImage(jablko, pokarmX, pokarmY, this);
	}


}

private void checkCollision(){
	if (wazX[0]==-10||wazX[0]==szerokosc||wazY[0]==-10||wazY[0]==wysokosc){
		Plansza.timer.stop();
		initGame();
	}	
	else 
		for (int i=1;i<dlWeza;i++){
			if (wazX[0]==wazX[i]&&wazY[0]==wazY[i]){
				Plansza.timer.stop();
				initGame();
			}
		}
}
private void checkPokarm(){
	if (wazX[0]==pokarmX&&wazY[0]==pokarmY){
		this.dlWeza+=1;
		jedzenie=false;
		
	}
	
}
public void move(){

	for (int i=dlWeza-1;i>0;i--){
		wazX[i]=wazX[i-1];
		wazY[i]=wazY[i-1];
	}
	if (gora){
		dol=false;
		prawo=false;
		lewo=false;
		wazY[0]-=10;
	}
	if (dol){
		gora=false;
		prawo=false;
		lewo=false;
		wazY[0]+=10;
	} 
	if (prawo){
		gora=false;
		dol=false;
		lewo=false;
		wazX[0]+=10;
	}
	if (lewo){
		gora=false;
		dol=false;
		prawo=false;
		wazX[0]-=10;
	}
	

	}
	
private class KAdapter extends KeyAdapter{
@Override
public void keyPressed(KeyEvent arg0) {
	// TODO Auto-generated method stub
	int key = arg0.getKeyCode();
	if (key==KeyEvent.VK_UP){
		if (dol){}
		else {
		gora=true;
		dol=false;
		prawo=false;
		lewo=false;
		}
		System.out.println("gora");
	} if (key==KeyEvent.VK_DOWN){
		if (gora){}
		else {
		dol=true;
		gora=false;
		prawo=false;
		lewo=false;
		}
		System.out.println("dol");
	} if (key==KeyEvent.VK_RIGHT){
		if (lewo){}
		else {
		prawo=true;
		gora=false;
		dol=false;
		lewo=false;
		}
		System.out.println("prawo");
	} if (key==KeyEvent.VK_LEFT){
		if (lewo){}
		else {
		lewo=true;
		gora=false;
		dol=false;
		prawo=false;
		}
		System.out.println("lewo");
	}

}
@Override
public void keyReleased(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyTyped(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}
}


public void actionPerformed(ActionEvent e) {
//if (status) {
dajZarcie();
move(); 
checkPokarm();
checkCollision();
repaint();


 
}


}
		





