package src.menus;

import java.awt.event.*;

import javax.swing.*;

public abstract class Menu extends JPanel implements ComponentListener {
	
	public Menu() {
		super();
	}
	
	public void afficher() {
		this.setVisible(true);
	}
	
	public void effacer() {
		this.setVisible(false);
	}	
	
	@Override
	public abstract void componentResized(ComponentEvent e);
	
	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
