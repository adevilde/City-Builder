package src.menus;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Commande_Volume extends JSlider implements ChangeListener {

	public Commande_Volume() {
		super();
		
		this.setFont(new Font("Courier", Font.PLAIN, 12));
		
		this.setMaximum(100);
		this.setMinimum(0);
		this.setMajorTickSpacing(10);
		this.setMinorTickSpacing(2);
		
		this.setPaintTicks(true);
		this.setPaintTrack(true);
		this.setPaintLabels(true);
		
		this.setOpaque(false);
		
		this.addChangeListener(this);
		
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		//System.out.println("La valeur du curseur est : " + this.getValue());
		
	}
	
}
