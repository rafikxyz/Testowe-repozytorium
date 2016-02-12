import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ramka extends JFrame {
	static JButton start;
	static JButton pauza;
	public Ramka(){
		super("Wonsz");
		setLayout(new FlowLayout());
		setSize(480,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Plansza plansza = new Plansza();
		
		start = new JButton("START");
		start.setPreferredSize(new Dimension(100,50));
		start.setFocusable(false);
		start.addActionListener(new Start());
		
		pauza = new JButton("PAUZA");
		pauza.setPreferredSize(new Dimension(100,50));
		pauza.setFocusable(false);
		pauza.addActionListener(new Pauza());
		
		add(plansza);
		add(start);
		add(pauza);
		pack();
		setVisible(true);
		 
	}
	 
	private class Start implements ActionListener {
		@Override
	public void actionPerformed(ActionEvent e) {
	//start.setEnabled(false);
	//wyniki.setEnabled(false);
	Plansza.timer.start();
	}
	}

	private class Pauza implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Plansza.timer.stop();
		}
		
	} 
}

