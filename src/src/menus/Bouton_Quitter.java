package src.menus;

import javax.swing.*;


public class Bouton_Quitter extends Boutons {
	/**
	 * fenetre à quitter si on utilise cette commande
	 */
	private JFrame fenetre;
	
	public Bouton_Quitter(JFrame fenetre) {
		super();
		this.fenetre = fenetre;
		
		//this.setText(this.getNom());	
		//this.setFont(new Font("Arial", Font.BOLD, 30));
		//this.setForeground(Color.RED);
		
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		
		this.addActionListener(this);
	}
	
	@Override
	public void executer() {
		this.fenetre.dispose();
	}

	@Override
	public String getNom() {
		return "Quitter";
	}

	
	
}
